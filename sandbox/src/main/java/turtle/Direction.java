package turtle;

/**
 * This Enum class comprises the main points on a compass and the behaviour
 * required to logically move from point to point.
 */
public enum Direction {

	NORTH {
		Direction rotateRight() {
			return Direction.EAST;
		}

		Direction rotateLeft() {
			return Direction.WEST;
		}
	},

	SOUTH {
		Direction rotateRight() {
			return Direction.WEST;
		}

		Direction rotateLeft() {
			return Direction.EAST;
		}
	},

	EAST {
		Direction rotateRight() {
			return Direction.SOUTH;
		}

		Direction rotateLeft() {
			return Direction.NORTH;
		}
	},

	WEST {
		Direction rotateRight() {
			return Direction.NORTH;
		}

		Direction rotateLeft() {
			return Direction.SOUTH;
		}
	};

	abstract Direction rotateRight();

	abstract Direction rotateLeft();

}
