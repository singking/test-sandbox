package com.singking.concurrency.threading;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account3 {

    private volatile double amount;

    // stop interest payments
    private volatile boolean terminate;

    private volatile boolean isTransfering;

    private final Lock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    private Thread thread;

    public Account3(double initialAmount) {
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

    public void credit(double amountChange) {
        lock.lock();

        try {
            amount = amount + amountChange;
        } finally {
            lock.unlock();
        }
    }

    public void debit(double amountChange) {
        lock.lock();

        try {
            amount = amount - amountChange;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Transfer amount from this account to destination account provided
     *
     * @param destinationAccount account to be credited
     * @param amountChange       amount to transfer
     * @throws InterruptedException
     */
    public synchronized void transfer(Account3 destinationAccount, double amountChange) throws InterruptedException {

        isTransfering = true;

        Lock destLock = destinationAccount.getLock();
        Condition destCondition = destLock.newCondition();

        while (destinationAccount.isTransfering)
            destCondition.await();

        try {
            lock.lock();
            destLock.lock();

            debit(amountChange);
            destinationAccount.credit(amountChange);

        } finally {
            lock.unlock();
            destLock.unlock();
            isTransfering = false;
        }
    }

	/***********************************************
	 * main
	 ************************************************/
	public static void main(String[] args) {
		Account3 acc1 = new Account3(100);
		Account3 acc2 = new Account3(100);
		acc1.startPeriodicInterest();
		acc2.startPeriodicInterest();

		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("in");
		try {
			acc1.transfer(acc2, 30);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Condition getCondition() {
        return condition;
    }

    public Lock getLock() {
        return lock;
    }

    public void setTransfering(boolean isTransfering) {
        this.isTransfering = isTransfering;
    }

    public boolean isTransfering() {
        return isTransfering;
    }
}
