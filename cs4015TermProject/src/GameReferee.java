
public class GameReferee {

	private GameBoard gameBoard;

	public boolean checkLegalMove(int x, int y) {
		// TODO Auto-generated method stub
		if (x < 0 || y < 0 || x > 2 || y > 2) {
			return false;
		}
		boolean result = (gameBoard.checkPiece(x, y) == 0) ? true : false;
		return result;
	}

	public int checkGameStatus() {
		int playerId = checkWinning();
		if (playerId == 1)
			return GameStatus.PLAYER_1_WIN;
		if (playerId == 2)
			return GameStatus.PLAYER_2_WIN;
		boolean status = checkTie();
		if (status == true)
			return GameStatus.TIE;
		return GameStatus.GAME_CONTINUE;
	}

	public int checkWinning() {
		for (int row = 0; row < 3; row++) {
			int playerId = gameBoard.checkPiece(row, 0);
			int count = 1;
			for (int col = 1; col < 3; col++) {
				if (gameBoard.checkPiece(row, col) == playerId)
					count++;
			}
			if (count == 3 && playerId != 0)
				return playerId;
		}
		for (int col = 0; col < 3; col++) {
			int playerId = gameBoard.checkPiece(0, col);
			int count = 1;
			for (int row = 1; row < 3; row++) {
				if (gameBoard.checkPiece(row, col) == playerId)
					count++;
			}
			if (count == 3 && playerId != 0)
				return playerId;
		}
		int playerId = gameBoard.checkPiece(0, 0);
		int count = 1;
		for (int row = 1; row < 3; row++) {
			if (gameBoard.checkPiece(row, row) == playerId)
				count++;
		}
		if (count == 3 && playerId != 0)
			return playerId;
		playerId = gameBoard.checkPiece(0, 2);
		count = 1;
		for (int row = 1; row < 3; row++) {
			if (gameBoard.checkPiece(row, 2 - row) == playerId)
				count++;
		}
		if (count == 3 && playerId != 0)
			return playerId;
		return 0;
	}

	private boolean checkTie() {
		/*
		 * for (int row = 0; row < 3; row++) { int[] counts = new int[3]; for
		 * (int col = 1; col < 3; col++ ) { int playerId =
		 * gameBoard.checkPiece(row, col); counts[playerId]++; } for (int i = 0;
		 * i < 3; i++) { if (counts[0] >= 2) return false; if ((counts[1] == 2
		 * || counts[2] == 2) && counts[0] == 1) return false; } } for (int col
		 * = 0; col < 3; col++) { int[] counts = new int[3]; for (int row = 1;
		 * row < 3; row++ ) { int playerId = gameBoard.checkPiece(row, col);
		 * counts[playerId]++; } for (int i = 0; i < 3; i++) { if (counts[0] >=
		 * 2) return false; if ((counts[1] == 2 || counts[2] == 2) && counts[0]
		 * == 1) return false; } } for (int row = 0; row < 3; row++) { int[]
		 * counts = new int[3]; int playerId = gameBoard.checkPiece(row, row);
		 * counts[playerId]++; for (int i = 0; i < 3; i++) { if (counts[0] >= 2)
		 * return false; if ((counts[1] == 2 || counts[2] == 2) && counts[0] ==
		 * 1) return false; } }
		 * 
		 * for (int row = 0; row < 3; row++) { int[] counts = new int[3]; int
		 * playerId = gameBoard.checkPiece(row, 2-row); counts[playerId]++; for
		 * (int i = 0; i < 3; i++) { if (counts[0] >= 2) return false; if
		 * ((counts[1] == 2 || counts[2] == 2) && counts[0] == 1) return false;
		 * } } return true;
		 */
		for (int r = 0; r < gameBoard.getRowLength(); r++) {
			for (int c = 0; c < gameBoard.getRowLength(); c++) {
				if (gameBoard.board[r][c] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public GameReferee(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}
}