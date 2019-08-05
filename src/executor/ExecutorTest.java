import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Runnable task1 = () -> {
			System.out.println("Executing Task1 inside : " + Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (Exception e) {
				e.printStackTrace();
			}
		};

		Runnable task2 = () -> {
			System.out.println("Executing Task2 inside : " + Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(4);
			} catch (InterruptedException ex) {
				throw new IllegalStateException(ex);
			}
		};

		Runnable task3 = () -> {
			System.out.println("Executing Task3 inside : " + Thread.currentThread().getName());
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException ex) {
				throw new IllegalStateException(ex);
			}
		};

		System.out.println("Executing Task1");
		executorService.submit(task1);

		System.out.println("Executing Task2");
		executorService.submit(task2);

		System.out.println("Executing Task3");
		executorService.submit(task3);

		System.out.println("Shutting down...");
		executorService.shutdown();


		// ScheduledExecutorService
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

		Runnable task = () -> {
			System.out.println("Executing at " + System.nanoTime());
		};

		System.out.println("scheduling task to be executed every 2 seconds with an initial delay of 0 seconds");
		scheduledExecutorService.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
	}
}