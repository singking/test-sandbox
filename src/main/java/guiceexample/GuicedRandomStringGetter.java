package guiceexample;

import java.io.IOException;
import us.monoid.web.Resty;

public class GuicedRandomStringGetter {
	public final static String RANDOM_SERVICE= "http://www.random.org/strings/?num=1&len=10&digits=on&upperalpha=on&loweralpha=on&unique=off&format=plain&rnd=new";
	
	public String getNextWord() {
		System.out
				.println("GuicedRandomStringGetter says: Time to get another random string!");
		try {
			return new Resty()
					.text(RANDOM_SERVICE)
					.toString();
		} catch (IOException e) {
			return "ERRORERROR";
		}
	}
}
