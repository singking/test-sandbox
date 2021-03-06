package guice.example2;

import com.google.inject.Guice;
import com.google.inject.Injector;

import guice.example2.creditcards.MasterCard;
import guice.example2.pizzas.Supreme;

public class Main {

	public static void main(String[] args) {
		/*
		 * Guice.createInjector() takes your Modules, and returns a new Injector
		 * instance. Most applications will call this method exactly once, in
		 * their main() method.
		 */
		Injector injector = Guice.createInjector(new BillingModuleMain());

		/*
		 * Now that we've got the injector, we can build objects.
		 */
		RealBillingService billingService = injector.getInstance(RealBillingService.class);
		billingService.chargeOrder(new Supreme(), new MasterCard());
	}
}
