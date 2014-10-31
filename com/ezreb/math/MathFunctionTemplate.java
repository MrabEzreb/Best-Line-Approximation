package com.ezreb.math;

public class MathFunctionTemplate {
	public static String calculate(double x1, double y1, double x2, double y2) {
		XYPoint p1 = new XYPoint(x1, y1);
		XYPoint p2 = new XYPoint(x2, y2);
		//Space for variables
		//Note that you can convert doubles to integers by using
		//int integerVar = Math.floor(doubleVar)
		int tries = 1;
		while(tries<100) {
			tries = tries+1;
			//Put the calculations here.
			//Feel free to remove the while statement if you don't need it.
		}
		return yourReturnValue;
	}

}
