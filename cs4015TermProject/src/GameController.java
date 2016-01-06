import java.util.Scanner;
import java.util.Stack;

public class GameController implements GameObserver {
	private static GameController singleInstance = null;
	private GameView gameView;
	private GameLogic gameLogic;
	private Stack<GameCommand> gameCommandStack = new Stack<GameCommand>();
	private GameCommand gameCommandPrototype;
	private boolean gameEnd;

	public void doWork() {
		Scanner sc = new Scanner(System.in);
		gameView.displayMessage("Game Starts.");
		gameView.update();
		while (!gameEnd) {
			GameCommand command;
			gameView.displayMessage("Player's turn.");
			gameView.displayMessage("Do you want to Play or Undo?");
			String userIn = sc.nextLine();
			if (userIn.equalsIgnoreCase("undo")) {
				command = gameCommandStack.pop();
				command.unexecute();
				gameLogic.notifyObservers();
			}
			command = gameCommandPrototype.cloneMe();
			gameCommandStack.push(command);
			command.execute();
			gameEnd = (gameLogic.getGameStatus() == 0) ? false : true;
			if (gameLogic.getGameStatus() != 0) {
				break;
			}
			gameView.displayMessage("Computer's turn.");
			gameLogic.handleComputerMove();
			gameEnd = (gameLogic.getGameStatus() == 0) ? false : true;
		}
		sc.close();
	}

	public void update() {
		int status = gameLogic.getGameStatus();
		switch (status) {
		case GameStatus.GAME_CONTINUE:
			break;
		case GameStatus.ILLEGAL_MOVE:
			gameView.displayMessage("Illegal Move");
			break;
		default:
			gameEnd = true;
			// TODO
			gameView.displayMessage("Game won by player: " + status);
		}

	}

	private GameController(GameLogic logic, GameView view) {
		gameCommandStack = new Stack<GameCommand>();
		this.gameView = view;
		this.gameLogic = logic;
		this.gameEnd = false;
		gameCommandPrototype = new GameCommand(gameLogic);
	}
	public static GameController getInstance(GameLogic logic, GameView view)
	{
		if(singleInstance == null)
		{
			singleInstance = new GameController(logic, view);
		}
		return singleInstance;
	}
}