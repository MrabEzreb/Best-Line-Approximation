package com.ezreb.math;

import java.util.Scanner;

public class SquareRoot implements MathFunction {

	@Override
	public String calculate(double x1, double y1, double x2, double y2) {
		PrimeFactorization PrimeFactorization = new PrimeFactorization();
		String answer1 = PrimeFactorization.calculate(x1, y1, x2, y2);
		Scanner root = new Scanner(answer1);
		root.useDelimiter(",");
		int[] root2 = new int[50];
		int current 
		while(root.hasNextInt()==true) {
			root2[] = root.nextInt();
		}
		return null;
	}

}
