package springutil;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://forum.springsource.org/showthread.php?76039-util-map-key-type-quot-java.lang.Class-quot
 * http://static.springsource.org/spring/docs/2.0.x/reference/xsd-config.html
 * 
 */
public class Main2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring-beans.xml" });

		EnvironmentVariables  vars = (EnvironmentVariables) context
				.getBean("emails");

		Main2 main = new Main2();
		
		for (String key: (Set<String>)vars.keySet()) {
			System.out.println(String.format("key[%s] value[%s]", key, (String)vars.get(key)));
		}
	}
}
