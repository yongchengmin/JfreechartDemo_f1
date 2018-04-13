package com.yz.jfree.chart;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import com.yz.jfree.utils.JfreeChartUtils;
//https://blog.csdn.net/liutong123987/article/details/78888333
public class JFreeChartTest4 {

	// 本地测试  
    public static void main(String[] args) {  
        ChartFrame cf = new ChartFrame("Test", createChart());  
        cf.pack();  
        cf.setVisible(true);  
    }
    ChartPanel frame1;
    public JFreeChartTest4(){
    	frame1=new ChartPanel(createChart(),true);
    }
    public ChartPanel getChartPanel(){  
		return frame1;  
	}
	/** 
     * 创建数据集合 
     * @return dataSet 
     */  
    public static CategoryDataset createDataSet() {  
        // 实例化DefaultCategoryDataset对象  
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();  
        // 向数据集合中添加数据  
        dataSet.addValue(500, "Java图书", "J2SE类");  
        dataSet.addValue(100, "Java图书", "J2ME类");  
        dataSet.addValue(900, "Java图书", "J2EE类");  
        return dataSet;  
    } 
    
    /** 
     * 创建JFreeChart对象 
     * @return chart 
     */  
    public static JFreeChart createChart() { 
    	StandardChartTheme standardChartTheme = JfreeChartUtils.chartTheme(); 
    	ChartFactory.setChartTheme(standardChartTheme);//设置主题样式  
        // 通过ChartFactory创建JFreeChart  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                "Java图书销量统计", //图表标题  
                "Java图书", //横轴标题  
                "销量(本)",//纵轴标题  
                createDataSet(),//数据集合  
                PlotOrientation.VERTICAL, //图表方向  
                true,//是否显示图例标识  
                false,//是否显示tooltips  
                false);//是否支持超链接  
        return chart;  
    }
}
