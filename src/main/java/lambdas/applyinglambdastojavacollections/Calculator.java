package lambdas.applyinglambdastojavacollections;

/**
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#
 * approach2
 *
 */
public class Calculator {

	interface IntegerMath {
		int operation(int a, int b);
	}

	public int operateBinary(int a, int b, IntegerMath op) {
		return op.operation(a, b);
	}

	/**
	 * The method operateBinary performs a mathematical operation on two integer
	 * operands. The operation itself is specified by an instance of
	 * IntegerMath. The example defines two operations with lambda expressions,
	 * addition and subtraction. The example prints the following:
	 * 
	 */
	public static void main(String... args) {

		Calculator myApp = new Calculator();
		IntegerMath addition = (a, b) -> a + b;
		IntegerMath subtraction = (a, b) -> a - b;
		System.out.println("40 + 2 = " + myApp.operateBinary(40, 2, addition));
		System.out.println("20 - 10 = " + myApp.operateBinary(20, 10, subtraction));
	}
}
