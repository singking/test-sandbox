package guiceexample1;

import java.math.BigDecimal;

public class Supreme extends PizzaOrder {

	@Override
	BigDecimal price() {
		return BigDecimal.valueOf(9.99);
	}

	@Override
	public String toString() {
		return "Supreme [beef, peperoni, green peppers]";
	}

}
