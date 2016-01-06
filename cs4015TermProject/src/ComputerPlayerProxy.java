
public class ComputerPlayerProxy implements iVirtualComputerPlayer {
	private ComputerPlayer computerPlayer;
	private GameBoard gameBoard;
	private StrategyFactory stratFact;
	public ComputerPlayerProxy(GameBoard board, StrategyFactory factory)
	{
		this.gameBoard = board;
		this.stratFact = factory;
		computerPlayer = null;
	}
	
	@Override
	public ComputerPlayer getComputerPlayer() {
		if(computerPlayer==null)
		{
			setComputerPlayer(new ComputerPlayer(gameBoard, stratFact));
		}
		return computerPlayer;
	}

	private void setComputerPlayer(ComputerPlayer computerPlayer) {
		this.computerPlayer = computerPlayer;
	}

	@Override
	public void makeComputerMove() {
		getComputerPlayer().makeComputerMove();
	}

}
