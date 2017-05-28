package Game;

/**
 * Main class of the porjekt.
 * 
 * @author Bencs Dániel
 *
 */
public class MainApp {

	public static void main(String[] args) {
		Game beta = new Game();
		new Thread(beta).start();
		Load.init();
	}

}
