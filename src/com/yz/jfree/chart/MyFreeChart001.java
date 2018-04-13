package com.yz.jfree.chart;

import java.awt.Font;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

import com.yz.jfree.utils.JfreeChartUtils;

public class MyFreeChart001 {
	// 本地测试  
    public static void main(String[] args) {
//    	JFrame frame=new JFrame("Java数据统计图-饼状图");
//    	frame.add(new MyFreeChart001().getChartPanel());
//    	frame.setBounds(50, 50, 800, 600);
//    	frame.setVisible(true);
    	
    	try {
			outPng();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    static ChartPanel frame1;
	static JFreeChart chart;
    public MyFreeChart001(){
    	chart = createChart();
    	frame1=new ChartPanel(chart,true);
    }
    public ChartPanel getChartPanel(){  
		return frame1;  
	}
    public JFreeChart getJFreeChart(){
    	return chart;
    }
    
	public static JFreeChart createChart(){
		StandardChartTheme standardChartTheme = JfreeChartUtils.chartTheme(); 
    	ChartFactory.setChartTheme(standardChartTheme);//设置主题样式 
    	
    	DefaultPieDataset data = getDataSet();  
        JFreeChart chart = ChartFactory.createPieChart3D("装车单间隔个数分布(min/占比)",data,true,false,false);  
        //设置百分比  
        PiePlot pieplot = (PiePlot) chart.getPlot();  
        DecimalFormat df = new DecimalFormat("0.00%");//获得一个DecimalFormat对象,主要是设置小数问题  
        NumberFormat nf = NumberFormat.getNumberInstance();//获得一个NumberFormat对象  
        //获得StandardPieSectionLabelGenerator对象
        StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);  
        pieplot.setLabelGenerator(sp1);//设置饼图显示百分比  
      
        //没有数据的时候显示的内容  
        pieplot.setNoDataMessage("无数据显示");  
        pieplot.setCircular(false);  
        pieplot.setLabelGap(0.02D);  
      
        pieplot.setIgnoreNullValues(true);//设置不显示空值  
        pieplot.setIgnoreZeroValues(true);//设置不显示负值  
        frame1=new ChartPanel (chart,true);  
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
        PiePlot piePlot= (PiePlot) chart.getPlot();//获取图表区域对象  
        piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));//解决乱码  
        chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
        
        return chart;
	}
	
	private static DefaultPieDataset getDataSet() {  
        DefaultPieDataset dataset = new DefaultPieDataset();  
        dataset.setValue("60+",4);  
        dataset.setValue("30~60",42);  
        dataset.setValue("10~30",134);  
        dataset.setValue("1~10",83);  
        dataset.setValue("1-",19302);  
        return dataset;  
	} 
	private static void outPng() throws IOException{
    	//图片是文件格式的,故要用到FileOutputStream用来输出.
    	 OutputStream os = new FileOutputStream("MyFreeChart001.jpeg");
    	//使用一个面向application的工具类,将chart转换成JPEG格式的图片.第3个参数是宽度,第4个参数是高度.
         ChartUtilities.writeChartAsJPEG(os, new MyFreeChart001().getJFreeChart(), 1000, 800);
         os.close();//关闭输出流
    }
}
