package com.singking.soap;

import javax.jws.WebService;

/*
 * http://java.dzone.com/articles/jax-ws-hello-world
 */
@WebService(endpointInterface = "soap.Greeting")
public class GreetingImpl implements Greeting {

	@Override
	public String sayHello(String name) {
		return "Hello, Welcom to jax-ws " + name;
	}

}