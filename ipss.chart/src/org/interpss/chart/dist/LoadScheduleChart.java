/* ------------------
 * XYSeriesDemo2.java
 * ------------------
 * (C) Copyright 2002-2004, by Object Refinery Limited.
 *
 */

package org.interpss.chart.dist;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.interpss.common.ui.WinUtilities;

/**
 * Demo for {@link XYSeries}, where all the y values are the same.
 */
public class LoadScheduleChart extends JFrame {
	public static int Chart_Width = 800;
	public static int Chart_Height = 500;
	
	private String xLabel = "Point";
	private String plotTitle = "Load Voltage, P, Q Plot";

	private double[] voltDataAry;
	private String   voltDataLabel;
	private String   voltYLabel = "Voltage";
	private final Color    vColor = Color.BLACK;
	
	private String   pqYLabel = "Load P, Q";
	private double[] pDataAry;
	private String   pDataLabel = "P";
	private final Color    pColor = Color.BLUE;

	private double[] qDataAry;
	private String   qDataLabel = "Q";
	private final Color    qColor = Color.GREEN;

    /**
     * A demonstration application showing an {@link XYSeries} where all the y-values are the same.
     *
     * @param title  the frame title.
     */
    public LoadScheduleChart(final String title) {
        super(title);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
    
    public void showChart() {
        pack();
        WinUtilities.center(this);
        setVisible(true);
    }
    
    public void setVoltageData(final String label, final double[] data) {
    	voltDataLabel = label;
    	voltDataAry = data;
    }
    
	public void setVoltYLabel(final String label) {
		voltYLabel = label;
	}

    public void setPQData(final String pLabel, final String qLabel, final double[] pdata, final double[] qdata) {
    	pDataLabel = pLabel;
    	pDataAry = pdata;
    	qDataLabel = qLabel;
    	qDataAry = qdata;
    }
    
	public void setPYLabel(final String label) {
		pqYLabel = label;
	}
	
	public void setXLabel(final String label) {
		xLabel = label;
	}
	
	public void setPlotTitle(final String title) {
		plotTitle = title;
	}

	public void setDimension(final int h, final int w) {
		Chart_Height = h;
		Chart_Width = w;
	}
	
    public XYDataset createDataSet(final double[] dataAry, final String label) {
        final XYSeries series = new XYSeries(label);
        for (int i = 0; i < dataAry.length; i++) {
            series.add(i, dataAry[i]);
        }
        series.add(dataAry.length, voltDataAry[dataAry.length-1]);
        return new XYSeriesCollection(series);
    }
        
    public void createChart() {
        final JFreeChart chart = ChartFactory.createXYLineChart(
            	plotTitle,
                xLabel, 
                voltYLabel, 
                createDataSet(voltDataAry, voltDataLabel),
                PlotOrientation.VERTICAL,
                true,
                false,
                false
            );

        
        final XYPlot plot = (XYPlot) chart.getPlot();
        final XYStepRenderer renderer = new XYStepRenderer();
        renderer.setToolTipGenerator(new StandardXYToolTipGenerator());
        plot.setRenderer(renderer);        
        
        //NumberAxis axis_x = (NumberAxis) plot.getDomainAxis();
        //axis_x.setRangeAboutValue(12.0, 24.0);
        
        final NumberAxis axisLeft = (NumberAxis) plot.getRangeAxis();
        axisLeft.setAutoRangeIncludesZero(false);
        axisLeft.setAutoRangeMinimumSize(1.0);

        final NumberAxis axisRight = new NumberAxis(pqYLabel);
        axisRight.setAutoRangeIncludesZero(false);
        axisRight.setAutoRangeMinimumSize(1.0);
        plot.setRangeAxis(1, axisRight);

        final XYItemRenderer v_renderer = plot.getRenderer(0);
        v_renderer.setSeriesPaint(0, vColor);

        plot.setDataset(1, createDataSet(pDataAry, pDataLabel));
        plot.mapDatasetToRangeAxis(1, 1);
        final XYStepRenderer p_renderer = new XYStepRenderer();
        p_renderer.setSeriesPaint(0, pColor);
        p_renderer.setBaseShapesVisible(false);
        plot.setRenderer(1, p_renderer);
        
        plot.setDataset(2, createDataSet(qDataAry, qDataLabel));
        plot.mapDatasetToRangeAxis(2, 1);
        final XYStepRenderer q_renderer = new XYStepRenderer();
        q_renderer.setSeriesPaint(0, qColor);
        q_renderer.setBaseShapesVisible(false);
        plot.setRenderer(2, q_renderer);
        
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(Chart_Width, Chart_Height));
        setContentPane(chartPanel);
    }

    /**
     * Starting point for the demonstration application.
     *
     * @param args  ignored.
     */
    public static void main(final String[] args) {
    	final LoadScheduleChart plot = new LoadScheduleChart("Bus Load Schedule");
    	
    	final double[] vdata = new double[24];
    	for (int i = 0; i < 24; i++) {
    		vdata[i] = i;
    	}
    	plot.setVoltageData("voltage", vdata);
    	
    	final double[] pdata = new double[24];
    	final double[] qdata = new double[24];
    	for (int i = 0; i < 24; i++) {
    		pdata[i] = 24-i;
    		qdata[i] = 30-i;
    	}
    	plot.setPQData("Load P", "Load Q", pdata, qdata);

    	plot.createChart();
    	plot.showChart();
    }
}
