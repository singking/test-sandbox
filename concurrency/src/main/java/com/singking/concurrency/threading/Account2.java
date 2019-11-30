package com.singking.concurrency.threading;

import java.util.concurrent.TimeUnit;

public class Account2 {

    private volatile double amount;

    // stop interest payments
    private volatile boolean terminate;

    private Thread thread;

    public Account2(double initialAmount) {
        amount = initialAmount;
    }

    public double getAmount() {
        return amount;
    }

    public void startPeriodicInterest() {
        Interest interest = new Interest();
        thread = new Thread(interest);
        thread.start();
    }

    public void stop() {
        this.terminate = true;
        // thread.interrupt();
    }

    public synchronized void credit(double amountChange) {
        amount = amount + amountChange;
    }

    public synchronized void debit(double amountChange) {
        amount = amount - amountChange;
    }

    /**
     * Transfer amount from this account to destination account provided
     *
     * @param destination  account to be credited
     * @param amountChange amount to transfer
     */
    public synchronized void transfer(Account2 destination, double amountChange) {
        debit(amountChange);
        destination.credit(amountChange);
    }

	/***********************************************
	 * main
	 ************************************************/
	public static void main(String[] args) {
		Account2 acc1 = new Account2(100);
		Account2 acc2 = new Account2(100);
		acc1.startPeriodicInterest();
		acc2.startPeriodicInterest();

		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("in");
		acc1.transfer(acc2, 30);
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		acc1.stop();
		acc2.stop();

	}

    /**
     * Adds interest to Account.amount until the thread is terminated by another
     * thread setting the Account.terminate flag to false in another thread
     */
    public class Interest implements Runnable {
        public void run() {

            System.out.println(Thread.currentThread().getName() + " terminate=" + terminate);
            while (!terminate) {
                amount = amount * 1.01D;
                System.out.println(Thread.currentThread().getName() + " Amount: " + amount);
                try {
                    Thread.sleep(1000 * 1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
