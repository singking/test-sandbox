package turtle;

/**
 * For brevity stepping beyond the grid boundary does not throw an Exception
 * (this could be added at a later stage)
 */
public class Grid {

	// x coordinate grid boundary
	private final int X_LIMIT = 9;

	// y coordinate grid boundary
	private final int Y_LIMIT = 9;

	private int xCoorinate = 5;
	private int yCoorinate = 5;

	private int steps = 1;

	public Grid(int steps) {
		this.steps = steps;
	}

	public void up() {
		if (yCoorinate > 1)
			yCoorinate -= steps;
	}

	public void down() {

		if (yCoorinate < Y_LIMIT)
			yCoorinate += steps;
	}

	public void right() {
		if (xCoorinate < X_LIMIT)
			xCoorinate += steps;
	}

	public void left() {
		if (xCoorinate > 1)
			xCoorinate -= steps;
	}

	public int getxCoorinate() {
		return xCoorinate;
	}

	public int getyCoorinate() {
		return yCoorinate;
	}

	@Override
	public String toString() {
		return xCoorinate + "," + yCoorinate;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public int getSteps() {
		return steps;
	}

}
