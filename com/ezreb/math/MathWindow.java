package com.ezreb.math;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MathWindow {
	public MathWindow(String label) {
		windo2.setResizable(false);
		windo2.setSize(800, 450);
		windo2.setVisible(true);
		Label lblOne = new Label(label);
	    btn1.setActionCommand("tf1.setText('I Did It!'");
	    tf1.setText("This is a textbox");
	    chooser.add("Slope Intercept Form");
	    chooser.add("Test1");
	    chooser.add("Test 2ledelley do");
	    windo2.add(lblOne);
	    windo2.add(btn1);
	    windo2.add(tf1);
	    windo2.add(chooser);
	    windo2.setLayout(new FlowLayout(FlowLayout.CENTER));
	}
	public Frame windo2 = new Frame("Mrab's Math Program");
	public void close() {
		windo2.dispose();
	}
	Button btn1 = new Button("Compute");
	Choice chooser = new Choice();
	boolean isActive = false;
	TextField tf1 = new TextField();
	@SuppressWarnings("null")
	public void start() throws InterruptedException {
		ActionListener l = null;
		btn1.addActionListener(l);
		while(isActive==true) {
			String chosenMath = chooser.getSelectedItem();
			if(chosenMath=="Slope Intercept Form") {
				l.wait();
				String values = tf1.getText();
				
			}
		}
	}
}
