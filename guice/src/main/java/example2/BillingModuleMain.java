package guice.example2;

/**
 * https://code.google.com/p/google-guice/wiki/GettingStarted
 */
import com.google.inject.AbstractModule;

import guice.example2.cardprocessor.CreditCardProcessor;
import guice.example2.cardprocessor.PaypalCreditCardProcessor;
import guice.example2.logging.DatabaseTransactionLog;
import guice.example2.logging.TransactionLog;

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
