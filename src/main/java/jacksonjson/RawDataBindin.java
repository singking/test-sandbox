package jacksonjson;

import java.io.File;
import java.io.IOException;
import java.util.Map;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonParseException;

public class RawDataBindin {

	/**
	 * @param args
	 * @throws IOException
	 * @throws JsonMappingException
	 * @throws JsonParseException
	 */
	public static void main(String[] args) throws Exception, IOException {

		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

		// "Raw" Data Binding Example
		Map<String, Object> userData = mapper.readValue(new File("user.json"), Map.class);

		for (Object o : userData.keySet()) {
			System.out.println(String.format("key=%s value=%s", o.toString(), userData.get(o)));
		}
		System.out.println(userData);

		// Map<String,User> result = mapper.readValue(src, new
		// TypeReference<Map<String,User>>() { });
	}
}