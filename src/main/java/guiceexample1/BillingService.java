package guiceexample1;

public interface BillingService {
	public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);
}
