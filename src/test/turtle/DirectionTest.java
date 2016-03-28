package com.qatarlyst.turtle;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * 
 * @author Tyrone King
 *
 */
public class DirectionTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRotateRight() {
		Direction comp = Direction.NORTH;
		assertEquals(Direction.EAST, comp.rotateRight());

		
		comp = Direction.SOUTH;
		comp=comp.rotateRight();
		assertEquals(Direction.WEST, comp);
		comp=comp.rotateRight();
		assertEquals(Direction.NORTH, comp);
	}

	@Test
	public void testRotateLeft() {
		
		Direction comp = Direction.NORTH;
		assertEquals(Direction.WEST, comp.rotateLeft());
	}

}
