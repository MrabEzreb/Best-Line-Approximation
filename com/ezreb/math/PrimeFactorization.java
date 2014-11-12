package com.ezreb.math;

public class PrimeFactorization extends MathFunction {
	public PrimeFactorization() {
	}
	@Override
	public String calculate(double x1, double y1, double x2, double y2) {
		int originalNumber = (int) Math.floor(x1);
		System.out.println(originalNumber);
		int[] factorization = new int[50];
		String primeFactorization = null;
		int nonFactored = originalNumber;
		int currentNumber = 0;
		boolean isFactored = false;
		int smallestPrime;
		while(isFactored==false) {
			smallestPrime = getSmallestPrimeFactor(nonFactored);
			if(smallestPrime==nonFactored) {
				isFactored = true;
				factorization[currentNumber] = smallestPrime;
				break;
			} else {
				System.out.println(nonFactored);
				nonFactored = nonFactored/smallestPrime;
				factorization[currentNumber] = smallestPrime;
				System.out.println(smallestPrime);
				System.out.println(nonFactored);
			}
			currentNumber = currentNumber+1;
			smallestPrime = 0;
		}
		for(int i : factorization) {
			if(i==0) {
				break;
			}
			if(primeFactorization==null) {
				primeFactorization = ""+i;
			} else {
				primeFactorization = primeFactorization+","+i;
			}
		}
		return primeFactorization;
	}
	private boolean checkPrime(int originalNum, int prime) {
		boolean answer = false;
		if(originalNum % prime == 0) {
			answer = true;
		}
		return answer;
	}
	private int getSmallestPrimeFactor(int originalNum) {
		int lowestFactor = 0;
		for(int factor : primes) {
			if(originalNum==factor) {
				lowestFactor = originalNum;
				System.out.println("same");
				break;
			} else if(checkPrime(originalNum, factor)==true) {
				lowestFactor = factor;
				System.out.println("not the same");
				break;
			}
		}
		return lowestFactor;
		
	}
	public int[] primes = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101,103,107,109,113,127,131,137,139,149,151,157,163,167,173,179,181,191,193,197,199,211,223,227,229,233,239,241,251,257,263,269,271,277,281,283,293,307,311,313,317,331,337,347,349,353,359,367,373,379,383,389,397,401,409,419,421,431,433,439,443,449,457,461,463,467,479,487,491,499,503,509,521,523,541};

}
