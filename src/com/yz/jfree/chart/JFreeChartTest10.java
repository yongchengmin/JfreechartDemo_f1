package com.yz.jfree.chart;

import java.awt.BasicStroke;
import java.awt.Color;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import com.yz.jfree.utils.JfreeChartUtils;
//http://fshjie.iteye.com/blog/631888
public class JFreeChartTest10 {

	// 本地测试  
    public static void main(String[] args) {  
//        ChartFrame cf = new ChartFrame("折线图", createChart());  
//        cf.pack();  
//        cf.setVisible(true);  
        
        
    	JFrame frame=new JFrame("折线图");
    	frame.add(new JFreeChartTest10().getChartPanel());    //添加折线图  
	    frame.setBounds(50, 50, 800, 600);  
	    frame.setVisible(true); 
    	
//	    try {
//			outPng();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
    }
    
	ChartPanel frame1;
	static JFreeChart chart;
    public JFreeChartTest10(){
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
     * 创建JFreeChart对象 
     * @return chart 
     */  
    public static JFreeChart createChart() {
    	StandardChartTheme standardChartTheme = JfreeChartUtils.chartTheme(); 
    	ChartFactory.setChartTheme(standardChartTheme);//设置主题样式
    	
    	DefaultCategoryDataset dataSet = createDataSet();
    	//如果把createLineChart改为createLineChart3D就变为了3D效果的折线图       
        JFreeChart  chart = ChartFactory.createLineChart3D("图表标题", "X轴标题", "Y轴标题", dataSet,  
                PlotOrientation.VERTICAL, // 绘制方向  
                true, // 显示图例  
                true, // 采用标准生成器  
                false // 是否生成超链接  
                );  
//        chart.getTitle().setFont(titleFont); // 设置标题字体  
//        chart.getLegend().setItemFont(font);// 设置图例类别字体  
        chart.setBackgroundPaint(Color.decode("#98FB98"));// 设置背景色   
        //获取绘图区对象  
        CategoryPlot plot = chart.getCategoryPlot();  
        plot.setBackgroundPaint(Color.LIGHT_GRAY); // 设置绘图区背景色  
        plot.setRangeGridlinePaint(Color.WHITE); // 设置水平方向背景线颜色  
        plot.setRangeGridlinesVisible(true);// 设置是否显示水平方向背景线,默认值为true  
        plot.setDomainGridlinePaint(Color.WHITE); // 设置垂直方向背景线颜色  
        plot.setDomainGridlinesVisible(true); // 设置是否显示垂直方向背景线,默认值为false  
          
          
        CategoryAxis domainAxis = plot.getDomainAxis();     
//        domainAxis.setLabelFont(font); // 设置横轴字体  
//        domainAxis.setTickLabelFont(font);// 设置坐标轴标尺值字体  
        domainAxis.setLowerMargin(0.01);// 左边距 边框距离  
        domainAxis.setUpperMargin(0.06);// 右边距 边框距离,防止最后边的一个数据靠近了坐标轴。  
        domainAxis.setMaximumCategoryLabelLines(2);  
          
        ValueAxis rangeAxis = plot.getRangeAxis();  
//        rangeAxis.setLabelFont(font);   
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());//Y轴显示整数  
        rangeAxis.setAutoRangeMinimumSize(1);   //最小跨度  
        rangeAxis.setUpperMargin(0.18);//上边距,防止最大的一个数据靠近了坐标轴。     
        rangeAxis.setLowerBound(0);   //最小值显示0  
        rangeAxis.setAutoRange(false);   //不自动分配Y轴数据  
        rangeAxis.setTickMarkStroke(new BasicStroke(1.6f));     // 设置坐标标记大小  
        rangeAxis.setTickMarkPaint(Color.BLACK);     // 设置坐标标记颜色  
        
        // 获取折线对象  
        LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();  
        BasicStroke realLine = new BasicStroke(1.8f); // 设置实线  
        // 设置虚线  
        float dashes[] = { 5.0f };   
        BasicStroke brokenLine = new BasicStroke(2.2f, // 线条粗细  
                BasicStroke.CAP_ROUND, // 端点风格  
                BasicStroke.JOIN_ROUND, // 折点风格  
                8f, dashes, 0.6f);   
        for (int i = 0; i < dataSet.getRowCount(); i++) {  
            if (i % 2 == 0)  
                renderer.setSeriesStroke(i, realLine); // 利用实线绘制  
            else  
                renderer.setSeriesStroke(i, brokenLine); // 利用虚线绘制  
        }  
          
        plot.setNoDataMessage("无对应的数据，请重新查询。");  
//        plot.setNoDataMessageFont(titleFont);//字体的大小  
        plot.setNoDataMessagePaint(Color.RED);//字体颜色 
		return chart;
    }
    
    /** 
     * 创建数据集合 
     * @return dataSet 
     */  
    public static DefaultCategoryDataset createDataSet() {
    	DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
    	dataSet.setValue(2, "今日新闻", "2009年10月");
    	dataSet.setValue(1, "信息", "2009年10月");
    	
    	dataSet.setValue(1, "今日新闻", "2009年11月");
    	dataSet.setValue(1, "信息", "2009年11月");
    	dataSet.setValue(1, "政策", "2009年11月");
    	
    	dataSet.setValue(1, "今日新闻", "2009年12月");
    	dataSet.setValue(1, "办公助手", "2009年12月");
    	dataSet.setValue(2, "政策", "2009年12月");
    	dataSet.setValue(4, "文件", "2009年12月");
    	
    	dataSet.setValue(1, "今日新闻", "2010年1月");
    	dataSet.setValue(2, "信息", "2010年1月");
    	dataSet.setValue(4, "政策", "2010年1月");
    	dataSet.setValue(5, "办公助手", "2010年1月");
    	dataSet.setValue(5, "文件", "2010年1月");
    	
    	dataSet.setValue(1, "信息", "2010年2月");
    	dataSet.setValue(2, "政策", "2010年2月");
    	dataSet.setValue(2, "文件", "2010年2月");
    	dataSet.setValue(3, "今日新闻", "2010年2月");
    	dataSet.setValue(4, "办公助手", "2010年2月");
    	
    	dataSet.setValue(3, "今日新闻", "2010年3月");
    	dataSet.setValue(5, "文件", "2010年3月");
    	dataSet.setValue(9, "办公助手", "2010年3月");
    	dataSet.setValue(8, "信息", "2010年3月");
    	dataSet.setValue(10, "政策", "2010年3月");
		return dataSet;
    }
    
    private static void outPng() throws IOException{
    	//图片是文件格式的,故要用到FileOutputStream用来输出.
    	 OutputStream os = new FileOutputStream("JFreeChartTest10.jpeg");
    	//使用一个面向application的工具类,将chart转换成JPEG格式的图片.第3个参数是宽度,第4个参数是高度.
         ChartUtilities.writeChartAsJPEG(os, new JFreeChartTest10().getJFreeChart(), 1000, 800);
         os.close();//关闭输出流
    }
}
