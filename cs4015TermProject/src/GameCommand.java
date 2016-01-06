import java.util.Scanner;

public class GameCommand {
	private int PLAYER_NUMBER = 1;
	private GameLogic logic;

	private GameMemento gameMemento;

	public GameCommand(GameLogic logic) {
		this.logic = logic;
	}
	
	public void execute() {
		gameMemento = logic.getGameBoardMemento();
		Scanner n = new Scanner(System.in);
		int x = -1;
		int y = -1;
		while (!logic.checkLegalMove(x, y)) {
			System.out.println("Input x coordinate:");
			x = n.nextInt();
			System.out.println("Input y coordinate:");
			y = n.nextInt();
		}
		logic.getGameBoard().setPiece(PLAYER_NUMBER, x, y);
		n.nextLine();
	}
	public void unexecute() {
		logic.setGameBoardState(gameMemento);
	}

	public GameCommand cloneMe() {
		return new GameCommand(this.logic);
	}
}