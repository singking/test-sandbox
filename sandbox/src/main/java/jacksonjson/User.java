package jacksonjson;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * http://wiki.fasterxml.com/JacksonInFiveMinutes
 * 
 */
public class User {
	public enum Gender {
		MALE, FEMALE
	};

	public static class Name {
		private String first, last;

		@Override
		public String toString() {
			return "Name [first=" + first + ", last=" + last + "]";
		}

		public String getFirst() {
			return first;
		}

		public String getLast() {
			return last;
		}

		public void setFirst(String s) {
			first = s;
		}

		public void setLast(String s) {
			last = s;
		}
	}

	private Gender gender;
	private Name name;
	private boolean isVerified;
	private byte[] userImage;

	public Name getName() {
		return name;
	}

	public boolean isVerified() {
		return isVerified;
	}

	public Gender getGender() {
		return gender;
	}

	public byte[] getUserImage() {
		return userImage;
	}

	public void setName(Name n) {
		name = n;
	}

	public void setVerified(boolean b) {
		isVerified = b;
	}

	public void setGender(Gender g) {
		gender = g;
	}

	public void setUserImage(byte[] b) {
		userImage = b;
	}

	@Override
	public String toString() {
		return "User [gender=" + gender + ", name=" + name + ", isVerified=" + isVerified + ", userImage="
				+ Arrays.toString(userImage) + "]";
	}

	public static void main(String[] args) throws Exception, IOException {

		// It takes two lines of Java to turn it into a User instance:
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		User user = mapper.readValue(new File("user.json"), User.class);
		System.out.println(user);

		// Marshalling back to JSON is similarly straightforward
		User user1 = new User();
		Name name = new Name();
		name.setFirst("Pistol");
		name.setLast("Pete");

		user1.setName(name);
		user1.setVerified(false);
		user1.setGender(Gender.FEMALE);
		mapper.writeValue(new File("pistolpete.json"), user1);

		System.out.println("done");

	}
}