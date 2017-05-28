package Game;

/**
 * Second "Main" class for better later perspectives.
 * 
 * @author Bencs Dániel
 *
 */
public class Game implements Runnable {
	/**
	 * Implementation of a Draw.
	 */
	Draw drawing = new Draw();
	/**
	 * Implementation of an Instances.
	 */
	public static Instances Instances = new Instances();
	/**
	 * Menu status of splitting adventure mode and menu.
	 */
	static boolean menustatus=true;

	/**
	 * Thread running.
	 */
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
