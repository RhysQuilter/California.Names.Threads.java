package sd3.com.main;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import sd3.com.model.NameRecord;

/**
 *
 * @author Rhys Quilter <https://github.com/RhysQuilter>
 */
public class Task3Runnable implements Runnable {

	private final List<NameRecord> list;

	public Task3Runnable(List<NameRecord> list) {
		this.list = list;
	}

	@Override
	public void run() {
		System.out.println("Task3 Runnable begins at:" + new Date());

		int randomYear = getRandomYear();

		String[] genders = {"F", "M"};
		for (String gender : genders) {
			Optional<NameRecord> popularMaleNames = list.stream()
					.filter(nameRecord -> nameRecord.getYear() == randomYear)
					.filter(nameRecord -> nameRecord.getGender().equalsIgnoreCase(gender))
					.max(Comparator.comparing(NameRecord::getOccurrences));

			System.out.println(popularMaleNames.get());
		}
	}

	private int getRandomYear() {
		int minYear = 1910;
		int maxYear = 2017;
		return ThreadLocalRandom.current().nextInt(minYear, maxYear + 1);
	}

}
