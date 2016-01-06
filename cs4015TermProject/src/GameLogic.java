public class GameLogic extends GameSubject {

	private GameReferee gameReferee;
	
	private ComputerPlayerProxy computerPlayerProxy;

	private GameBoard gameBoard;

	public int getGameStatus() {
		return gameReferee.checkGameStatus();
	}
	public boolean checkLegalMove(int x, int y) 
	{
		return gameReferee.checkLegalMove(x, y);
	}
	public GameBoard getGameBoard() {
		return gameBoard.getGameBoard();
	}

	public GameMemento getGameBoardMemento() {
		return gameBoard.createGameMemento();
	}

	public void setGameBoardState(GameMemento gameMemento) {
		gameBoard.setState(gameMemento);
		notifyObservers();
	}

	public void handleComputerMove() {
		computerPlayerProxy.makeComputerMove();
		notifyObservers();
	}

	public GameLogic() {
		gameBoard = new GameBoard();
		gameReferee = new GameReferee(gameBoard);
		computerPlayerProxy = new ComputerPlayerProxy(gameBoard, new StrategyFactory());
	}
}