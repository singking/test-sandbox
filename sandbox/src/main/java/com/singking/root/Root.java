package com.singking.root;

public class Root {

	public static void main(String[] args) {
		double a = 27;
		int b = 3;

		double c = Math.log(a) / Math.log(b);

		System.out.println(" ->" + c);

		a = 1024;
		b = 2;
		c = Math.pow(a, 1D / b);

		System.out.println(" ->" + c);

		a = 1.91;
		b = 2;
		c = Math.pow(a, 1D / b);
		System.out.println(" ->" + c);

	}

	private static double root(double base, int exp) {
		return Math.pow(base, 1D / exp);
	}
}
