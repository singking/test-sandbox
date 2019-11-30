package com.singking.threads;

public class Singleton {
	private static Singleton instance;

	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}
		return instance;

	}

	public void addBet(String str) {
		System.out.println(Thread.currentThread().getName() + " this is Singleton: " + str);
	}
}
