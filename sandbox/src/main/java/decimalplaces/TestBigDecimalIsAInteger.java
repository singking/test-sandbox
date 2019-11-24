package decimalplaces;

import java.math.BigDecimal;

public class TestBigDecimalIsAInteger {
	public static boolean isIntegerValue(BigDecimal bd) {
		return bd.signum() == 0 || bd.scale() <= 0
				|| bd.stripTrailingZeros().scale() <= 0;
	}

	public static void main(String[] args) {
		BigDecimal bd = BigDecimal.valueOf(0.22222D);
		System.out.println(String.format("[%f] is an integer[%b]", bd,
				isIntegerValue(bd)));

		bd = BigDecimal.valueOf(12.000D);
		System.out.println(String.format("[%f] is an integer[%b]", bd,
				isIntegerValue(bd)));

		bd = BigDecimal.valueOf(12.0000001D);
		System.out.println(String.format("[%f] is an integer[%b]", bd,
				isIntegerValue(bd)));

	}
}
