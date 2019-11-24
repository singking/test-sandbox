package banking.test2;

public class Mathematics {

	/**
	 * Works out the factorial for the number provided
	 * 
	 * @param n
	 *            number to work out factorial
	 * @return
	 */
	public static long factorial(int n) {

		long result = 1;

		for (int i = 1; i <= n; i++) {
			result *= i;
		}

		return result;
	}

	public static void main(String[] args) {

		System.out.println("Factorial of " + 5 + "=" + Mathematics.factorial(5));

		for (int i = 0; i <= 13; i++) {
			System.out.println("Factorial of " + i + "=" + Mathematics.factorial(i));
		}

	}
}
