package palindrome;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class MainWebContainerTestRunner {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub

		System.out.println("Jetty starting...");

		WebAppContext root = new WebAppContext();
		root.setContextPath("/abp");
		root.setResourceBase("src/main/webapp/");
		root.setDescriptor(root.getResourceBase() + "/WEB-INF/web.xml");
		root.setParentLoaderPriority(true);

		Server server = new Server(8081);
		server.setSendServerVersion(false);
		server.setSendDateHeader(false);
		server.setHandler(root);

		server.start();
		server.join();
		System.out.println("Jetty started...");
	}
}
