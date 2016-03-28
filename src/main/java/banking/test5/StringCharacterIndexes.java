package banking.test5;

import java.util.ArrayList;
import java.util.List;

public class StringCharacterIndexes {

	/**
	 * Returns a Map of integers that occurs only twice in the integer array
	 * passed
	 * 
	 * @return
	 */
	public static List<Integer> findIndexOfFourIdenticalCharacters(String charList) {

		assert charList.length() >= 4;

		// list of sequences
		List<Integer> occurrencesList = new ArrayList<Integer>();

		// iterate the test string a character at a time
		for (int i = 0; i < charList.length(); i++) {

			// test the current letter and the next three
			// consecutive letters are identical
			if (i + 4 <= charList.length()) {
				if (charList.charAt(i) == charList.charAt(i + 1) && charList.charAt(i) == charList.charAt(i + 2)
						&& charList.charAt(i) == charList.charAt(i + 3)) {

					// add current index to the list of indices found
					occurrencesList.add(i);
				}

			}

		}

		return occurrencesList;
	}

	public static void main(String[] args) {
		String charList = "ABCDEFFFGGHIIKLLLLMNO";
		charList = "ABCDEFFFGGHIIKLLLLMNO";

		charList = "LLLL";
		charList = "ABCLLLLLLLLDEFFFFGGHIIKLLLMNO";
		charList = "a";
		charList = "ABCLLLLDEFFFFGGHIIKLLLMNOLLLL";

		List<Integer> occurrencesList = findIndexOfFourIdenticalCharacters(charList);

		for (int i = 0; i < charList.length(); i++) {
			System.out.print(charList.charAt(i) + ", ");
		}

		System.out.println("\n");
		System.out.println("Double Occurences Follow");
		System.out.println("----------");
		for (int i = 0; i < occurrencesList.size(); i++) {
			System.out.print(occurrencesList.get(i) + ", ");
		}

	}

}
