package guice.example2.creditcards;

public abstract class CreditCard {

	String accountNo = "9834543535";

	public abstract String getAccountNo();
	public abstract boolean getAuthorisation();
}
