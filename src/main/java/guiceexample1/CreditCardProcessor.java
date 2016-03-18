package gettingstarted;

import java.math.BigDecimal;

public interface CreditCardProcessor {
	void debit(BigDecimal price);
}
