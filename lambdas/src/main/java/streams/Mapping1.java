package lambdas.streams;

import java.util.Arrays;

public class Mapping1 {

	public static void main(String[] args) {

		String[] txt = { "State", "of", "the", "Lambda", "Libraries", "Edition" };
		Arrays.stream(txt)
		.filter(s -> s.length() > 3)
		.map(s -> s.length())
		.forEach(l -> System.out.println(l));
	}

}
