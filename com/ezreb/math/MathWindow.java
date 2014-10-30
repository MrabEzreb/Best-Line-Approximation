package com.ezreb.math;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class MathWindow implements ActionListener {
	public MathWindow() {
		windo2.setResizable(false);
		windo2.setSize(800, 450);
		windo2.setVisible(true);
	    btn1.setActionCommand("tf1.setText('I Did It!'");
	    tf1.setText("This is a textbox");
	    chooser.add("Pick an Option");
	    chooser.add("Slope Intercept Form");
	    chooser.add("Test1");
	    chooser.add("Test 2ledelley do");
	    chooser.add("End Program");
	    windo2.add(lblOne);
	    windo2.add(btn1);
	    windo2.add(tf1);
	    windo2.add(chooser);
	    windo2.setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	Label lblOne = new Label("Do Math Here");
	public void changeLabel(String label) {
		lblOne.setText(label);
	}
	public Frame windo2 = new Frame("Bram's Math Program");
	public void close() {
		windo2.dispose();
	}
	Button btn1 = new Button("Compute");
	Choice chooser = new Choice();
	boolean isActive = false;
	TextField tf1 = new TextField();
	public void stop() {
		btn1.removeActionListener(this);
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println("Button Pressed");
		String chosenMath = chooser.getSelectedItem();
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
			this.changeLabel("Slope-Intercept Form is");
			windo2.setLayout(new FlowLayout(FlowLayout.CENTER));
		} else if(chosenMath=="End Program") {
			System.out.println("EndChosen");
			this.stop();
			this.close();
		}
	}
	public void start() throws InterruptedException {
		btn1.addActionListener(this);
	}
}
