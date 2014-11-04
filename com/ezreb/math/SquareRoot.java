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
		int curI = 0;
		int sqroot = 1;
		for(int i = 0; i < root2.length; i++) {
			if(i==curI) {
				curMulti = root2[i];
				continue;
			} else if(root2[i]==curMulti) {
				multiplyer = multiplyer*root2[i];
				System.out.println(multiplyer);
				curI = i+1;
				curMulti = 1;
			} else {
				sqroot = sqroot*curMulti;
				curMulti = 1;
			}
		}
		String retVal = multiplyer+"*/"+sqroot;
		return retVal;
	}
}