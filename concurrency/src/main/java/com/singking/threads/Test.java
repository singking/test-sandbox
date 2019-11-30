package com.singking.threads;

public class Test {

	public static void main(String[] args) {
		Runnable runnable = new Runnable() {

			@Override
			public void run() {
				Singleton.getInstance().addBet("can I do this in an Anonymous class");
			}
		};

		new Thread(runnable).start();

		System.out.println(Thread.currentThread().getName() + " main thread ending");
	}
}
