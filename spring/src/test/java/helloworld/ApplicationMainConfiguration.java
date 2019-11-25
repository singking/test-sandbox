package helloworld;

import java.util.Date;

import org.springframework.context.annotation.Bean;

public class ApplicationMainConfiguration {

	@Bean
	public Date getDateNow() {
		return new Date();
	}

}
