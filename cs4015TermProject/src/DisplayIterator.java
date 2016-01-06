public class DisplayIterator implements Iterator {
	private int countX;
	private int countY;
	private int[][] array;
	public int ROW_LENGTH = 3;
	public int COL_LENGTH = 3;

	public boolean isDone = false;

	public DisplayIterator(int[][] arr) {
		array = arr;
	}

	public boolean isDone() {
		return isDone;

	}

	public void first() {
		countX = 0;
		countY = 0;
	}

	public void next() {
		if (countY >= COL_LENGTH - 1) {
			if (countX >= ROW_LENGTH - 1) {
				isDone = true;
			}
			System.out.println();
			countY = 0;
			countX++;
		} else {
			countY++;
		}
	}

	public int currentItem() {
		return array[countX][countY];
	}
}