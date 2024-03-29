import java.util.concurrent.CountDownLatch;
import java.util.Random;
import java.util.ArrayList;

public class CountDownLatchTest {
	private final static int THREADS = 10;
	private static CountDownLatch latch = new CountDownLatch(THREADS);

	public static class RandomSleepRunnable implements Runnable {
		private int id = 0;
		private static Random random = new Random(System.currentTimeMillis());

		public RandomSleepRunnable(int id) {
			this.id = id;
		}

		@Override
		public void run() {
			System.out.println("Thread(" + id + ") : Start.");

			int delay = random.nextInt(1001) + 1000;
			try {
				System.out.println("Thread(" + id + ") : Sleep " + delay + "ms");
				Thread.sleep(delay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("Thread(" + id + ") : End.");

			latch.countDown();
		}
	}

	public static void main(String[] args) {
		ArrayList<Thread> pool = new ArrayList<Thread>();
		for(int i = 0; i < THREADS; ++i) {
			Thread temp = new Thread(new RandomSleepRunnable(i));
			pool.add(temp);
			temp.start();
		}

		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("All threads terminated");
	}

}