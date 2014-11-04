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
		int sqroot = 1;
		int element = 1;
		boolean isRoot = false;
		boolean isDone = false;
		boolean almostDone = false;
		while(isDone==false) {
			System.out.println(root2[element]+" element");
			System.out.println(almostDone);
			if(root2[element]==0 && almostDone==false) {
				isRoot = true;
				element = element-1;
				almostDone = true;
				System.out.println("almost done");
			} else if(almostDone==true) {
				isDone = true;
				System.out.println("done");
				break;
			}
			if(isRoot==false) {
				if(checkExponent(root2, element)==true) {
					multiplyer = multiplyer*root2[element];
					System.out.println(multiplyer+" multiplyer");
					element = element+2;
				} else if(checkExponent(root2, element)==false) {
					isRoot = true;
					element = element-1;
				}
			} else if(isRoot==true && almostDone==false) {
				sqroot = sqroot*root2[element];
				System.out.println(sqroot+" sqroot");
				isRoot = false;
				element = element+2;
			} else if(isRoot==true && almostDone==true) {
				sqroot = sqroot*root2[element];
				System.out.println(sqroot+" sqroot");
				element++;
				break;
			}
		}
		String retVal;
		if(sqroot==0) {
			sqroot = 1;
		}
		if(multiplyer==0) {
			multiplyer = 1;
		}
		if(sqroot==1){
			retVal = multiplyer+"";
		} else if(multiplyer==1) {
			retVal = "/"+sqroot;
		} else {
			retVal = multiplyer+"*/"+sqroot;
		}
		return retVal;
	}
	private boolean checkExponent(int[] factorization, int element) {
		boolean isNumber = false;
		if(factorization[element]==factorization[element-1]) {
			isNumber = true;
		}
		return isNumber;
	}
}