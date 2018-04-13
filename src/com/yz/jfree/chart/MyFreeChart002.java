package com.yz.jfree.chart;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.TextAnchor;
import org.jfree.ui.VerticalAlignment;

import com.yz.jfree.utils.JfreeChartUtils;

public class MyFreeChart002 {

	// 本地测试  
    public static void main(String[] args) {  
//        ChartFrame cf = new ChartFrame("折线图", createChart());  
//        cf.pack();  
//        cf.setVisible(true);  
        
        
    	JFrame frame=new JFrame("折线图");
    	frame.add(new MyFreeChart002().getChartPanel());    //添加折线图  
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
    public MyFreeChart002(){
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
    	
    	// 通过ChartFactory创建JFreeChart  
        JFreeChart chart = ChartFactory.createBarChart3D(  
                "装车单占比时间分布", //图表标题  
                "日期", //横轴标题  
                "占比个数",//纵轴标题  
                createDataSet(),//数据集合  
                PlotOrientation.VERTICAL, //图表方向  
                true,//是否显示图例标识  
                true,//是否显示tooltips  
                false);//是否支持超链接  
        // 背景图片  
        Image image = null;  
        try {  
            // 创建背景图片  
            image = ImageIO.read(JFreeChartTest5.class.getResource("theme.jpg"));  
        } catch (IOException e){  
            e.printStackTrace();  
        }  
        chart.getTitle().setFont(new Font("隶书", Font.BOLD, 25)); // 设置标题字体  
        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 12)); // 设置图例类别字体  
        chart.setBorderVisible(true); // 设置显示边框  
        TextTitle subTitle = new TextTitle("2018年3月新港装车单时效占比分布");//实例化TextTitle对象  
        subTitle.setVerticalAlignment(VerticalAlignment.BOTTOM); //设置居中显示  
        chart.addSubtitle(subTitle);//添加子标题  
        chart.setTextAntiAlias(false);
        CategoryPlot plot = chart.getCategoryPlot(); // 获取绘图区对象  
        plot.setForegroundAlpha(0.8F);//设置绘图区前景色透明度  
        plot.setBackgroundAlpha(0.5F);//设置绘图区背景色透明度  
        plot.setBackgroundImage(image);//设置绘图区背景图片  
        //设置网格竖线颜色 
        plot.setDomainGridlinePaint(Color.blue); 
        plot.setDomainGridlinesVisible(true); 
        //设置网格横线颜色 
        plot.setRangeGridlinePaint(Color.blue); 
        plot.setRangeGridlinesVisible(true); 
        //图片背景色 
        plot.setBackgroundPaint(Color.LIGHT_GRAY); 
        plot.setOutlineVisible(true); 
        //图边框颜色 
        plot.setOutlinePaint(Color.magenta); 
        
        CategoryAxis categoryAxis = plot.getDomainAxis();//获取坐标轴对象  
        categoryAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));//设置坐标轴标题字体  
        categoryAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 12));//设置坐标轴尺值字体  
        categoryAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);// 设置坐标轴标题旋转角度  
        ValueAxis valueAxis = plot.getRangeAxis();// 设置数据轴对象  
        valueAxis.setLabelFont(new Font("宋体", Font.PLAIN, 12));  
        
        BarRenderer3D renderer = new BarRenderer3D();  
        renderer.setItemMargin(0.32); // 设置柱间的间距  
        
//        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
//        renderer.setBaseItemLabelsVisible(true); 
//        renderer.setBaseItemLabelPaint(Color.BLUE);//设置数值颜色，默认黑色 
        
        //边框颜色 
        renderer.setBaseOutlinePaint(Color.ORANGE); 
        renderer.setDrawBarOutline(true); 
        //设置墙体颜色 
        renderer.setWallPaint(Color.gray);; 
        
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
        renderer.setBaseItemLabelsVisible(true); 
        renderer.setBaseItemLabelPaint(Color.BLACK);//设置数值颜色,默认黑色 
        //搭配ItemLabelAnchor TextAnchor 这两项能达到不同的效果，但是ItemLabelAnchor最好选OUTSIDE，因为INSIDE显示不出来 
        renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.CENTER_LEFT)); 
        //下面可以进一步调整数值的位置，但是得根据ItemLabelAnchor选择情况. 
        renderer.setItemLabelAnchorOffset(10); 
        
        plot.setRenderer(renderer);// 设置图片渲染对象    
        return chart;  
    }
    
    /** 
     * 创建数据集合 
     * @return dataSet 
     */  
    public static CategoryDataset createDataSet() {  
        // 实例化DefaultCategoryDataset对象  
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();  
        // 添加第一季度数据  
        dataSet.addValue(19302, "1-", "2018-03-X");  
        // 添加第二季度数据  
        dataSet.addValue(83, "1~10", "2018-03-09");  
        dataSet.addValue(83, "1~10", "2018-03-10");  
        dataSet.addValue(83, "1~10", "2018-03-24");
        dataSet.addValue(83, "1~10", "2018-03-25");
        dataSet.addValue(83, "1~10", "2018-03-30");
        dataSet.addValue(83, "1~10", "2018-03-31");
        // 添加第三季度数据  
        dataSet.addValue(134, "10~30", "2018-03-10");  
        dataSet.addValue(134, "10~30", "2018-03-24");  
        dataSet.addValue(134, "10~30", "2018-03-25");  
        dataSet.addValue(134, "10~30", "2018-03-30");
        dataSet.addValue(134, "10~30", "2018-03-31");
        // 添加第四季度数据  
        dataSet.addValue(42, "30~60", "2018-03-24");  
        dataSet.addValue(42, "30~60", "2018-03-25");   
        dataSet.addValue(42, "30~60", "2018-03-31");  
        
        dataSet.addValue(4, "60+", "2018-03-10");  
        return dataSet;  
    } 
    
    private static void outPng() throws IOException{
    	//图片是文件格式的,故要用到FileOutputStream用来输出.
    	 OutputStream os = new FileOutputStream("MyFreeChart002.jpeg");
    	//使用一个面向application的工具类,将chart转换成JPEG格式的图片.第3个参数是宽度,第4个参数是高度.
         ChartUtilities.writeChartAsJPEG(os, new MyFreeChart002().getJFreeChart(), 1000, 800);
         os.close();//关闭输出流
    }
}
