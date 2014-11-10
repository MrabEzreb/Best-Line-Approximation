package com.ezreb.math;

class Main {
	public static void main(String[] args) throws InterruptedException {
		windows.start();
		if(args[0]=="onTop") {
			windows.windo2.setAlwaysOnTop(true);
		}
	}
	final static MathWindow windows = new MathWindow();
}
