//Is also AbstractFactory because makeComputerMove is doWork() from template.
public class ComputerPlayer {

	private int PLAYER_NUMBER = 2;
	private GameBoard gameBoard;
	private StrategyFactory stratFact;
	private WinStrategy computerStrategy;

	public ComputerPlayer(GameBoard gameBoard, StrategyFactory stratFact) {
		this.gameBoard = gameBoard;
		this.stratFact = stratFact;
		System.out.println("Created Comp Player");
	}
	//doWork();
	public void makeComputerMove() {
		System.out.println("making a comp move");
		if(computerStrategy == null)
		{
			System.out.println("Created strategy object");
			computerStrategy = stratFact.createWinStrategy();
		}
		int[] pos = computerStrategy.computeComputerMove(PLAYER_NUMBER, gameBoard);
		gameBoard.setPiece(PLAYER_NUMBER, pos[0], pos[1]);
	}
}