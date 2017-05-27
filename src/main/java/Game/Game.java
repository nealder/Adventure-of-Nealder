package Game;

public class Game implements Runnable {
	Draw drawing = new Draw();

	public void run() {
		while (true) {
			
			drawing.render();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}
}
