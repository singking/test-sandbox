package guiceexample1.carprocessor;

import java.math.BigDecimal;

public interface CreditCardProcessor {
	void debit(BigDecimal price);
}
