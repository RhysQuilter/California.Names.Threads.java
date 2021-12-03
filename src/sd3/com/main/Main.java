package sd3.com.main;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import static sd3.com.IO.FileIO.parseFile;
import sd3.com.model.NameRecord;

public class Main {

	static List<NameRecord> list = new ArrayList();
	static NumberFormat nf = NumberFormat.getPercentInstance();

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Main begins at:" + new Date());

		list = parseFile("CA.txt"); //reading the list of names from the file

		//ExecutorService executorService = Executors.newCachedThreadPool();
		int numberOfThreads = 3;
		final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(numberOfThreads);
		/*Task one*/
		SearchCallable searchCallable = new SearchCallable(list, "Paul", 2000, 2017);
		Future<Double> searchFuture = executorService.submit(searchCallable);
		/*Task two*/
		PrintRunnable printRunnable = new PrintRunnable(list, "Zack");
		executorService.submit(printRunnable);
		/*Task three*/
		int initialDelay = 5;//after an initial delay of 5 seconds.
		int delay = 3;// Runnable that will execute every 3 seconds
		executorService.scheduleWithFixedDelay(new Task3Runnable(list), initialDelay, delay, TimeUnit.SECONDS);

		/*Task one: Future */
		nf.setMaximumFractionDigits(2);
		System.out.println("Percentage Diff " + nf.format(searchFuture.get()));
	Thread.sleep(30_000);
		executorService.shutdown();

	}

}
