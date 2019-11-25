package helloworld;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SpringLifecycle {

	@Autowired
	private Date datenow;

	@Autowired
	private ApplicationContext context;

	public SpringLifecycle() {
		System.out.println("Constructer - ready");
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("postConstruct - ready: " + datenow);
		System.out.println("postConstruct - context: " + context);

	}
}
