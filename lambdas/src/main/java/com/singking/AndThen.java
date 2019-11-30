package com.singking;

import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * https://medium.com/@mhmdsalemalhjaj/java-8-composing-functions-using-compose-and-andthen-71ee88816f5
 *
 */
public class AndThen {

	public static void main(String[] args) {
		Function<String, String> upperCase = String::toUpperCase;
		Function<String, String> trim = String::trim;
		String string = " Hi ";
		Function<String, String> upperCaseThenTrim = upperCase.andThen(trim);
		assert Objects.equals(upperCaseThenTrim.apply(string), "HI");

		/**
		 * Predicate Composition The Predicate interface
		 * (java.util.function.Predicate) contains a few methods that help you
		 * compose new Predicate instances from other Predicate instances. I
		 * will cover some of these methods in the following sections.
		 *
		 * and() The Predicate and() method is a default method. The and()
		 * method is used to combine two other Predicate functions in the same
		 * way I showed in the beginning of this Java functional composition
		 * tutorial. Here is an example of functional composition with the
		 * Predicate and() method:
		 */
		Predicate<String> startsWithA = (text) -> text.startsWith("A");
		Predicate<String> endsWithX = (text) -> text.endsWith("x");

		Predicate<String> composed = startsWithA.and(endsWithX);

		String input = "A hardworking person must relax";
		boolean result = composed.test(input);
		System.out.println(result);

		/**
		 * The Java Function compose() method composes a new Function instance
		 * from the Function instance it is called on, and the Function instance
		 * passed as parameter to the compose() method.
		 *
		 * The Function returned by compose() will first call the Function
		 * passed as parameter to compose(), and then it will call the Function
		 * which compose() was called on. This is easier to understand with an
		 * example, so here is a Java Function compose() example:
		 */
		Function<Integer, Integer> multiply = (value) -> value * 2;
		Function<Integer, Integer> add = (value) -> value + 3;

		Function<Integer, Integer> addThenMultiply = multiply.compose(add);

		Integer result1 = addThenMultiply.apply(3);
		System.out.println(result1);

		/**
		 * andThen() The Java Function andThen() method works opposite of the
		 * compose() method. A Function composed with andThen() will first call
		 * the Function that andThen() was called on, and then it will call the
		 * Function passed as parameter to the andThen() method. Here is a Java
		 * Function andThen() example:
		 */
		Function<Integer, Integer> multiply2 = (value) -> value * 2;
		Function<Integer, Integer> add2 = (value) -> value + 3;

		Function<Integer, Integer> multiplyThenAdd = multiply2.andThen(add2);

		Integer result2 = multiplyThenAdd.apply(3);
		System.out.println(result2);

		// another ecample
		Function<Integer, String> converter = (i) -> Integer.toString(i);
		Function<String, Integer> reverse = (s) -> Integer.parseInt(s);
		System.out.println(converter.apply(3).length());
		System.out.println(converter.andThen(reverse).apply(30).byteValue());

	}

}
