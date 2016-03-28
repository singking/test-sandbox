package com.qatarlyst.turtle;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GridTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testUp() {
		Grid grid = new Grid(1);
		assertEquals(5, grid.getxCoorinate());
		assertEquals(5, grid.getyCoorinate());
		
		
		grid.up();
		grid.up();
		grid.up();
		assertEquals(2, grid.getyCoorinate());
		
	}

	@Test
	public void testDown() {
		Grid grid = new Grid(1);
		grid.down();
		grid.down();
		grid.down();
		grid.down();
		grid.down();
		
		assertEquals("moved 5 steps but grid is only 9x9",9, grid.getyCoorinate());
		
	}

}
