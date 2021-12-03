package sd3.com.main;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import static sd3.com.IO.FileIO.parseFile;
import sd3.com.model.Name;

public class Main {

	static List<Name> list = new ArrayList();
	static NumberFormat nf = NumberFormat.getPercentInstance();

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		System.out.println("Main begins at:"+ new Date());

		//task 1
		list = parseFile("CA.txt"); //reading the list of names from the file

		ExecutorService exe = Executors.newCachedThreadPool();
		SearchCallable searchCallable = new SearchCallable(list, "Paul", 2000, 2017);
		Future<Double> searchFuture = exe.submit(searchCallable);

		nf.setMaximumFractionDigits(2);
		System.out.println("Waiting 1 at:"+ new Date());
		System.out.println("Percentage Diff " + nf.format(searchFuture.get()));
		System.out.println("Waiting 2 at:"+ new Date());
		exe.submit(new Print(list, "Zack")); // printing out 

		exe.shutdown();

	}

}
