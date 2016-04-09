package guiceexample1.carprocessor;

import java.math.BigDecimal;

public class PaypalCreditCardProcessor implements CreditCardProcessor {

	PaypalCreditCardProcessor() {
	}

	public void debit(BigDecimal price) {
		System.out.println("Contacting Paypal with debit amount: " + price);
	}
}
