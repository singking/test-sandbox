package guice.example2;

import guice.example2.creditcards.CreditCard;
import guice.example2.pizzas.PizzaOrder;

public interface BillingService {
	public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
