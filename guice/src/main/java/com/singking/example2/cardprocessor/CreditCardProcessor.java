package guice.example2.cardprocessor;

import java.math.BigDecimal;

public interface CreditCardProcessor {
	void debit(BigDecimal price);
}
