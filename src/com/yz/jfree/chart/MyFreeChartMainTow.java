package com.yz.jfree.chart;

import java.awt.GridLayout;

import javax.swing.JFrame;

public class MyFreeChartMainTow {
	public static void main(String[] args) {
		JFrame frame=new JFrame("新港装车单数据统计图");  
	    frame.setLayout(new GridLayout(1,2,10,10));  
	    frame.add(new MyFreeChart001().getChartPanel());        
	    frame.add(new MyFreeChart002().getChartPanel());  
	    frame.setBounds(50, 50, 800, 600);  
	    frame.setVisible(true);
	}
}
