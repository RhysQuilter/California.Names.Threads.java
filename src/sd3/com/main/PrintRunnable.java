package sd3.com.main;

import java.util.Date;
import java.util.List;
import sd3.com.model.NameRecord;

public class PrintRunnable implements Runnable {

	List<NameRecord> list;
	String name;

	public PrintRunnable(List<NameRecord> list, String name) {
		this.list = list;
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println("Search Print Runnable begins at:" + new Date());

		int totalYearOccurences = 0;
		for (NameRecord nameRecord : list) {
			if (nameRecord.getName().equalsIgnoreCase(name)) {
				System.out.println(nameRecord.getYear() + "\t" + nameRecord.getOccurrences());
				totalYearOccurences++;
			}
		}
		System.out.println(name + " was found " + totalYearOccurences + " records");
	}
}
