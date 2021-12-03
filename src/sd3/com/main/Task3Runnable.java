package sd3.com.main;

import java.util.Date;
import java.util.List;
import sd3.com.model.NameRecord;

/**
 *
 * @author Rhys Quilter <https://github.com/RhysQuilter>
 */
public class Task3Runnable implements Runnable {

	public Task3Runnable(List<NameRecord> list) {
	}

	@Override
	public void run() {
		System.out.println("Task3 Runnable begins at:"+ new Date());
	}

}
