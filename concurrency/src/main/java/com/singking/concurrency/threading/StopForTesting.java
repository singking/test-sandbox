package com.singking.concurrency.threading;

import java.util.concurrent.TimeUnit;

public class StopForTesting {

	public StopForTesting() {
	}

	/**
	 * Changes the Account.terminate flag to false in it's own thread
	 */
	public static void stop(Account2 acct, int sleep) {
		System.out.println("sleeping for seconds: " + sleep);

		try {
			TimeUnit.SECONDS.sleep(sleep);
		} catch (InterruptedException e) {
			System.out.println("Thread interrupted");
		}

		acct.stop();

		System.out.println("method stop ()");

	}

}
