package com.ezreb.math;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class SlopeIntercept {

	public static void main(String[] args) throws IOException {
		FileInputStream values = new FileInputStream("/BestLineApproximation/com/ezreb/math/slopeInt.txt");
		Scanner reader = new Scanner(values).useDelimiter(",");
		double x1 = reader.nextInt();
		double y1 = reader.nextInt();
		// TODO Auto-generated method stub
		XYPoint p1 = new XYPoint(x1, y1);
		double x2 = reader.nextInt();
		double y2 = reader.nextInt();
		reader.close();
		XYPoint p2 = new XYPoint(x2, y2);
		double rise = p2.y-p1.y;
		double run = p2.x-p1.x;
		double slope = rise/run;
		double intercept = 0;
		double intx = p1.x;
		double inty = p1.y;
		int tries = 1;
		boolean isInt = false;
		boolean risInt = false;
		int rise2 = (int) Math.floor(rise);
		int run2 = (int) Math.floor(run);
		int slope2 = (int) Math.floor(slope);
		int rise3 = (int) Math.floor(rise);
		int run3 = (int) Math.floor(run);
		double slope3 = slope;
		if(rise == Math.floor(rise) && run == Math.floor(run) && slope == Math.floor(slope)) {
			isInt = true;
		} else if(rise == Math.floor(rise) && run == Math.floor(run)) {
			risInt = true;
		}
		boolean intint = false;
		int intercept2 = 0;
		while(tries<10) {
			tries = tries+1;
			if(intx==0) {
				if(inty == Math.floor(inty)) {
					intercept2 = (int) inty;
					intint = true;
				} else {
					intercept = (double) inty;
				}
				String slopeForm = "Slope-Intercept Form Could Not Be Found";
				if(intint==true) {
					if(isInt==true) {
						slopeForm = "y = "+slope2+"x + "+intercept2;
					} else if(risInt==true) {
						slopeForm = "y = "+rise3+"/"+run3+"x + "+intercept2;
					} else {
						slopeForm = "y = "+rise+"/"+run+"x + "+intercept2;
					}
				} else {
					if(isInt==true) {
						slopeForm = "y = "+slope2+"x + "+intercept;
					} else if(risInt==true) {
						slopeForm = "y = "+rise3+"/"+run3+"x + "+intercept;
					} else {
						slopeForm = "y = "+rise+"/"+run+"x + "+intercept;
					}
				}				
				System.out.println(slopeForm);
				break;
			} else if(intx>0) {
				intx = intx-1;
				inty = inty-slope;
			} else if(intx<0) {
				intx = intx+1;
				inty = inty+slope;
			}
		}
			
	}

}
