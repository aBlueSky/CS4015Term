public class SmartStrategy extends ComputerStrategy {

	private RandomStrategy successor;

	@Override
	public int[] computeComputerMove(int playerNumber, GameBoard board) {
		int x = -1;
		int y = -1;
		int[] coords = new int[2];
		// coords[0] = x;
		// coords[1] = y;

		// fill in center if possible
		if (board.checkPiece(1, 1) == 0) {
			coords[0] = 1;
			coords[1] = 1;
			return coords;
		}
		// fill in corners if opposite of filled in 'others' if possible
		if (board.checkPiece(0, 1) == GameStatus.PLAYER_1_WIN) {
			x = 2;
			y = 0;
			if (board.checkPiece(x, y) == 0) {
				coords[0] = x;
				coords[1] = y;
				return coords;
			}
			x = 2;
			y = 2;
			if (board.checkPiece(x, y) == 0) {
				coords[0] = x;
				coords[1] = y;
				return coords;
			}
		}
		if (board.checkPiece(1, 0) == GameStatus.PLAYER_1_WIN) {
			x = 0;
			y = 2;
			if (board.checkPiece(x, y) == 0) {
				coords[0] = x;
				coords[1] = y;
				return coords;
			}
			x = 2;
			y = 2;
			if (board.checkPiece(x, y) == 0) {
				coords[0] = x;
				coords[1] = y;
				return coords;
			}
		}
		if (board.checkPiece(1, 2) == GameStatus.PLAYER_1_WIN) {
			x = 0;
			y = 0;
			if (board.checkPiece(x, y) == 0) {
				coords[0] = x;
				coords[1] = y;
				return coords;
			}
			x = 2;
			y = 0;
			if (board.checkPiece(x, y) == 0) {
				coords[0] = x;
				coords[1] = y;
				return coords;
			}
		}
		if (board.checkPiece(2, 1) == GameStatus.PLAYER_1_WIN) {
			x = 0;
			y = 0;
			if (board.checkPiece(x, y) == 0) {
				coords[0] = x;
				coords [1] = y;
				return coords;
			}
			x = 0;
			y = 2;
			if (board.checkPiece(x, y) == 0) {
				coords[0] = x;
				coords[1] = y;
				return coords;
			}
		}
		// fill in corners if possible in a certain amount of guesses, else move on to random
		for (int i = 0; i < GameStatus.RANDOM_GUESSES; i++) {
			x = (int) (Math.random() * 3);
			y = (int) (Math.random() * 3);
			if ((x + y) % 2 == 0) {
				if (board.checkPiece(x, y) == 0) {
					coords[0] = x;
					coords[1] = y;
					return coords;
				}
			}

		}
		// do random if nothing returns unless successor is specified.
		if (successor == null) {
			successor = new RandomStrategy();
		}
		return successor.computeComputerMove(playerNumber, board);
	}
}