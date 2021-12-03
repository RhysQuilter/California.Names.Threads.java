package sd3.com.main;


import java.text.NumberFormat;
import java.util.ArrayList;
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

        //task 1
        
        list = parseFile("CA.txt"); //reading the list of names from the file
        
        ExecutorService exe = Executors.newCachedThreadPool();
        Future<Double> f1 = exe.submit(new Search(list, "Paul", 2000, 2017));
        
        nf.setMaximumFractionDigits(2);
        System.out.println("Percentage Diff " + nf.format(f1.get()));
        exe.submit(new Print(list, "Zack")); // printing out 
        
        exe.shutdown();

    }

}
