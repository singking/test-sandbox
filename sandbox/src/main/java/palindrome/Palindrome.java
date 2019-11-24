package palindrome;

/**
 * 
 * @author zhane
 *
 */
public class Palindrome {

	
	/**
	 * 
	 * @param palindromeString
	 * @return
	 */
	int scorePalindrome(String palindromeString){
		
		String nw = normalise(palindromeString);
		
		StringBuilder sb =new StringBuilder(nw);
	
		String reversed = sb.reverse().toString();
		
		if (!checkPalindrome(nw, reversed)){
			return 0;
		}
		
		return palindromeString.length()/2;
	}
	
	/**
	 * Remove space and make lowercase
	 * 
	 * @param p
	 * @return
	 */
	String normalise(String p){

		StringBuilder sb=new StringBuilder();
		for (int i=0; i<p.length(); i++){
			if (Character.isLetterOrDigit(p.charAt(i))){
				sb.append(Character.toLowerCase(p.charAt(i)));
			}
		}
		
		return sb.toString();
	}
	
	/**
	 * 
	 * @param original
	 * @param reversedString
	 * @return
	 */
	boolean checkPalindrome(String original, String reversedString){
		if (original.length()!=reversedString.length()){
			return false;
		}
		
		for (int i=0; i<original.length(); i++){
//			if (original.charAt(i) != reversedString.charAt(original.length() -1 - i)){
			if (original.charAt(i) != reversedString.charAt(i)){
				return false;
			}
		}
		
		return true;
	}
}
