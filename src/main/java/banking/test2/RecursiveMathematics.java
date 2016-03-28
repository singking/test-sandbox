package banking.test2;

public class RecursiveMathematics {

	/**
	 * Works out the factorial for the number provided
	 * 
	 * @param n
	 *            number to work out factorial
	 * @return
	 */
	public static long factorial(int n) {

		// factorals for positive numbers
		if (n <= 0)
			return 0;

		return n == 1 ? n : n * factorial(--n);
	}

	public static long factorialNegatives(int n) {

		n = Math.abs(n);

		return n == 1 ? n : n * factorial(--n);
	}

	public static void main(String[] args) {

		for (int i = 13; i >= -13; i--) {
			System.out.println("Factorial of " + i + "=" + RecursiveMathematics.factorialNegatives(i));
		}

	}
}
