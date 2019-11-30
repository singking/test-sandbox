package com.singking.java8thefirsttasteoflambdas;

/**
 * http://zeroturnaround.com/rebellabs/java-8-the-first-taste-of-lambdas/
 */
public class LambdaRunnable {
    public static void main(String[] args) {

        // no-argument lambda
        Runnable r = () -> System.out.println("hello lambda!");
        new Thread(r).start();
    }
}
