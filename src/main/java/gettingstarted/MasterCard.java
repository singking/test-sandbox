package gettingstarted;

import java.math.BigDecimal;

public class MasterCard extends CreditCard {
	BigDecimal balance = BigDecimal.valueOf(100.10);

	public BigDecimal balance() {
		// TODO Auto-generated method stub
		return balance;
	}

	public String getAccountNo() {
		return accountNo;

	}

	public boolean getAuthorisation() {
		// TODO Auto-generated method stub
		return false;
	}
}
