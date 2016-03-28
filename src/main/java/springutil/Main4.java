package springutil;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * http://forum.springsource.org/showthread.php?76039-util-map-key-type-quot-
 * java.lang.Class-quot
 * http://static.springsource.org/spring/docs/2.0.x/reference/xsd-config.html
 *
 * set vm arg to -Denvironment=prod so properties file is used mail-prod.properties
 * set vm arg to -Denvironment=uat so properties file is used mail-uat.properties
 */
public class Main4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring-beans2.xml" });

		Servers s = (Servers) context.getBean("server");

		System.out.println(String.format("popServer[%s] smtpServer[%s]", s.getPopServer(),
				s.getSmtpServer()));
		
	}
}
