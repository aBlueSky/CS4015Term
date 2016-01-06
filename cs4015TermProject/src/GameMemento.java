public class GameMemento {
	private int[][] gameBoard;

	public int[][] getState() {
		return gameBoard;
	}
	
	public GameMemento(int[][] board)
	{
		gameBoard = board;
	}
}