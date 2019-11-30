package com.singking.example2;

import java.util.Arrays;

public class LambdaMapExample {

    public static void main(String[] args) {
        String[] txt = {"State", "of", "the", "Lambda", "Libraries", "Edition"};
        Arrays.stream(txt)
                .filter(s -> s.length() > 3)
                .map(s -> s.length())
                .forEach(System.out::println);
    }
}
