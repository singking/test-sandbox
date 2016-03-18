package concurrency.workerthreads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;

public class WorkerQueueBothEnds {

	final static int ITERATIONS = 100;

	BlockingQueue<String> q = new LinkedBlockingDeque<>();

	public static void main(String[] args) {

		List<BlockingDeque<String>> list2 = new ArrayList<>();

		Eooo eo1 = new Eooo(list2, 0);
		list2.add(eo1.getQ());

		Eooo eo2 = new Eooo(list2, 1);
		list2.add(eo2.getQ());
		for (int i = 0; i < ITERATIONS; i++) {
			eo2.add(i + "");
		}
		eo2.add("stop");
		eo2.add("stop");

		Eooo eo3 = new Eooo(list2, 1);
		list2.add(eo3.getQ());
		for (int i = 0; i < ITERATIONS; i++) {
			eo3.add(i + "");
		}
		eo2.add("stop");
		eo2.add("stop");

		new Thread(eo1).start();
		new Thread(eo2).start();
		new Thread(eo3).start();

	}
}

class Eooo implements Runnable {

	List<BlockingDeque<String>> list;
	BlockingDeque<String> q = new LinkedBlockingDeque<>();
	int delayInSeconds;

	public Eooo(List<BlockingDeque<String>> list, int delayInSeconds) {
		this.list = list;
		this.delayInSeconds = delayInSeconds;
	}

	void add(String s) {
		q.add(s);
	}

	@Override
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println("starting " + Thread.currentThread().getName());
		while (true) {
			String t = null;
			try {
				if (delayInSeconds > 0) {
					Thread.sleep(1000 * delayInSeconds);
				}
				t = q.poll(1, TimeUnit.SECONDS);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (t == null) {
				// try to get some work from the other threads
				for (BlockingDeque<String> q : list) {
					t = q.pollLast();
					if (t != null) {
						System.out.println(threadName + " stealing a string "
								+ t);
						break;
					}
				}
			}

			if (t != null) {
				// System.out.println(t + "]Thread ["
				// + WorkerQueueBothEnds.THREADS);
				if (t.equals("stop")) {
					break;
				}
			}
		}
		System.out.println("ending " + Thread.currentThread().getName());
	}

	public BlockingDeque<String> getQ() {
		return q;
	}

	public void setQ(BlockingDeque<String> q) {
		this.q = q;
	}

}
