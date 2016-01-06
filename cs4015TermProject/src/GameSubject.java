import java.util.ArrayList;

public abstract class GameSubject {

	private ArrayList<GameObserver> observers;

	public GameSubject() {
		observers = new ArrayList<GameObserver>();
	}

	public void attach(GameObserver observer) {
		observers.add(observer);
	}

	protected void notifyObservers() {
		for (GameObserver observer : observers) {
			observer.update();
		}
	}
}