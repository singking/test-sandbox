package concurrency.futures;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestFutureExceptions implements Callable<Worker> {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		long timenow = System.nanoTime();
		ExecutorService pool = Executors.newFixedThreadPool(12);
		List<Future<Worker>> futures = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Future<Worker> future = pool.submit(new TestFutureExceptions());
			futures.add(future);
		}

		for (Future<Worker> future2 : futures) {

			try {
				Worker worker = future2.get();
				System.out.println("ddddddddddddd sleep[" + worker.n + "]");
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}

		// ExecutorService pool = new ThreadPoolExecutor(2, 3, 10L,
		// TimeUnit.SECONDS, new ArrayBlockingQueue<TestFutureExceptions>(
		// 22));

		long seconds = (System.nanoTime() - timenow) / 1_000_000_000;
		pool.shutdownNow();
		System.out.println("completed! " + seconds);
	}

	@Override
	public Worker call() throws MyNewException {
		Random rand = new Random();

		int n = rand.nextInt(10) + 1;

		try {
			Thread.sleep(n * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (n < 5)
			throw new MyNewException("callable exception");

		return new Worker(n);
	}
}

class Worker {
	int n;

	public Worker(int n) {
		this.n = n;
	}
}

class MyNewException extends Exception {
	private static final long serialVersionUID = 1L;

	public MyNewException(String string) {
		super(string);
	}

}