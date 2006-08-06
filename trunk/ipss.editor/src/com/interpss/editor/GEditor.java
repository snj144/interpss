package com.interpss.editor;


import java.applet.Applet;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


import com.interpss.common.ui.WinUtilities;
import com.interpss.common.util.IpssLogger;
import com.interpss.editor.coreframework.GPGraphpad;
import com.interpss.editor.coreframework.GPSessionParameters;
import com.interpss.editor.resources.ImageLoader;
import com.interpss.editor.resources.Translator;
import com.interpss.editor.util.SmartFrame;

/**
 * A class with some static methods (including main and init) to properly
 * instanciate a GPGraphpad (actually a GPGraphpad JPanel) which is the main
 * JPanel where mutli JGraph document and GUI are displayed. You can do it
 * either as an application, either as an applet.
 * 
 * @see com.interpss.editor.coreframework.GPGraphpad
 */
public class GEditor extends Applet {

	/**
	 * is properly set by the ant buildfile to ensure the source version match
	 * the binary version
	 */
	
	private static GPSessionParameters sessionParameters;

	/*
	 * Main method for creating a JGraphpad in an application deployed either
	 * offline, either via webstart
	 */
	public static void main(String[] args) {
		// parse cmd line parameters
		parseCmdLineParameters(args);

		// load properties from property files
		boolean ok = true;
		if (!AppConfig.loadAppProperties())
			ok = false;
		if (!AppConfig.userPreConfiguration())
			ok = false;

		if (!ok)
		{			// we need to do something to inform the user
			System.err.println("System configuration has problems, please see the log file for details");
			JOptionPane.showMessageDialog(new JFrame(),
					"Your configuration has problems which prevent the GraphicEditor to start. Please see the log file in the log dir for details", 
					"Configuration Error", JOptionPane.ERROR_MESSAGE);
			return;
		}

		
	 	// start splash ...
		JWindow frame = new JWindow();
		JLabel info = new JLabel(Translator.getString("Splash.Init"), SwingConstants.CENTER);

		showSplash(frame, info);
		showSplashInfo(info,Translator.getString("Splash.Construct"));
		
		// load Spring configuration
		EditorSpringAppContext.springAppContextSetup();
		showSplashInfo(info,Translator.getString("Splash.SpringConfig"));

		// set application contants
	 	AppConfig.setConfigConstants();
		showSplashInfo(info,Translator.getString("Splash.Config"));

		// load ref data from DB
		EditorSpringAppContext.getRefDataManager().loadAllRefData();
		showSplashInfo(info,Translator.getString("Splash.Database"));

		// set the look and feel
		try {
			// Try GTK exlicitley for Java < 1.4.2
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
		} catch (Exception exc) {
			try {
				UIManager.setLookAndFeel(Translator.getString("LookAndFeel.class"));
			} catch (Exception exc2) {
				System.err.println("Error loading LookAndFeel: " + exc);
			}
		}

		// start the main editor window
		showSplashInfo(info,Translator.getString("Splash.Start"));

		try {
			//try to set up a console:
			GPGraphpad pad = EditorSpringAppContext.getGraphicEditor();
			pad.setSessionParameters(sessionParameters);
			pad.init();
			JFrame gpframe = createFrame();
			
			final JPanel panel = new JPanel();
			panel.setLayout(new BorderLayout());
			panel.add(pad, BorderLayout.CENTER);
			panel.setVisible(false);
			gpframe.setExtendedState(JFrame.MAXIMIZED_BOTH);
			gpframe.getContentPane().add(panel, BorderLayout.CENTER);
			
			gpframe.addWindowListener(pad.getAppCloser());
			
			gpframe.setVisible(true);
			pad.initData();
			panel.setVisible(true);
			pad.initActive();
			
		} catch (Exception e) {
			info.setText(e.getMessage());
			e.printStackTrace();
			System.err.println(e.getMessage());
		} finally {
			frame.dispose();
		}
	}

	private static void showSplashInfo(JLabel info,String infoMesssage) {
		info.setText(infoMesssage);
		IpssLogger.getLogger().info(infoMesssage);
	}
	
	/**
	 * By default we put the GPGraphpad in a JFrame
	 * @return
	 */
	public static JFrame createFrame() {
		JFrame frame = new SmartFrame();
		frame.setName("MainGraphpad");
		frame.setIconImage(ImageLoader.getImageIcon(Translator.getString("Icon")).getImage());
		frame.setTitle(Translator.getString("Title"));
		return frame;
	}

	/**
	 * Automatic entry point when deploying JGraphpad as an applet
	 */
	public void init() {
		sessionParameters = new GPSessionParameters();
		setLayout(new BorderLayout());
		setBackground(Color.white);
		JButton button = new JButton("Start");
		button.setIcon(ImageLoader.getImageIcon(Translator.getString("Icon")));
		add(button, BorderLayout.CENTER);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				launchFromApplet();
			}
		});
		button.setPreferredSize(getSize());
		launchFromApplet();
		button.revalidate();
	}
	
	/**
	 * This method is called when the user press the applet button and also
	 * at the applet start up. The button is especially handy to refresh the
	 * applet without having to reload the page.
	 */
	public void launchFromApplet() {
		sessionParameters.setApplet(this);
		GPGraphpad pad = new GPGraphpad(sessionParameters);
		pad.init();
		JFrame gpframe = createFrame();
		gpframe.getContentPane().add(pad);
		gpframe.addWindowListener(pad.getAppCloser());
		gpframe.setVisible(true);
		tryToLoadFile(pad);
	}

	/**
	 * If a file has been specified by command line, applet or webstart
	 * argument, then we try to open it
	 * 
	 * @param pad
	 */
	public static void tryToLoadFile(GPGraphpad pad) {
		sessionParameters = pad.getSessionParameters();
		String downloadPath = sessionParameters.getParam(
				GPSessionParameters.DOWNLOADPATH, false);
		if (downloadPath != null && !downloadPath.equals("")) {
			try {
				/*
				String protocol = sessionParameters.getParam(
						GPSessionParameters.PROTOCOL, true);
				String hostName = sessionParameters.getParam(
						GPSessionParameters.HOSTNAME, true);
				String hostPort = sessionParameters.getParam(
						GPSessionParameters.HOSTPORT, true);
				URL url = new URL(protocol, hostName, Integer
						.parseInt(hostPort), downloadPath);
				 */
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(pad, ex.getLocalizedMessage(),
						Translator.getString("Error"),
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Display the splash picture at startup
	 * 
	 * @param frame
	 * @param info
	 */
	public static void showSplash(JWindow frame, JLabel info) {
		ImageIcon logoIcon = ImageLoader.getImageIcon(Translator
				.getString("Splash"));
		info.setForeground(Color.black);
		JLabel lab = new JLabel(logoIcon) {
			public void paint(Graphics g) {
				super.paint(g);

				Graphics2D g2 = (Graphics2D) g;
				g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
						RenderingHints.VALUE_ANTIALIAS_ON);

				g2.setFont(new Font("Arial", Font.BOLD, 27));
				g2.setColor(Color.DARK_GRAY.darker());
				Composite originalComposite = g2.getComposite();
				g2.setComposite(AlphaComposite.getInstance(
						AlphaComposite.SRC_OVER, 0.5f));

				g2.setFont(new Font("Arial", Font.PLAIN, 10));

				g2.drawString(Translator.getString("Prog.version"), 18, 172);

				g2.setColor(Color.DARK_GRAY);
				g2.setFont(new Font("Arial", Font.BOLD, 8));
				String copyright = Translator.getString("Copyright");
				if (copyright != null)
					g2.drawString(copyright, 10, 202);
				g2.setComposite(originalComposite);
			}
		};

		frame.getContentPane().add(lab, BorderLayout.CENTER);
		lab.setLayout(new BorderLayout());
		lab.add(info, BorderLayout.SOUTH);
		lab.setBorder(BorderFactory.createRaisedBevelBorder());
		info.setVerticalAlignment(SwingConstants.CENTER);
		info.setHorizontalAlignment(SwingConstants.CENTER);
		info.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0));
		info.setPreferredSize(new Dimension(lab.getWidth(), 24));
		info.setForeground(Color.WHITE);
		frame.pack();
		WinUtilities.center(frame);
		frame.setVisible(true);
//		showSplashInfo(info,Translator.getString("Splash.Start"));
	}

	private static void parseCmdLineParameters(String[] args) {
		// we set up the session parameters
		sessionParameters = new GPSessionParameters();
		for (int i = 0; i < args.length; i = i + 2) {

			if (args[i].indexOf("-") < 0) {// simple precaution in case
											// arguments aren't well formed
				i = i - 1;
				continue;
			}
			sessionParameters.setParamWithCommand(args[i], args[i + 1]);
		}		
	}
}
