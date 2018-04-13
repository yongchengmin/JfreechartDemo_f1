package com.yz.jfree.chart;

import java.awt.GridLayout;

import javax.swing.JFrame;
//https://blog.csdn.net/pzhtpf/article/details/7600100/
public class JFreeChartTestMain {
	public static void main(String[] args) {
		JFrame frame=new JFrame("Java数据统计图");  
	    frame.setLayout(new GridLayout(2,2,10,10));  
	    frame.add(new JFreeChartTest6().getChartPanel());           //添加柱形图  ,其中两种展示风格
	    frame.add(new JFreeChartTest5().getChartPanel());          //添加柱形图的另一种效果,展示方式结合了两种  
	    frame.add(new JFreeChartTest7().getChartPanel());           //添加饼状图  
	    frame.add(new JFreeChartTest8().getChartPanel());    //添加折线图  
	    frame.setBounds(50, 50, 800, 600);  
	    frame.setVisible(true); 
	}
}
