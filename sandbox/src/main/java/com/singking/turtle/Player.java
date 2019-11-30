package com.singking.turtle;

/**
 * 
 */
public class Player {

	private Grid grid;

	private Direction heading = Direction.NORTH;

	public Player() {
	}

	public Direction getHeading() {
		return heading;
	}

	public Grid getLocation() {
		return grid;
	}

	public void rotateLeft() {
		heading = heading.rotateLeft();
	}

	public void rotateRight() {
		heading = heading.rotateRight();
	}

	/**
	 * steps the turtle one step forward in it's current direction
	 */
	public void stepForward() {
		switch (heading) {
		case NORTH:
			grid.up();
			break;
		case SOUTH:
			grid.down();
			break;
		case EAST:
			grid.right();
			break;
		case WEST:
			grid.left();
			break;
		default:
			assert false;
		}
	}

	public void setGrid(Grid grid) {
		this.grid = grid;
	}

	public Grid getGrid() {
		return grid;
	}
}
