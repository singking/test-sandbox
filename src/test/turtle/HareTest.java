/**
 *
 * -----------------------------------------------------------------------
 *
 * RI3K  LIMITED
 *
 * -----------------------------------------------------------------------
 *
 * (C) Copyright 2010 RI3K Limited. All rights reserved.
 *
 * NOTICE:  All information contained herein or attendant hereto is,
 *          and remains, the property of RI3K Limited.  Many of the
 *          intellectual and technical concepts contained herein are
 *          proprietary to RI3K Limited. Any dissemination of this
 *          information or reproduction of this material is strictly
 *          forbidden unless prior written permission is obtained
 *          from RI3K Limited.
 *
 * -----------------------------------------------------------------------
 *
 */
package com.qatarlyst.turtle;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HareTest {
	Hare player;
	
	@Before
	public void setUp() throws Exception {
		player= new Hare();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetHeading() {
		assertEquals("hare should face NORTH initially", Direction.NORTH, player.getHeading());
		player.stepForward();
		player.stepForward();
		
		assertEquals("hare should still face NORTH", Direction.NORTH, player.getHeading());
		assertEquals("grid should be y=5-4", 1, player.getLocation().getyCoorinate());
		
		player.rotateLeft();
		player.stepForward();
		player.stepForward();
		assertEquals("grid coordinate should now be x=1", 1, player.getLocation().getxCoorinate());
		
		
	}

	@Test
	public void testInitialLocation() {

		assertEquals("grid coordinate should now be x=5", 5, player.getLocation().getxCoorinate());
		assertEquals("grid coordinate should now be y=5", 5, player.getLocation().getyCoorinate());
	}
	
	@Test
	public void testGetLocation() {
		player.stepForward();	// 5,3
		player.rotateRight();	// east
		player.stepForward();	// 7,3
		player.stepForward();	// 9,3
		player.rotateLeft();	// north
		
		assertEquals("grid coordinate should now be x=9", 9, player.getLocation().getxCoorinate());
		assertEquals("grid coordinate should now be y=3", 3, player.getLocation().getyCoorinate());
	}

	@Test
	public void testRotateLeft() {
		player.stepForward();
		player.rotateLeft();
		player.stepForward();
		player.stepForward();
		player.stepForward();
		player.rotateLeft();
		player.rotateLeft();
		player.rotateLeft();
		player.rotateLeft();
		assertEquals("player should face WEST at initially", Direction.WEST, player.getHeading());
		
	}

	@Test
	public void testRotateRight() {
		player.rotateRight();
		player.rotateRight();
		assertEquals("player should face SOUTH at initially", Direction.SOUTH, player.getHeading());
	}

	@Test
	public void testStepForward() {
		player.stepForward();
		player.stepForward();
		player.stepForward();
		player.stepForward();
		player.stepForward();
		player.stepForward();
		player.stepForward();
		assertEquals("grid coordinate should still be y=1", 1, player.getLocation().getyCoorinate());
	}

}
