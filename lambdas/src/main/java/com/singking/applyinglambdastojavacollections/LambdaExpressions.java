package com.singking.applyinglambdastojavacollections;

/**
 * https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#
 * syntax
 *
 */
public class LambdaExpressions {
	public static void main(String[] args) {
		/*
		 * A comma-separated list of formal parameters enclosed in parentheses.
		 * The CheckPerson.test method contains one parameter, p, which
		 * represents an instance of the Person class.
		 * 
		 * Note: You can omit the data type of the parameters in a lambda
		 * expression. In addition, you can omit the parentheses if there is
		 * only one parameter. For example, the following lambda expression is
		 * also valid:
		 * 
		 * p -> p.getGender() ==
		 */

		/*
		 * p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 &&
		 * p.getAge() <= 25;
		 */
		/*
		 * The arrow token, ->
		 * 
		 * A body, which consists of a single expression or a statement block.
		 * This example uses the following expression:
		 * 
		 * 
		 */
		/*
		 * p -> p.getGender() == Person.Sex.MALE && p.getAge() >= 18 &&
		 * p.getAge() <= 25;
		 */
		/*
		 * If you specify a single expression, then the Java runtime evaluates
		 * the expression and then returns its value. Alternatively, you can use
		 * a return statement:
		 */
		/*
		 * p -> { return p.getGender() == Person.Sex.MALE && p.getAge() >= 18 &&
		 * p.getAge() <= 25; }
		 */
	}
}
