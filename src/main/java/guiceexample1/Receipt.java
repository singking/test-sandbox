package guiceexample1;

import java.math.BigDecimal;

public interface Receipt {
	void addItem(String item, BigDecimal price);
}
