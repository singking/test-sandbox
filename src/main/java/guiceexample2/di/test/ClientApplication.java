package guiceexample2.di.test;

import com.google.inject.Guice;
import com.google.inject.Injector;

import guiceexample2.di.consumer.MyApplication;
import guiceexample2.di.injector.AppInjector;

public class ClientApplication {

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new AppInjector());

		MyApplication app = injector.getInstance(MyApplication.class);

		app.sendMessage("Hi Pankaj", "pankaj@abc.com");
	}
}
