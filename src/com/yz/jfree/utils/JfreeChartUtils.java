package com.yz.jfree.utils;

import java.awt.Font;

import org.jfree.chart.StandardChartTheme;

public class JfreeChartUtils {

	public static StandardChartTheme chartTheme(){
		StandardChartTheme standardChartTheme = new StandardChartTheme("CN"); //创建主题样式  
        standardChartTheme.setExtraLargeFont(new Font("隶书", Font.BOLD, 20)); //设置标题字体  
        standardChartTheme.setRegularFont(new Font("宋体", Font.PLAIN, 15)); //设置图例的字体  
        standardChartTheme.setLargeFont(new Font("宋体", Font.PLAIN, 15)); //设置轴向的字体  
		return standardChartTheme;
	}
}
