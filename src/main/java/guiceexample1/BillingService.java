package guiceexample1;

import guiceexample1.creditcards.CreditCard;
import guiceexample1.pizzas.PizzaOrder;

public interface BillingService {
	public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
