package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Extracting {

	public static void main(String[] args) {
		Pattern p = Pattern.compile("/\\[(\\d*)\\]$");
		Matcher m = p.matcher("BR:SUBCMMPTR:49/[99]");

		if (m.find()) {
			System.out.println("matched=" + m.group(1));
		} else {
			System.out.println("no match");
		}

	}

}
