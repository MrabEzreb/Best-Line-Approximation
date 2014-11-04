package com.ezreb.math;

import java.util.Scanner;

public class SquareRoot implements MathFunction {
	public SquareRoot() {
	}
	@Override
	public String calculate(double x1, double y1, double x2, double y2) {
		PrimeFactorization PrimeFactorization = new PrimeFactorization();
		String answer1 = PrimeFactorization.calculate(x1, y1, x2, y2);
		Scanner root = new Scanner(answer1);
		root.useDelimiter(",");
		int[] root2 = new int[50];
		int currentFactor = 0;
		while(root.hasNextInt()==true) {
			root2[currentFactor] = root.nextInt();
			currentFactor++;
		}
		root.close();
		int multiplyer = 1;
		int curMulti = 1;
		boolean curI = false;
		int sqroot = 1;
		boolean isDone = false;
		int eye = 1;
		boolean skip = true;
		while(isDone==false) {
			if(skip==true) {
				curMulti = root2[eye];
				skip = false;
				continue;
			} else if(root2[eye-1]==0) {
				isDone = true;
				break;
			} else {
				if(root2[eye-1]==root2[eye]) {
					multiplyer = multiplyer*curMulti;
					skip = true;
					System.out.println(multiplyer+"multi");
					System.out.println(eye+"eye");
				} else {
					sqroot = sqroot*curMulti;
					curMulti = root2[eye];
					System.out.println(sqroot+"root");
				}
				curMulti = root2[eye];
			}	
			eye = eye + 1;
		}
		
		String retVal = multiplyer+"*/"+sqroot;
		return retVal;
	}
	public void oldFunc() {
		int[] root2 = new int[50];
		for(int i = 0; i < root2.length; i++) {
			boolean curI = false;
			int curMulti = 0;
			if(curI==true) {
				curI = false;
				continue;
			} else if(root2[i]==curMulti) {
				int multiplyer = 0;
				multiplyer = multiplyer*root2[i];
				System.out.println(multiplyer);
				curI = true;
				curMulti = root2[i];
			} else {
				int sqroot = 0;
				sqroot = sqroot*curMulti;
				curMulti = root2[i];
			}
		}
	}
}