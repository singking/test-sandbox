package com.singking.simplejaxwsservice;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * http://cxf.apache.org/docs/a-simple-jax-ws-service.html#AsimpleJAX-WSservice-
 * Settingupyourbuild
 *
 */
@WebService(endpointInterface = "demo.hw.server.HelloWorld", serviceName = "HelloWorld")
public class HelloWorldImpl implements HelloWorld {

	Map<Integer, User> users = new LinkedHashMap<Integer, User>();

	public String sayHi(String text) {
		System.out.println("sayHi called");
		return "Hello " + text;
	}

	public String sayHiToUser(User user) {
		System.out.println("sayHiToUser called");
		users.put(users.size() + 1, user);
		return "Hello " + user.getName();
	}

	public Map<Integer, User> getUsers() {
		System.out.println("getUsers called");
		return users;
	}

	public static void main(String[] args) {
		System.out.println("Starting Server");
		HelloWorldImpl implementor = new HelloWorldImpl();
		String address = "http://localhost:9000/helloWorld";
		Endpoint.publish(address, implementor);
	}
}