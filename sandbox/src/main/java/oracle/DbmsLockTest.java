package oracle;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DbmsLockTest implements Runnable {
	Connection con;
	String key;
	int timeout;

	public DbmsLockTest(Connection con, String key, int timeout) {
		this.con = con;
		this.key = key;
		this.timeout = timeout;
	}

	public static void log(String str) {
		System.out.println(new Date() + " - "
				+ Thread.currentThread().getName() + " - " + str);
	}

	@Override
	public void run() {
		lockKey(con, key, timeout);
	}

	public static void lockKey(Connection con, String key, int timeout) {
		log("start lockKey " + "  key: " + key);

		CallableStatement cStmt = null;
		int rc = 0;
		try {
			StringBuilder sql = new StringBuilder(500);
			sql.append("DECLARE");
			sql.append("   v_lockhandle VARCHAR2(200);");
			sql.append("BEGIN");
			sql.append("   dbms_lock.allocate_unique(lockname    => ?,  lockhandle  => v_lockhandle);");
			sql.append("   ? := dbms_lock.request(lockhandle  => v_lockhandle, lockmode        => 6,");
			sql.append("   						  timeout         => ?, release_on_commit   =>true);");
			sql.append("   ? := v_lockhandle;");
			sql.append("END;");

			String lockKey = "LockKey-" + key;

			cStmt = con.prepareCall(sql.toString());
			cStmt.setString(1, lockKey);
			cStmt.registerOutParameter(2, Types.NUMERIC);
			cStmt.setInt(3, timeout);
			cStmt.registerOutParameter(4, Types.VARCHAR);

			log("executeUpdate start: " + lockKey + "] ");
			cStmt.executeUpdate();
			log("executeUpdate end: " + lockKey + "] ");

			rc = cStmt.getInt(2);
			log("return value from request=[" + rc + "] ");

			if (rc != 0) {

				System.out.println("6001 lock obtained: "
						+ Thread.currentThread().getName());
				throw new RuntimeException("lock acquisition failed with code="
						+ rc);
			}

			log("v_lockhandle=[" + cStmt.getString(4) + "] ");

			for (int i = 0; i < 4; i++) {
				try {
					Thread.sleep(1000 * 1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				log("***** protected code iteration ***** " + i);
			}

			// con.commit();

		} catch (SQLException e) {
			log("int timeout: " + Thread.currentThread().getName());
			throw new RuntimeException("SQLException locking balance for user "
					+ key, e);
		} finally {
			try {
				if (cStmt != null) {
					cStmt.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		log("Exiting=[" + rc + "] ");
	}

	public static void main(String[] args) throws Exception {
		new oracle.jdbc.OracleDriver();
		List<Thread> list = new ArrayList<Thread>();
		for (int i = 0; i < 2; i++) {
			Connection connection = DriverManager
					.getConnection("jdbc:oracle:thin:@localhost:1521:xe",
							"system", "password");
			connection.setAutoCommit(false);
			Thread t = new Thread(new DbmsLockTest(connection, "mykey", 10));
			list.add(t);
		}

		for (Thread t : list) {
			t.start();
		}
	}
}