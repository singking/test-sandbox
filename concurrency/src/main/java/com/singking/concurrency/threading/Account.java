package com.singking.concurrency.threading;

public class Account {

	private double amount;

	private boolean terminate;

	Thread thread;

	public Account(double initialAmount) {
		amount = initialAmount;

		Interest interest = new Interest();
		thread = new Thread(interest);
		thread.start();

		TestStop stop = new TestStop();
		new Thread(stop).start();
	}

	public double getAmount() {
		return amount;
	}

	public void stop() {
		this.terminate = true;
		thread.interrupt();
	}

	void credit(double amountChange) {
		amount = amountChange + amount;
	}

	void debit(double amountChange) {
		amount = amount - amountChange;
	}

	void transfer(Account destination, double amountChange) {
		debit(amountChange);
		destination.credit(amountChange);
	}

	/***********************************************
	 * main
	 ************************************************/
	public static void main(String[] args) {
		Account acc = new Account(100);
	}

	public class TestStop implements Runnable {
		public void run() {
			System.out.println("your seconds are numbered");
			try {
				Thread.sleep(1000 * 10);
			} catch (InterruptedException e) {
				System.out.println("Thread interrupted");
			}
			System.out.println("yourtime is done");
			stop();
		}
	}

	public class Interest implements Runnable {
		public void run() {
			System.out.println("terminate=" + terminate);
			while (!terminate) {
				amount = getAmount() + getAmount() * 0.001D;
				System.out.println("Amount: " + amount);
				try {
					Thread.sleep(1000 * 1);
				} catch (InterruptedException e) {
					System.out.println("Thread interrupted");
					System.out.println("terminate=" + terminate);
				}
			}
		}
	}
}
