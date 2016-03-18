package gettingstarted;

public interface BillingService {

	public Receipt chargeOrder(PizzaOrder order, CreditCard creditCard);

}
