/* ------------------
 * XYSeriesDemo2.java
 * ------------------
 * (C) Copyright 2002-2004, by Object Refinery Limited.
 *
 */

package org.interpss.chart.dstab;

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
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

import com.interpss.common.ui.WinUtilities;

/**
 * Demo for {@link XYSeries}, where all the y values are the same.
 */
public class SimpleOneStateChart extends JFrame {
	public static int Chart_Width = 800;
	public static int Chart_Height = 500;
	
	private String plotTitle = "Machine State";

	private double[] xDataAry;
	private String xLabel = "Time in Sec";

	private double[] yDataAry;
	private String   yDataLabel;
	private String   yLabel = "State";
	private final Color    yColor = Color.BLACK;
	
	private double autoRangeMinimumSize = 0.2;
	
    /**
     * A demonstration application showing an {@link XYSeries} where all the y-values are the same.
     *
     * @param title  the frame title.
     */
    public SimpleOneStateChart(final String title) {
        super(title);
        setPlotTitle(title);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
	}
    
    public void showChart() {
        pack();
        WinUtilities.center(this);
        setVisible(true);
    }
    
    public void setPlotData(final String yLabel, final String yDataLabel, 
    		final double[] xData, final double[] yData, double autoRangeMinimumSize) {
    	this.yLabel = yLabel;
    	this.yDataLabel = yDataLabel;
    	this.xDataAry = xData;
    	this.yDataAry = yData;
    	this.autoRangeMinimumSize = autoRangeMinimumSize;
    }
    
	public void setYLabel(final String label) {
		yLabel = label;
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
	
    public XYDataset createDataSet(final double[] xData, final double[] yData, final String label) {
        final XYSeries series = new XYSeries(label);
        for (int i = 0; i < xDataAry.length; i++) {
            series.add(xData[i], yData[i]);
        }
        return new XYSeriesCollection(series);
    }
        
    public void createChart() {
        final JFreeChart chart = ChartFactory.createXYLineChart(
            	plotTitle,
                xLabel, 
                yLabel, 
                createDataSet(xDataAry, yDataAry, yDataLabel),
                PlotOrientation.VERTICAL,
                true,
                false,
                false
            );

        
        final XYPlot plot = (XYPlot) chart.getPlot();
        final StandardXYItemRenderer renderer = new StandardXYItemRenderer();
        renderer.setToolTipGenerator(new StandardXYToolTipGenerator());
        plot.setRenderer(renderer);        
        
        //NumberAxis axis_x = (NumberAxis) plot.getDomainAxis();
        //axis_x.setRangeAboutValue(12.0, 24.0);
        
        final NumberAxis axisLeft = (NumberAxis) plot.getRangeAxis();
        axisLeft.setAutoRangeIncludesZero(false);
        axisLeft.setAutoRangeMinimumSize(autoRangeMinimumSize);

        final XYItemRenderer v_renderer = plot.getRenderer(0);
        v_renderer.setSeriesPaint(0, yColor);

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
    	final SimpleOneStateChart plot = new SimpleOneStateChart("Bus Load Schedule");
    	
    	final double[] xData = new double[100];
    	final double[] yData = new double[100];
    	for (int i = 0; i < 100; i++) {
    		xData[i] = 10.0 * (100-i) / 100.0;
    		yData[i] = i;
    	}
    	plot.setPlotData("Machine State", "Machine State Data lable", xData, yData, 0.2);
    	
    	plot.createChart();
    	plot.showChart();
    }
}
