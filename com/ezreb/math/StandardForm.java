package com.ezreb.math;

public class StandardForm implements MathFunction {

	@Override
	public String calculate(double x1, double y1, double x2, double y2) {
		XYPoint p1 = new XYPoint(x1, y1);
		XYPoint p2 = new XYPoint(x2, y2);
		double rise = p2.y-p1.y;
		double run = p2.x-p1.x;
		double slope = rise/run;
		double intercept = 0;
		double intx = p1.x;
		double inty = p1.y;
		int tries = 0;
		boolean isInt = false;
		boolean risInt = false;
		int slope2 = (int) Math.floor(slope);
		int rise3 = (int) Math.floor(rise);
		int run3 = (int) Math.floor(run);
		if(rise == Math.floor(rise) && run == Math.floor(run) && slope == Math.floor(slope)) {
			isInt = true;
		} else if(rise == Math.floor(rise) && run == Math.floor(run)) {
			risInt = true;
		}
		boolean intint = false;
		int intercept2 = 0;
		String standardForm = "Standard Form Could Not Be Found";
		while(tries<100) {
			tries = tries+1;
			if(intx==0) {
				if(inty == Math.floor(inty)) {
					intercept2 = (int) inty;
					standardForm = rise + "x + " + run + "y = " + intercept2;
				} else {
					intercept = (double) inty;
					standardForm = rise + "x + " + run + "y = " + intercept;
				}
			} else if(intx>0) {
				intx = intx-1;
				inty = inty-slope;
			} else if(intx<0) {
				intx = intx+1;
				inty = inty+slope;
			}
		}
		return standardForm;
	}

}
