package com.singking.example2;

import java.util.Arrays;
import java.util.List;

public class LambdaComparableExample {

    public static List<String> dff(String... args) {

        List<String> list = Arrays.asList(args);
        list.sort((e1, e2) -> {
            int result = e1.compareTo(e2);
            return result;
        });

        return list;
    }

    public static List<String> sameAsdffe(String... args) {

        List<String> list = Arrays.asList(args);

        /*
         * Lambdas may return a value. The type of the return value will be
         * inferred by compiler. The return statement is not required if the
         * lambda body is just a one-liner. The two code snippets below are
         * equivalent:
         */
        list.sort((e1, e2) -> e1.compareTo(e2));

        return list;
    }

    public static List<String> sameAsdffeAgain(String... args) {

        List<String> list = Arrays.asList(args);

        /**
         * or even better can be replaced with
         */
        list.sort(String::compareTo);
		return list;
    }

    public static void main(String[] args) {

        /*
         * Lambdas design discussions have taken a lot of time and community
         * efforts. But finally, the trade-offs have been found, leading to new
         * concise and compact language constructs. In its simplest form, a
         * lambda could be represented as a comma-separated list of parameters,
         * the –> symbol and the body. For example: 1
         *
         * Please notice the type of argument e is being inferred by the
         * compiler. Alternatively, you may explicitly provide the type of the
         * parameter, wrapping the definition in brackets. For example:
         */
        Arrays.asList("a", "b", "d").forEach(e -> System.out.println(e));
        System.out.println();

        Arrays.asList("x", "y", "z").forEach((String e) -> System.out.println(e));
        System.out.println();

        /*
         * Lambdas may reference the class members and local variables
         * (implicitly making them effectively final if they are not). For
         * example, those two snippets are equivalent:
         */

        System.out.println(dff("x", "d", "a", "d", "b", "g"));
        System.out.println(sameAsdffe("x", "d", "a", "d", "b", "g"));
    }
}