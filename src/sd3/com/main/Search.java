/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sd3.com.main;

import java.util.List;
import java.util.concurrent.Callable;
import sd3.com.model.Name;

/**
 *
 * @author K00241356
 */
public class Search implements Callable<Double> {

    List<Name> list;
    String name; //accepting the three arguments
    int y1;
    int y2;

    public Search(List<Name> list, String name, int y1, int y2) {
        this.name = name;
        this.list = list;
        this.y1 = y1;
        this.y2 = y2;
    }

    @Override
    public Double call() throws Exception {
        int totals[] = new int[2];
        
        for (Name aName : list) {
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
