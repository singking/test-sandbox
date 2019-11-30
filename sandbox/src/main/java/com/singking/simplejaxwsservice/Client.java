package com.singking.simplejaxwsservice;

import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;


public final class Client {

    private static final QName SERVICE_NAME 
        = new QName("http://server.hw.demo/", "HelloWorld");
    private static final QName PORT_NAME 
        = new QName("http://server.hw.demo/", "HelloWorldPort");


    private Client() {
    } 

    public static void main(String args[]) throws Exception {
        Service service = Service.create(SERVICE_NAME);
        // Endpoint Address
        String endpointAddress = "http://localhost:9000/helloWorld";
        // If web service deployed on Tomcat (either standalone or embedded)
        // as described in sample README, endpoint should be changed to:
        // String endpointAddress = "http://localhost:8080/java_first_jaxws/services/hello_world";

        // Add a port to the Service
        service.addPort(PORT_NAME, SOAPBinding.SOAP11HTTP_BINDING, endpointAddress);
        
        HelloWorld hw = service.getPort(HelloWorld.class);
        System.out.println(hw.sayHi("World"));

        User user = new UserImpl(1L, "peter", "pan");
        System.out.println(hw.sayHiToUser(user));

        //say hi to some more users to fill up the map a bit
        user = new UserImpl(2L, "clark", "kent");
        System.out.println(hw.sayHiToUser(user));

        user = new UserImpl(3L, "spider", "man??");
        System.out.println(hw.sayHiToUser(user));

        System.out.println();
        System.out.println("Users: ");
        Map<Integer, User> users = hw.getUsers();
        for (Map.Entry<Integer, User> e : users.entrySet()) {
            System.out.println("  " + e.getKey() + ": " + e.getValue().getName());
        }

    }

}