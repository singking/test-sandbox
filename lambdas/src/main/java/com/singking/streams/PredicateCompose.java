package com.singking.streams;

import java.util.Arrays;
import java.util.function.IntPredicate;

public class PredicateCompose {

    public static void main(String[] args) {

        int[] nums = {2, 3, 1, 5, 6, 7, 8, 9, 12};

        IntPredicate predicate1 = n -> n > 3;
        IntPredicate predicate2 = n -> n < 9;

        Arrays.stream(nums).filter(predicate1.and(predicate2)).forEach(System.out::println);

        System.out.println("**********");

        IntPredicate predicate3 = n -> n == 6;
        IntPredicate predicate4 = n -> n == 9;

        Arrays.stream(nums).filter(predicate3.or(predicate4)).forEach(System.out::println);
    }
}