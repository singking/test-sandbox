package guiceexample1;

import com.google.inject.Inject;

public class RealBillingService implements BillingService {
	private final CreditCardProcessor processor;
	private final TransactionLog transactionLog;

	@Inject
	RealBillingService(CreditCardProcessor processor,
			TransactionLog transactionLog) {
		this.processor = processor;
		this.transactionLog = transactionLog;
	}

	public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard) {
		transactionLog.info("starting transaction for order :" + order);

		if (creditCard.getAuthorisation()) {
			System.err.println("authorisation failed - exiting");

			return new EmailReceipt();
		}

		transactionLog.info(String.format("account [%s] authorised transacton",
				creditCard.getAccountNo()));

		processor.debit(order.price());

		transactionLog.info("ending transaction :" + order.price());
		Receipt receipt = new EmailReceipt();
		receipt.addItem(order.toString(), order.price());

		return receipt;
	}

}