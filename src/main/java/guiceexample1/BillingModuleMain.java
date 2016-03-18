package gettingstarted;

/**
 * https://code.google.com/p/google-guice/wiki/GettingStarted
 */
import com.google.inject.AbstractModule;

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
