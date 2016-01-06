public class RandomStrategy extends ComputerStrategy {
	
	public int[] computeComputerMove(int playerNumber, GameBoard board) {
		GameBoard newBoard = board;
		int[] pos = new int[2];
		while(true)
		{
			int x = (int)(Math.random()*3);
			int y = (int)(Math.random()*3);
			if(newBoard.checkPiece(x,y)==0)
			{
				pos[0] = x;
				pos[1] = y;
				System.out.println("Coords: " + x + " " + y);
				break;
			}
		}
		return pos;
	}
}