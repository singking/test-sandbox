package concurrency.threading;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Account2Test {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAccount2() {
		Account2 acc = new Account2(100);
		acc.startPeriodicInterest();
		StopForTesting.stop(acc, 2);

		/*
		 * Asserts that two doubles or floats are equal to within a positive
		 * delta. If they are not, an AssertionError is thrown. If the expected
		 * value is infinity then the delta value is ignored.NaNs are considered
		 * equal: assertEquals(Double.NaN, Double.NaN, *) passes
		 */
		assertEquals(100.0, acc.getAmount(), 2.0);

	}

	@Test
	public void testGetAmount() {
		Account2 acc = new Account2(100);
		assertEquals(100, acc.getAmount(), 0.0);
	}

	@Test
	public void testStop() {
		Account2 acc = new Account2(100);
		acc.startPeriodicInterest();
		StopForTesting.stop(acc, 2);
		assertTrue(true);
	}

	@Test
	public void testCredit() {
		Account2 acc = new Account2(100);
		acc.credit(10);
		assertEquals(110, acc.getAmount(), 0.0);
	}

	@Test
	public void testDebit() {
		Account2 acc = new Account2(100);
		acc.debit(10);
		assertEquals(90, acc.getAmount(), 0.0);
	}

	@Test
	public void testTransfer1() {
		Account2 source = new Account2(100);
		Account2 destination = new Account2(100);

		source.transfer(destination, 50);

		assertEquals(150, destination.getAmount(), 0.0);
		assertEquals(50, source.getAmount(), 0.0);
	}

	@Test
	public void testTransfer2() {
		Account2 source = new Account2(100);
		Account2 destination = new Account2(100);

		source.startPeriodicInterest();
		destination.startPeriodicInterest();

		source.transfer(destination, 50);

		assertEquals(150, destination.getAmount(), 0.0);
		assertEquals(50, source.getAmount(), 1);
	}

	@Test
	public void testTransfer3() {
		Account2 source = new Account2(100);
		Account2 destination = new Account2(100);

		source.startPeriodicInterest();
		destination.startPeriodicInterest();

		StopForTesting.stop(source, 3);
		source.transfer(destination, 50);
		destination.debit(50);
		StopForTesting.stop(source, 3);

		assertEquals(150, destination.getAmount(), 2);
		assertEquals(50, source.getAmount(), 1);
	}

}
