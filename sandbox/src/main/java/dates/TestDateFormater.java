package dates;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Locale;

public class TestDateFormater {

	public static void main(String[] args) {

		DateFormat df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.US);

		try {
			System.out.println(df.parse("12:00 pm"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
