public class NotLoseStrategy extends ComputerStrategy {

	private SmartStrategy successor;

	@Override
	public int[] computeComputerMove(int playerNumber, GameBoard board) {
		GameBoard newBoard = board;
		int[] pos = new int[2];
		int x, y;

		// Check the X-axis
		int xCount = 0;
		for (x = 0; x < 3; x++) {
			xCount = 0;
			for (y = 0; y < 3; y++) {
				if ((newBoard.checkPiece(x, y)) == 1) {
					xCount++;
				} else if ((newBoard.checkPiece(x, y)) == 2) {
					xCount = 0;
					break;
				} else {
					pos[0] = x;
					pos[1] = y;
				}

				if (xCount == 2 && y == 2) {
					return pos;
				}
			}
		}

		// Check the Y-axis
		int yCount = 0;
		for (y = 0; y < 3; y++) {
			yCount = 0;
			for (x = 0; x < 3; x++) {
				if ((newBoard.checkPiece(x, y)) == 1) {
					yCount++;
				} else if ((newBoard.checkPiece(x, y)) == 2) {
					yCount = 0;
					break;
				} else {
					pos[0] = x;
					pos[1] = y;
				}

				if (yCount == 2 && x == 2) {
					return pos;
				}
			}
		}

		// Check the D-axis
		int[] pos2 = new int[2];
		int d1Count = 0;
		int d2Count = 0;

		// Check 0, 0
		x = 0;
		y = 0;
		if ((newBoard.checkPiece(x, y)) == 1) {
			d1Count++;
		} else if ((newBoard.checkPiece(x, y)) == 2) {
			d1Count = 0;
		} else {
			pos[0] = x;
			pos[1] = y;
		}

		// Check 0, 2
		y = 2;
		if ((newBoard.checkPiece(x, y)) == 1) {
			d2Count++;
		} else if ((newBoard.checkPiece(x, y)) == 2) {
			d2Count = 0;
		} else {
			pos2[0] = x;
			pos2[1] = y;
		}

		// Check 1, 1
		x = 1;
		y = 1;
		if ((newBoard.checkPiece(x, y)) == 1) {
			d1Count++;
			d2Count++;
		} else if ((newBoard.checkPiece(x, y)) == 2) {
			d1Count = 0;
			d2Count = 0;
		} else {
			pos[0] = x;
			pos[1] = y;
			pos2[0] = x;
			pos2[1] = y;
		}

		// Check 0, 2
		x = 2;
		y = 0;
		if ((newBoard.checkPiece(x, y)) == 1) {
			d2Count++;
		} else if ((newBoard.checkPiece(x, y)) == 2) {
			d2Count = 0;
		} else {
			pos2[0] = x;
			pos2[1] = y;
		}

		// Check 2, 2
		x = 2;
		y = 2;
		if ((newBoard.checkPiece(x, y)) == 1) {
			d1Count++;
		} else if ((newBoard.checkPiece(x, y)) == 2) {
			d1Count = 0;
		} else {
			pos[0] = x;
			pos[1] = y;
		}

		// Return a move if found
		if (d1Count == 2) {
			return pos;
		}
		if (d2Count == 2) {
			return pos2;
		}

		if (successor == null) {
			successor = new SmartStrategy();
		}

		return successor.computeComputerMove(playerNumber, board);
	}
}