package sd3.com.main;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import sd3.com.model.NameRecord;

/**
 *
 * @author K00241356
 */
public class SearchCallable implements Callable<Double> {

    List<NameRecord> list;
    String name; //accepting the three arguments
    int y1;
    int y2;

    public SearchCallable(List<NameRecord> list, String name, int y1, int y2) {
        this.name = name;
        this.list = list;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public Double call() throws Exception {
	
		System.out.println("Search Callable begins at:"+ new Date());
        int totals[] = new int[2];
        
        for (NameRecord aName : list) {
            if (aName.getYear() == y1 && aName.getName().equalsIgnoreCase(name)) {
               totals[0] = aName.getOccurrences();
            }
            if (aName.getYear() == y2 && aName.getName().equalsIgnoreCase(name)) {
                totals[1] = aName.getOccurrences();
            }
        }

        int diff = totals[0] - totals[1]; // getting the percentage difference
        return  (double) diff/totals[0]; // returning the percentage differnce as a decimal
        
        
            
    }

}
