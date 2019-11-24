package slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class Slf4jHelloWorld {

	public static void main(String[] args) {
	    Logger logger = LoggerFactory.getLogger(Slf4jHelloWorld.class);
	    logger.trace("Hello World");
	    logger.debug("Hello World");
	    logger.info("Hello World");
	    logger.warn("Hello World");
	    logger.error("Hello World");
	  }
}
