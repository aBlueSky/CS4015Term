public class GameBoard {

	public int[][] board;
	public int ROW_LENGTH = 3;
	public int COL_LENGTH = 3;

	public void setPiece(int player, int x, int y) {
		board[x][y] = player;
	}
	public void setState(GameMemento state) {
		board = state.getState();
	}

	public GameMemento createGameMemento() {
		int[][] boardCopy = new int[3][3];
		for(int i =0; i < 3; i++)
		{
			for(int j =0; j < 3; j++)
			{
				boardCopy[i][j] = board[i][j];
			}
		}
		return new GameMemento(boardCopy);
	}

	public GameBoard() {
		board = new int[ROW_LENGTH][COL_LENGTH];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
				board.clone()[i][j] = 0;
			}
	}

	public int checkPiece(int x, int y) {
		return board[x][y];
	}

	public GameBoard getGameBoard() {
		return this;
	}

	public int getRowLength() {
		return ROW_LENGTH;
	}

	public int getColLength() {
		return COL_LENGTH;
	}
}