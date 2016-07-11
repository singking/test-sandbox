package guiceexample1;

/**
 * https://code.google.com/p/google-guice/wiki/GettingStarted
 */
import com.google.inject.AbstractModule;

import guiceexample1.carprocessor.CreditCardProcessor;
import guiceexample1.carprocessor.PaypalCreditCardProcessor;
import guiceexample1.logging.DatabaseTransactionLog;
import guiceexample1.logging.TransactionLog;

public class BillingModuleMain extends AbstractModule {
	@Override
	protected void configure() {

		/*
		 * This tells Guice that whenever it sees a dependency on a
		 * TransactionLog, it should satisfy the dependency using a
		 * DatabaseTransactionLog.
		 */
		bind(TransactionLog.class).to(
				(Class<? extends TransactionLog>) DatabaseTransactionLog.class);

		/*
		 * Similarly, this binding tells Guice that when CreditCardProcessor is
		 * used in a dependency, that should be satisfied with a
		 * PaypalCreditCardProcessor.
		 */
		bind(CreditCardProcessor.class)
				.to((Class<? extends CreditCardProcessor>) PaypalCreditCardProcessor.class);
	}

}
