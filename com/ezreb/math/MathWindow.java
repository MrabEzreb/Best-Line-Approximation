package com.ezreb.math;

import java.awt.Button;
import java.awt.Dimension;
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
	    tf1.setText("");
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
	private String chosenMath = null;
	public void actionPerformed(ActionEvent e) {
		SlopeIntercept SlopeIntercept = new SlopeIntercept();
		StandardForm StandardForm = new StandardForm();
		PrimeFactorization PrimeFactorization = new PrimeFactorization();
		SquareRoot SquareRoot = new SquareRoot();
		System.out.println("Button Pressed");
//		String chosenMath = chooser.getSelectedItem();
		String values = tf1.getText();
		Scanner xandy = new Scanner(values);
		xandy.useDelimiter(",");
		double x = 0;
		double y = 0;
		double x2 = 0;
		double y2 = 0;
		String answer = null;
		if(chosenMath=="Slope Intercept Form") {
			System.out.println("SlopeInterceptCHosen");
			x = xandy.nextDouble();
			y = xandy.nextDouble();
			x2 = xandy.nextDouble();
			y2 = xandy.nextDouble();
			answer = SlopeIntercept.calculate(x, y, x2, y2);
		} else if(chosenMath=="Standard Form") {
			System.out.println("Standard Form Chosen");
			x = xandy.nextDouble();
			y = xandy.nextDouble();
			x2 = xandy.nextDouble();
			y2 = xandy.nextDouble();
			answer = StandardForm.calculate(x, y, x2, y2);
		} else if(chosenMath=="Prime Factorization") {
			System.out.println("Prime Factorization Chosen");
			x = xandy.nextDouble();
			answer = PrimeFactorization.calculate(x, y, x2, y2);
		} else if(chosenMath=="Square Root") {
			System.out.println("Square Root Chosen");
			x = xandy.nextDouble();
			answer = SquareRoot.calculate(x, y, x2, y2);
		}
		xandy.close();
		tf1.setText(answer);
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
	MenuItem c2 = new MenuItem("Standard Form");
	MenuItem c3 = new MenuItem("Prime Factorization");
	MenuItem c4 = new MenuItem("Square Root");
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
		c2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenMath = "Standard Form";
			}
		});
		c3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenMath = "Prime Factorization";
			}
		});
		c4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chosenMath = "Square Root";
			}
		});
		menuView.add(top);
		menuBar.add(menuView);
		windo2.setMenuBar(menuBar);
		menuCalc.add(c1);
		menuCalc.add(c2);
		menuCalc.add(c3);
		menuCalc.add(c4);
		menuBar.add(menuCalc);
	}
}
