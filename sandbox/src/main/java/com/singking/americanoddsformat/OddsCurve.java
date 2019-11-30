package com.singking.americanoddsformat;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class OddsCurve {

	public static void main(String[] args) {
		int start = -2000;
		for (int i = start; i < 0; i = i < -1000 ? i + 1000 : i + 10) {
			BigDecimal euro = BigDecimal
					.valueOf(100)
					.divide(BigDecimal.valueOf(Math.negateExact(i)),
							MathContext.DECIMAL128)
					.setScale(10, RoundingMode.HALF_UP);
			// System.out.println(String.format("US[%d] Euro[%f]", i, euro));
			System.out.println(String.format("%d,%f", i, euro));

		}

		for (int i = 100; i < 200; i += 10) {
			BigDecimal euro = BigDecimal.valueOf(i)
					.divide(BigDecimal.valueOf(100), MathContext.DECIMAL128)
					.setScale(10, RoundingMode.HALF_UP);
			// System.out.println(String.format("US[+%d] Euro[%f]", i, euro));
			System.out.println(String.format("%d,%f", i, euro));
		}

	}
}
