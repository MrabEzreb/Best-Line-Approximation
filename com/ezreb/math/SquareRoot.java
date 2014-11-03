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
			currentFactor = currentFactor+1;
		}
		for(int prime : PrimeFactorization.primes) {
			for(int factor : root2) {
				if(factor~=prime) {
					
				}
			}
		}
		return null;
	}

}
