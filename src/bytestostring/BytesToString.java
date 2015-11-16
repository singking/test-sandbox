package bytestostring;
import java.io.UnsupportedEncodingException;

public class BytesToString {

	public static String convert(byte[] bytes)
			throws UnsupportedEncodingException {
		return new String(bytes, "UTF-8");
	}

	public static void main(String[] args) throws UnsupportedEncodingException {

		byte[] bytes = { 66, 82, 58, 83, 85, 66, 67, 77, 80, 84, 82, 58, 52,
				54, 47, 91, 51, 93 };
		System.out.println("s=" + convert(bytes));

		byte[] bytes1 = { 68, 97, 110, 110, 121, 32, 71, 117, 116, 104, 114,
				105, 101 };
		System.out.println("s=" + convert(bytes1));

	}
}
