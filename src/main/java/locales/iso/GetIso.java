package locales.iso;

import java.util.Locale;

public class GetIso {

	public static void main(String[] args) {
		Locale l = new Locale("en_US");
		System.out.println("1" + l);
		System.out.println("2" + l.getLanguage());
		System.out.println("3" + l.getDisplayCountry());
		System.out.println("4" + l.getISO3Country());

		Locale l2 = new Locale("en_US");
		System.out.println(l2.getLanguage());
	}
}
