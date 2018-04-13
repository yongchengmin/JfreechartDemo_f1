package com.yz.jfree.chart;

import java.awt.Font;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;  
  
import javax.swing.JButton;  
import javax.swing.JFrame;  
import javax.swing.JLabel;  
import javax.swing.JPanel;  
import javax.swing.JScrollPane;  
import javax.swing.JTextField;  
import javax.swing.SwingUtilities;  
import javax.swing.UIManager;  
  
//import org.dyno.visual.swing.layouts.Bilateral;  
//import org.dyno.visual.swing.layouts.Constraints;  
//import org.dyno.visual.swing.layouts.GroupLayout;  
//import org.dyno.visual.swing.layouts.Leading;  
import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.plot.PiePlot;  
import org.jfree.data.general.DefaultPieDataset;  
import org.jfree.data.general.PieDataset; 
//https://blog.csdn.net/lushuaiyin/article/details/6908181
public class SwingJFreeChart001 extends JFrame{
	 private static final long serialVersionUID = 1L;  
	    private JPanel jPanel0;//JFreeChart  
	    private JScrollPane jScrollPane0;  
	    private JButton jButton0;  
	    private JLabel jLabel0;  
	    private JTextField jTextField0;  
	    private JTextField jTextField1;  
	    private JTextField jTextField2;  
	    private JTextField jTextField3;  
	    private JTextField jTextField4;  
	    private JTextField jTextField5;  
	    private JTextField jTextField6;  
	    private JTextField jTextField7;  
	    private JTextField jTextField8;  
	    private JTextField jTextField9;  
	    private JTextField jTextField10;  
	    private JTextField jTextField11;  
	    private JLabel jLabel7;  
	    private JLabel jLabel8;  
	    private JTextField jTextField12;  
	    private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";  
	    public SwingJFreeChart001() {  
	        initComponents();  
	    }  
	  
	    private void initComponents() {  
//	        setLayout(new GroupLayout());  
//	        add(getJPanel0(), new Constraints(new Leading(6, 588, 10, 10), new Bilateral(8, 12, 55)));  
//	        add(getJTextField0(), new Constraints(new Leading(655, 59, 10, 10), new Leading(104, 12, 12)));  
//	        add(getJTextField1(), new Constraints(new Leading(655, 58, 12, 12), new Leading(146, 10, 10)));  
//	        add(getJTextField2(), new Constraints(new Leading(655, 58, 12, 12), new Leading(186, 12, 12)));  
//	        add(getJTextField3(), new Constraints(new Leading(655, 58, 12, 12), new Leading(228, 10, 10)));  
//	        add(getJTextField4(), new Constraints(new Leading(655, 58, 12, 12), new Leading(277, 10, 10)));  
//	        add(getJTextField5(), new Constraints(new Leading(655, 58, 12, 12), new Leading(321, 10, 10)));  
//	        add(getJLabel7(), new Constraints(new Leading(664, 12, 12), new Leading(62, 10, 10)));  
//	        add(getJLabel8(), new Constraints(new Leading(774, 10, 10), new Leading(60, 10, 10)));  
//	        add(getJButton0(), new Constraints(new Leading(698, 10, 10), new Leading(387, 10, 10)));  
//	        add(getJTextField6(), new Constraints(new Leading(766, 64, 10, 10), new Leading(104, 12, 12)));  
//	        add(getJTextField7(), new Constraints(new Leading(766, 64, 12, 12), new Leading(146, 12, 12)));  
//	        add(getJTextField8(), new Constraints(new Leading(766, 64, 12, 12), new Leading(182, 10, 10)));  
//	        add(getJTextField9(), new Constraints(new Leading(766, 64, 12, 12), new Leading(226, 12, 12)));  
//	        add(getJTextField11(), new Constraints(new Leading(766, 64, 12, 12), new Leading(277, 12, 12)));  
//	        add(getJTextField12(), new Constraints(new Leading(763, 63, 10, 10), new Leading(325, 10, 10)));  
	        setSize(866, 464);  
	    }  
	  
	    private JTextField getJTextField12() {  
	        if (jTextField12 == null) {  
	            jTextField12 = new JTextField();  
	            jTextField12.setText("6.0");  
	        }  
	        return jTextField12;  
	    }  
	  
	    private JLabel getJLabel8() {  
	        if (jLabel8 == null) {  
	            jLabel8 = new JLabel();  
	            jLabel8.setText("数据");  
	        }  
	        return jLabel8;  
	    }  
	  
	    private JLabel getJLabel7() {  
	        if (jLabel7 == null) {  
	            jLabel7 = new JLabel();  
	            jLabel7.setText("数据项");  
	        }  
	        return jLabel7;  
	    }  
	  
	    private JTextField getJTextField11() {  
	        if (jTextField11 == null) {  
	            jTextField11 = new JTextField();  
	            jTextField11.setText("5.0");  
	        }  
	        return jTextField11;  
	    }  
	  
	    private JTextField getJTextField10() {  
	        if (jTextField10 == null) {  
	            jTextField10 = new JTextField();  
	            jTextField10.setText("0.0");  
	        }  
	        return jTextField10;  
	    }  
	  
	    private JTextField getJTextField9() {  
	        if (jTextField9 == null) {  
	            jTextField9 = new JTextField();  
	            jTextField9.setText("4.0");  
	        }  
	        return jTextField9;  
	    }  
	  
	    private JTextField getJTextField8() {  
	        if (jTextField8 == null) {  
	            jTextField8 = new JTextField();  
	            jTextField8.setText("3.0");  
	        }  
	        return jTextField8;  
	    }  
	  
	    private JTextField getJTextField7() {  
	        if (jTextField7 == null) {  
	            jTextField7 = new JTextField();  
	            jTextField7.setText("2.0");  
	        }  
	        return jTextField7;  
	    }  
	  
	    private JTextField getJTextField6() {  
	        if (jTextField6 == null) {  
	            jTextField6 = new JTextField();  
	            jTextField6.setText("1.0");  
	        }  
	        return jTextField6;  
	    }  
	  
	    private JTextField getJTextField5() {  
	        if (jTextField5 == null) {  
	            jTextField5 = new JTextField();  
	            jTextField5.setText("f6");  
	        }  
	        return jTextField5;  
	    }  
	  
	    private JTextField getJTextField4() {  
	        if (jTextField4 == null) {  
	            jTextField4 = new JTextField();  
	            jTextField4.setText("f5");  
	        }  
	        return jTextField4;  
	    }  
	  
	    private JTextField getJTextField3() {  
	        if (jTextField3 == null) {  
	            jTextField3 = new JTextField();  
	            jTextField3.setText("f4");  
	        }  
	        return jTextField3;  
	    }  
	  
	    private JTextField getJTextField2() {  
	        if (jTextField2 == null) {  
	            jTextField2 = new JTextField();  
	            jTextField2.setText("f3");  
	        }  
	        return jTextField2;  
	    }  
	  
	    private JTextField getJTextField1() {  
	        if (jTextField1 == null) {  
	            jTextField1 = new JTextField();  
	            jTextField1.setText("f2");  
	        }  
	        return jTextField1;  
	    }  
	  
	    private JTextField getJTextField0() {  
	        if (jTextField0 == null) {  
	            jTextField0 = new JTextField();  
	            jTextField0.setText("f1");  
	        }  
	        return jTextField0;  
	    }  
	  
	    private JLabel getJLabel0() {  
	        if (jLabel0 == null) {  
	            jLabel0 = new JLabel();  
	            jLabel0.setText("");  
	        }  
	        return jLabel0;  
	    }  
	  
	    private JButton getJButton0() {  
	        if (jButton0 == null) {  
	            jButton0 = new JButton();  
	            jButton0.setText("保存输入");  
	            jButton0.addActionListener(new ActionListener() {  
	      
	                public void actionPerformed(ActionEvent event) {  
	                    jButton0ActionActionPerformed(event);  
	                }  
	            });  
	        }  
	        return jButton0;  
	    }  
	  
	    private JScrollPane getJScrollPane0() {  
	        if (jScrollPane0 == null) {  
	            jScrollPane0 = new JScrollPane();  
	            jScrollPane0.setViewportView(getJPanel0());  
	        }  
	        return jScrollPane0;  
	    }  
	  
	    private JPanel getJPanel0() {  
	        if (jPanel0 == null) {  
//	          jPanel0 = new JPanel();  
	            jPanel0=this.createDemoPanel2();///////////////////////////////////////////////////////////////  
//	            jPanel0.setLayout(new GroupLayout());  
//	            jPanel0.add(getJLabel0(), new Constraints(new Leading(33, 10, 10), new Leading(27, 10, 10)));  
	        }  
	        return jPanel0;  
	    }  
	  
	    private static void installLnF() {  
	        try {  
	            String lnfClassname = PREFERRED_LOOK_AND_FEEL;  
	            if (lnfClassname == null)  
	                lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();  
	            UIManager.setLookAndFeel(lnfClassname);  
	        } catch (Exception e) {  
	            System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL  
	                    + " on this platform:" + e.getMessage());  
	        }  
	    }  
	  
	    /** 
	     * Main entry of the class. 
	     * Note: This class is only created so that you can easily preview the result at runtime. 
	     * It is not expected to be managed by the designer. 
	     * You can modify it as you like. 
	     */  
	    public static void main(String[] args) {  
	        installLnF();  
	        SwingUtilities.invokeLater(new Runnable() {  
	            @Override  
	            public void run() {  
	                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
	            	SwingJFreeChart001 frame = new SwingJFreeChart001();  
	                frame.setDefaultCloseOperation(SwingJFreeChart001.EXIT_ON_CLOSE);  
	                frame.setTitle("FreePanelTwo");  
	                frame.getContentPane().setPreferredSize(frame.getSize());  
	                frame.pack();  
	                frame.setLocationRelativeTo(null);  
	                frame.setVisible(true);  
	            }  
	        });  
	    }  
	    //保存输入  
	    private void jButton0ActionActionPerformed(ActionEvent event) {  
	        System.out.println("按钮");  
	        JPanel pp=null;  
	        pp=this.changeDatasetName(jTextField0.getText().trim(), Double.valueOf(jTextField6.getText().trim()),   
	                jTextField1.getText().trim(), Double.valueOf(jTextField7.getText().trim()),  
	                jTextField2.getText().trim(), Double.valueOf(jTextField8.getText().trim()),   
	                jTextField3.getText().trim(), Double.valueOf(jTextField9.getText().trim()),   
	                jTextField4.getText().trim(), Double.valueOf(jTextField11.getText().trim()),  
	                jTextField5.getText().trim(), Double.valueOf(jTextField12.getText().trim()));  
//	        pp.setLayout(new GroupLayout());  
//	        pp.add(getJLabel0(), new Constraints(new Leading(33, 10, 10), new Leading(27, 10, 10)));  
	          
	        jPanel0.setVisible(false);  
	        this.jPanel0=pp;  
	        this.initComponentsdddd(jPanel0);  
//	        
//	      this.jPanel0.setVisible(true);  
//	      this.jPanel0.repaint();  
	    }  
	      
	    private void initComponentsdddd(JPanel pp) {  
//	        setLayout(new GroupLayout());  
//	        add(pp, new Constraints(new Leading(6, 588, 10, 10), new Bilateral(8, 12, 55)));  
//	        add(getJTextField0(), new Constraints(new Leading(655, 59, 10, 10), new Leading(104, 12, 12)));  
//	        add(getJTextField1(), new Constraints(new Leading(655, 58, 12, 12), new Leading(146, 10, 10)));  
//	        add(getJTextField2(), new Constraints(new Leading(655, 58, 12, 12), new Leading(186, 12, 12)));  
//	        add(getJTextField3(), new Constraints(new Leading(655, 58, 12, 12), new Leading(228, 10, 10)));  
//	        add(getJTextField4(), new Constraints(new Leading(655, 58, 12, 12), new Leading(277, 10, 10)));  
//	        add(getJTextField5(), new Constraints(new Leading(655, 58, 12, 12), new Leading(321, 10, 10)));  
//	        add(getJLabel7(), new Constraints(new Leading(664, 12, 12), new Leading(62, 10, 10)));  
//	        add(getJLabel8(), new Constraints(new Leading(774, 10, 10), new Leading(60, 10, 10)));  
//	        add(getJButton0(), new Constraints(new Leading(698, 10, 10), new Leading(387, 10, 10)));  
//	        add(getJTextField6(), new Constraints(new Leading(766, 64, 10, 10), new Leading(104, 12, 12)));  
//	        add(getJTextField7(), new Constraints(new Leading(766, 64, 12, 12), new Leading(146, 12, 12)));  
//	        add(getJTextField8(), new Constraints(new Leading(766, 64, 12, 12), new Leading(182, 10, 10)));  
//	        add(getJTextField9(), new Constraints(new Leading(766, 64, 12, 12), new Leading(226, 12, 12)));  
//	        add(getJTextField11(), new Constraints(new Leading(766, 64, 12, 12), new Leading(277, 12, 12)));  
//	        add(getJTextField12(), new Constraints(new Leading(763, 63, 10, 10), new Leading(325, 10, 10)));  
	        setSize(866, 464);  
	    }  
	    //  
	    private JPanel getJPanelpp() {  
	        JPanel pp=null;  
	        if (pp == null) {  
	            pp=this.createDemoPanel2();///////////////////////////////////////////////////////////////  
//	            pp.setLayout(new GroupLayout());  
//	            pp.add(getJLabel0(), new Constraints(new Leading(33, 10, 10), new Leading(27, 10, 10)));  
	        }  
	        return pp;  
	    }  
	    //重画panel  
	    private JPanel changeDatasetName(String a1,Double d1,  
	            String a2,Double d2,  
	            String a3,Double d3,  
	            String a4,Double d4,  
	            String a5,Double d5,  
	            String a6,Double d6) {  
	          
	        DefaultPieDataset dataset2 = new DefaultPieDataset();  
	         
	        dataset2.setValue(a1, d1);  
	        dataset2.setValue(a2, d2);  
	        dataset2.setValue(a3, d3);  
	        dataset2.setValue(a4, d4);  
	        dataset2.setValue(a5, d5);  
	        dataset2.setValue(a6, d6);  
	          
	        PieDataset dataset33=(PieDataset)dataset2;  
	          
//	        JFreeChart chartt = this.createChart2(dataset2);  
	        JFreeChart chartt = ChartFactory.createPieChart(  
	                "Pie Chart", // chart title  
	                dataset33,             // data  
	                true,               // include legend  
	                true,  
	                false  
	            );  
	  
	            PiePlot plot = (PiePlot) chartt.getPlot();  
	            plot.setSectionOutlinesVisible(false);  
	            plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 10));  
	            plot.setNoDataMessage("No data available");  
	            plot.setSimpleLabels(true);  
	              
	        return new ChartPanel(chartt);  
	            
	    }  
	      
	    private PieDataset createDataset2() {  
	        DefaultPieDataset dataset = new DefaultPieDataset();  
	          
	        dataset.setValue("One", new Double(1.1));  
	        dataset.setValue("Two", new Double(2.2));  
	        dataset.setValue("Three", new Double(3.3));  
	        dataset.setValue("Four", new Double(57.5));  
	        dataset.setValue("Five", new Double(21.0));  
	        dataset.setValue("Six", new Double(19.4));  
	        return dataset;          
	    }  
	      
	      
	    private JFreeChart createChart2(PieDataset dataset) {  
	          
	        JFreeChart chart = ChartFactory.createPieChart(  
	            "Pie Chart", // chart title  
	            dataset,             // data  
	            true,               // include legend  
	            true,  
	            false  
	        );  
	  
	        PiePlot plot = (PiePlot) chart.getPlot();  
	        plot.setSectionOutlinesVisible(false);  
	        plot.setLabelFont(new Font("SansSerif", Font.PLAIN, 10));  
	        plot.setNoDataMessage("No data available");  
	        plot.setSimpleLabels(true);  
	          
	        return chart;  
	          
	    }  
	  
	    public JPanel createDemoPanel2() {  
	        JFreeChart chart = this.createChart2(this.createDataset2());  
	        return new ChartPanel(chart);  
	    }  
	    //改变名字  
	    private void jButton1ActionActionPerformed(ActionEvent event) {  
	          
	          
	    } 
}
