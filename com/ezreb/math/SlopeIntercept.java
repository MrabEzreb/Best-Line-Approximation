package com.ezreb.math;

public class SlopeIntercept {

	public static void main(String[] args) {
		double x1 = 0;
		double y1 = 0;
		// TODO Auto-generated method stub
		XYPoint p1 = new XYPoint(x1, y1);
		double x2 = 0;
		double y2 = 0;
		XYPoint p2 = new XYPoint(x2, y2);
		double rise = p2.y-p1.y;
		double run = p2.x-p1.x;
		double slope = rise/run;
		if(p1.x < 0) {
			p1.x = p1.x*-1;
			slope = slope*-1;
		}
		double intercept = 0;
		while(true) {
			if(p1.x==0) {
				String slopeForm = "y = "+rise+"/"+run+"x + "+intercept;
				System.out.println(slopeForm);
			} else if(p1.x<0) {
				if(Math.abs(p1.x)<Math.abs(run)) {
					
				}
			}
		}
			
	}

}
