package guice.example4;

import com.google.inject.AbstractModule;

import guiceexample2.di.services.EmailService;
import guiceexample2.di.services.MessageService;

public class AppInjector extends AbstractModule {

	@Override
	protected void configure() {
		// bind the service to implementation class
		bind(MessageService.class).to(EmailService.class);

		// bind MessageService to Facebook Message implementation
		// bind(MessageService.class).to(FacebookService.class);
	}
}
