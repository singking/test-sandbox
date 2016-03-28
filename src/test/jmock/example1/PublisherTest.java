package example1;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * http://www.jmock.org/getting-started.html
 * 
 * In this simple example we are going to write a mock object test for a
 * publish/subscribe message system. A Publisher sends messages to zero or more
 * Subscribers. We want to test the Publisher, which involves testing its
 * interactions with its Subscribers.
 * 
 */
public class PublisherTest {
	Mockery context = new Mockery();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * http://www.jmock.org/getting-started.html
	 */
	@Test
	public void testOneSubscriberReceivesAMessage() {
		
		// create a subsciber based on the subscriber INTERFACE
		final Subscriber subscriber = context.mock(Subscriber.class);

		Publisher publisher = new Publisher();
		publisher.add(subscriber);

		final String message = "yo! TK";

		/* expectations
		 * http://www.jmock.org/expectations.html
		 */
		context.checking(new Expectations() {
			{
				oneOf(subscriber).receive(message);
			}
		});

		// execute
		//publisher.publish(message);
		publisher.publish("yo! TK");

		// verify
		context.assertIsSatisfied();
	}

}
