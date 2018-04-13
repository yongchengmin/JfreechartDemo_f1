package com.yz.jfree.chart;

import java.awt.Color;
import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.TextAnchor;

import com.yz.jfree.utils.JfreeChartUtils;
//https://blog.csdn.net/lifupingcn/article/details/52814420
public class JFreeChartTest9 {
	// 本地测试  
    public static void main(String[] args) {  
//        ChartFrame cf = new ChartFrame("折线图", createChart());  
//        cf.pack();  
//        cf.setVisible(true);  
        
        
//      JFrame frame=new JFrame("折线图");
//      frame.add(new JFreeChartTest9().getChartPanel());    //添加折线图  
//	    frame.setBounds(50, 50, 800, 600);  
//	    frame.setVisible(true); 
    	
	    try {
			outPng();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
	ChartPanel frame1;
	static JFreeChart chart;
    public JFreeChartTest9(){
    	chart = createChart();
    	frame1=new ChartPanel(chart,true);
    }
    public ChartPanel getChartPanel(){  
		return frame1;  
	}
    public JFreeChart getJFreeChart(){
    	return chart;
    }
    /** 
     * 创建数据集合 
     * @return dataSet 
     */  
    @SuppressWarnings("deprecation")
	public static TimeSeriesCollection createDataSet() {
    	// A网站的访问量统计  
        TimeSeries timeSeries=new TimeSeries("A网站访问量统计", Month.class);  
        // 添加数据  如果你是从数据库中获取数据，你就写个循环塞值就行了。  
        timeSeries.add(new Month(1,2013), 100);  
        timeSeries.add(new Month(2,2013), 200);  
        timeSeries.add(new Month(3,2013), 300);  
        timeSeries.add(new Month(4,2013), 400);  
        timeSeries.add(new Month(5,2013), 560);  
        timeSeries.add(new Month(6,2013), 600);  
        timeSeries.add(new Month(7,2013), 750);  
        timeSeries.add(new Month(8,2013), 890);  
        timeSeries.add(new Month(9,2013), 120);  
        timeSeries.add(new Month(10,2013), 400);  
        timeSeries.add(new Month(11,2013), 1200);  
        timeSeries.add(new Month(12,2013), 1600);  
          
        // B网站的访问量统计  
        TimeSeries timeSeries2=new TimeSeries("B网站访问量统计", Month.class);  
        // 添加数据  
        timeSeries2.add(new Month(1,2013), 50);  
        timeSeries2.add(new Month(2,2013), 100);  
        timeSeries2.add(new Month(3,2013), 150);  
        timeSeries2.add(new Month(4,2013), 200);  
        timeSeries2.add(new Month(5,2013), 220);  
        timeSeries2.add(new Month(6,2013), 300);  
        timeSeries2.add(new Month(7,2013), 340);  
        timeSeries2.add(new Month(8,2013), 400);  
        timeSeries2.add(new Month(9,2013), 450);  
        timeSeries2.add(new Month(10,2013), 500);  
        timeSeries2.add(new Month(11,2013), 70);  
        timeSeries2.add(new Month(12,2013), 800);
        
     // B网站的访问量统计  
        //如果有更多的就继续添加就行了  
        TimeSeries timeSeries3=new TimeSeries("D网站访问量统计", Month.class);  
        // 添加数据  
        timeSeries3.add(new Month(1,2013), 80);  
        timeSeries3.add(new Month(2,2013), 200);  
        timeSeries3.add(new Month(3,2013), 240);  
        timeSeries3.add(new Month(4,2013), 310);  
        timeSeries3.add(new Month(5,2013), 330);  
        timeSeries3.add(new Month(6,2013), 410);  
        timeSeries3.add(new Month(7,2013), 430);  
        timeSeries3.add(new Month(8,2013), 510);  
        timeSeries3.add(new Month(9,2013), 530);  
        timeSeries3.add(new Month(10,2013), 560);  
        timeSeries3.add(new Month(11,2013), 90);  
        timeSeries3.add(new Month(12,2013), 2000);
          
        // 定义时间序列的集合  
        TimeSeriesCollection lineDataset=new TimeSeriesCollection();  
        lineDataset.addSeries(timeSeries);  
        lineDataset.addSeries(timeSeries2);
        lineDataset.addSeries(timeSeries3);
		return lineDataset;
    }
    /** 
     * 创建JFreeChart对象 
     * @return chart 
     */  
    @SuppressWarnings("deprecation")
	public static JFreeChart createChart() {
    	StandardChartTheme standardChartTheme = JfreeChartUtils.chartTheme(); 
    	ChartFactory.setChartTheme(standardChartTheme);//设置主题样式
    	
    	JFreeChart chart=ChartFactory.createTimeSeriesChart("访问量统计时间折线图", "月份", "访问量", createDataSet(), true, true, true);  
        
        //设置主标题  
        chart.setTitle(new TextTitle("A,B网站访问量统计对比图", new Font("隶书", Font.ITALIC, 15)));   
        //设置子标题  
        TextTitle subtitle = new TextTitle("2016年度", new Font("黑体", Font.BOLD, 12));  
        chart.addSubtitle(subtitle);   
        chart.setAntiAlias(true);   
//        chart.setBackgroundPaint(Color.green);// 设置背景色
          
        //设置时间轴的范围。  
        XYPlot plot = (XYPlot) chart.getPlot();   
        DateAxis dateaxis = (DateAxis)plot.getDomainAxis();  
        dateaxis.setDateFormatOverride(new java.text.SimpleDateFormat("M月"));  
        dateaxis.setTickUnit(new DateTickUnit(DateTickUnit.MONTH,1));   
          
        //设置曲线是否显示数据点  
        XYLineAndShapeRenderer xylinerenderer = (XYLineAndShapeRenderer)plot.getRenderer();  
        xylinerenderer.setBaseShapesVisible(true);   
          
        //设置曲线显示各数据点的值  
        XYItemRenderer xyitem = plot.getRenderer();   
        xyitem.setBaseItemLabelsVisible(true);  
        xyitem.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_CENTER));   
        xyitem.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());  
        xyitem.setBaseItemLabelFont(new Font("Dialog", 1, 12));   
        plot.setRenderer(xyitem);
        
        plot.setBackgroundPaint(Color.LIGHT_GRAY); // 设置绘图区背景色  
        plot.setRangeGridlinePaint(Color.WHITE); // 设置水平方向背景线颜色  
        plot.setRangeGridlinesVisible(true);// 设置是否显示水平方向背景线,默认值为true  
        plot.setDomainGridlinePaint(Color.WHITE); // 设置垂直方向背景线颜色  
        plot.setDomainGridlinesVisible(true); // 设置是否显示垂直方向背景线,默认值为false
		return chart;  
    }
    
    private static void outPng() throws IOException{
    	//图片是文件格式的,故要用到FileOutputStream用来输出.
    	 OutputStream os = new FileOutputStream("JFreeChartTest9.jpeg");
    	//使用一个面向application的工具类,将chart转换成JPEG格式的图片.第3个参数是宽度,第4个参数是高度.
         ChartUtilities.writeChartAsJPEG(os, new JFreeChartTest9().getJFreeChart(), 1000, 800);
         os.close();//关闭输出流
    }
}
