package gettingstarted;

import java.math.BigDecimal;

public class EmailReceipt implements Receipt {

	public void addItem(String item, BigDecimal price) {
		System.out.println(String.format("Item:%s Cost: %s", item, price));
	}
}
