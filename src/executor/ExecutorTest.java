import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class ExecutorTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Runnable runnable = () -> {
			System.out.println("inside : " + Thread.currentThread().getName());
		};

		executorService.submit(runnable);
	}
}