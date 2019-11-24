package cxf.simplejaxwsservice;

import javax.xml.ws.Endpoint;


/**
 * http://svn.apache.org/repos/asf/cxf/trunk/distribution/src/main/release/samples/java_first_jaxws/src/main/java/demo/hw/server/Server.java
 *
 */
public class Server {

    protected Server() throws Exception {
        // START SNIPPET: publish
        System.out.println("Starting Server");
        HelloWorldImpl implementor = new HelloWorldImpl();
        String address = "http://localhost:9000/helloWorld";
        Endpoint.publish(address, implementor);
        // END SNIPPET: publish
    }

    public static void main(String args[]) throws Exception {
        new Server();
        System.out.println("Server ready...");

        Thread.sleep(5 * 60 * 1000);
        System.out.println("Server exiting");
        System.exit(0);
    }
    /**
    public static void main2(String[] args) {
    	HelloWorldImpl implementor = new HelloWorldImpl();
    	JaxWsServerFactoryBean svrFactory = new JaxWsServerFactoryBean();
    	svrFactory.setServiceClass(HelloWorld.class);
    	svrFactory.setAddress("http://localhost:9000/helloWorld");
    	svrFactory.setServiceBean(implementor);
    	svrFactory.getInInterceptors().add(new LoggingInInterceptor());
    	svrFactory.getOutInterceptors().add(new LoggingOutInterceptor());
    	svrFactory.create();
	}
	*/
}
