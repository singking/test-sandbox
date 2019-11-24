package dates;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

	public static void main(String[] args) {

		Calendar currentCalendarDate = Calendar.getInstance();
		// c.add(Calendar.WEEK_OF_MONTH, 5);

		System.out.println("current date: "
				+ new Date(currentCalendarDate.getTimeInMillis()));

		Calendar leavingDate = Calendar.getInstance();
		leavingDate.set(Calendar.DAY_OF_MONTH, 24);
		leavingDate.set(Calendar.MONTH, 1);
		leavingDate.set(Calendar.YEAR, 2015);

		long diff = leavingDate.getTimeInMillis()
				- currentCalendarDate.getTimeInMillis();

		System.out.println("millI-seconds: " + diff);
		System.out.println("seconds: " + diff / (1_000));
		System.out.println("minutes: " + diff / (1_000 * 60));
		System.out.println("hours: " + diff / (1_000 * 60 * 60));
		System.out.println("days: " + diff / (1_000 * 60 * 60 * 24));

	}
}
