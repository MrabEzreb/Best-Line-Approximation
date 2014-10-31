package com.ezreb.math;

import java.awt.Button;
import java.awt.Dimension;
//import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

public class MathWindow implements ActionListener {
	public MathWindow() {
		windo2.setResizable(false);
		windo2.setSize(150, 150);
		windo2.setVisible(true);
	    btn1.setActionCommand("tf1.setText('I Did It!'");
	    tf1.setText("This is a textbox");
	    windo2.add(btn1);
	    windo2.add(tf1);
	    Dimension tf1s = new Dimension();
	    tf1s.setSize(145, 70);
	    tf1.setPreferredSize(tf1s);
//	    chooser.add("Pick an Option");
//	    chooser.add("Slope Intercept Form");
//	    chooser.add("Test1");
//	    chooser.add("Test 2ledelley do");
//	    windo2.add(lblOne);
//	    windo2.add(chooser);
	    Dimension btn1s = new Dimension();
	    btn1s.setSize(145, 30);
	    btn1.setPreferredSize(btn1s);
	    windo2.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
//	    windo2.setLayout(new FlowLayout(FlowLayout.CENTER));
	    
	}
	Label lblOne = new Label("Do Math Here");
	public Frame windo2 = new Frame("Bram's Math Program");
	public void close() {
		windo2.dispose();
	}
	
	Button btn1 = new Button("Compute");
//	Choice chooser = new Choice();
	boolean isActive = false;
	TextField tf1 = new TextField();
	public void stop() {
		btn1.removeActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button Pressed");
//		String chosenMath = chooser.getSelectedItem();
		if(chosenMath=="Slope Intercept Form") {
			System.out.println("SlopeInterceptCHosen");
			String values = tf1.getText();
			Scanner xandy = new Scanner(values);
			xandy.useDelimiter(",");
			double x = xandy.nextDouble();
			double x2 = xandy.nextDouble();
			double y = xandy.nextDouble();
			double y2 = xandy.nextDouble();
			xandy.close();
			String slopeForm = SlopeIntercept.calculate(x, x2, y, y2);
			tf1.setText(slopeForm);
		}
	}
	WindowAdapter l = new WindowAdapter() {
		@Override
		public void windowClosing(WindowEvent we) {
			MathWindow.this.close();
		}
	};
	MenuBar menuBar = new MenuBar();
	Menu menuView = new Menu("View");
	MenuItem top = new MenuItem("Always On Top");
	Menu menuCalc = new Menu("Calculation");
	MenuItem c1 = new MenuItem("Slope-Intercept Form");
	String chosenMath = null;
	public void start() throws InterruptedException {
		btn1.addActionListener(this);
		windo2.addWindowListener(l);
		top.addActionListener(new ActionListener() {
			boolean isTop = false;
			public void actionPerformed(ActionEvent e) {
				if(isTop==false) {
					windo2.setAlwaysOnTop(true);
					isTop = true;
				} else {
					windo2.setAlwaysOnTop(false);
					isTop = false;
				}
			}
		});
		c1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenMath = "Slope Intercept Form";
			}
		});
		menuView.add(top);
		menuBar.add(menuView);
		windo2.setMenuBar(menuBar);
		menuCalc.add(c1);
		menuBar.add(menuCalc);
	}
}
