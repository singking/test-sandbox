package com.singking.decimalplaces;

import java.math.BigDecimal;

public class Test {
	public static void main(String[] args) {
		BigDecimal b = BigDecimal.valueOf(10.00);

		System.out.println(b.doubleValue());

		double d = 10;

		System.out.println(d);
	}
}
