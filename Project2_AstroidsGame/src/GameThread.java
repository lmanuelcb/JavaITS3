public class GameThread extends Thread {
	Game game;

	public GameThread(Game game1) {
		this.game = game1;
	}

	public void run() {
		try {
			while (true) {
				game.tickActors();
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
