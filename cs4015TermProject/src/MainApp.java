
public class MainApp {
	public static void main(String[] args) {
		GameLogic model = new GameLogic();
        GameView view = new GameView(model);
        GameController controller = GameController.getInstance(model, view);
        controller.doWork();
	}
}