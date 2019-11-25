package helloworld;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

/**
 * http://projects.spring.io/spring-boot/
 * http://docs.spring.io/spring-boot/docs/1.3.5.RELEASE/reference/htmlsingle/#using-boot-starter-poms
 * 
 * http://localhost:8080/ or type: curl localhost:8080
 * 
 * 
 * There is also a /shutdown endpoint, but it’s only visible by default via JMX.
 * To enable it as an HTTP endpoint, add endpoints.shutdown.enabled=true to your
 * application.properties file. It’s easy to check the health of the app.
 * 
 * $ curl localhost:8080/health {"status":"UP"} You can try to invoke shutdown
 * through curl.
 * 
 * $ curl -X POST localhost:8080/shutdown {"timestamp":1401820343710,"error":
 * "Method Not Allowed","status":405,"message":
 * "Request method 'POST' not supported"} Because we didn’t enable it, the
 * request is blocked by the virtue of not existing.
 * 
 * For more details about each of these REST points and how you can tune their
 * settings with an application.properties file, you can read detailed docs
 * about the endpoints.
 * 
 * 
 */
@Controller
@EnableAutoConfiguration
public class HelloController {

	public HelloController(){
		
	}
	
	@RequestMapping("/")
	@ResponseBody
	String home() {
		return "Greetings from Spring Boot!\n";
	}

	@RequestMapping("/jvm")
	@ResponseBody
	String jvm() {
		int MEGA_BYTES = 1024 * 1024;
		StringBuilder sb = new StringBuilder();

		// Getting the runtime reference from system
		Runtime runtime = Runtime.getRuntime();

		sb.append("##### Heap utilization statistics [MB] #####");
		sb.append("\n");

		// Print Maximum available memory
		sb.append("Max Memory:" + runtime.maxMemory() / MEGA_BYTES);
		sb.append(" ");

		// Print total available memory
		sb.append("Total Memory:" + runtime.totalMemory() / MEGA_BYTES);
		sb.append(" ");

		// Print used memory
		sb.append("Used Memory:" + (runtime.totalMemory() - runtime.freeMemory()) / MEGA_BYTES);
		sb.append(" ");

		// Print free memory
		sb.append("Free Memory:" + runtime.freeMemory() / MEGA_BYTES);
		sb.append("\n ");

		return sb.toString();

	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(HelloController.class, args);
	}
}