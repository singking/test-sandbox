package com.singking.springutil;

import java.util.Enumeration;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main1 {

	/**
	 * @param map
j	 */
	public void populatemap(Map map) {
		// Get all system properties
		Properties props = System.getProperties();

		// Enumerate all system properties
		Enumeration enums = props.propertyNames();
		for (; enums.hasMoreElements();) {
			// Get property name
			String propName = (String) enums.nextElement();

			// Get property value
			String propValue = (String) props.get(propName);
			map.put(propName, propValue);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring-beans.xml" });

		EnvironmentVariables  vars = (EnvironmentVariables) context
				.getBean("env-vars");

		Main1 main = new Main1();
		main.populatemap(vars);
		
		for (String key: (Set<String>)vars.keySet()) {
			System.out.println(String.format("key[%s] value[%s]", key, (String)vars.get(key)));
		}	
	}
}
