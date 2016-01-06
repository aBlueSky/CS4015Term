public class GameView implements GameObserver {
	private GameLogic model;

	public GameView(GameLogic model) {
		this.model = model;
		model.attach(this);
	}

	private void displayGameBoard(GameBoard gameBoard) {
		DisplayIterator iter = new DisplayIterator(gameBoard.board);
		FlyWeightFactory factory = new FlyWeightFactory();
		PrintableChar pc;
		iter.first();
		while (!iter.isDone()) {
			int playerId = iter.currentItem();
			switch (playerId) {
			case 0:
				pc = factory.getFlyweight('*');
				pc.printSelf();
				break;
			case 1:
				pc = factory.getFlyweight('X');
				pc.printSelf();
				break;
			case 2:
				pc = factory.getFlyweight('O');
				pc.printSelf();
				break;
			}
			System.out.print(" ");
			iter.next();
		}
	}

	public void displayMessage(String message) {
		System.out.println(message);
	}

	public void update() {
		int status = model.getGameStatus();
		if (status != GameStatus.ILLEGAL_MOVE) {
			GameBoard board = model.getGameBoard();
			displayGameBoard(board);
			String message = "";
			switch (status) {
			case GameStatus.GAME_CONTINUE:
				message = "Game Continue";
				break;
			case GameStatus.PLAYER_1_WIN:
				message = "Player 1 Won!";
				break;
			case GameStatus.PLAYER_2_WIN:
				message = "Player 2 Won!";
				break;
			case GameStatus.TIE:
				message = "It is a tie!";
				break;
			}
			displayMessage(message);
		}
	}
}