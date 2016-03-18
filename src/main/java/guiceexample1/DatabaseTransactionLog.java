package gettingstarted;

public class DatabaseTransactionLog implements TransactionLog {

	public void info(String message) {
		System.out.println("DatabaseTransactionLog: " + message);
	}

}
