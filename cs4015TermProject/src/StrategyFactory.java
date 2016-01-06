public class StrategyFactory {
	public WinStrategy createWinStrategy() {
		WinStrategy win = new WinStrategy();
		return win;
	}
}
