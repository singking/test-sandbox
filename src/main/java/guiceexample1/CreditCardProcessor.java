package guiceexample1;

import java.math.BigDecimal;

public interface CreditCardProcessor {
	void debit(BigDecimal price);
}
