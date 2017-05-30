package View;

import DAO.Load;

/**
 * Main class of the porjekt.
 * 
 * @author Bencs Dániel
 *
 */
public class MainApp {

	/**
	 *The game we will play in.
	 */
	public static Game beta;
	/**
	 * Obvious main method.
	 * 
	 * @param args
	 *            - the args given at running
	 */
	public static void main(String[] args) {
		beta = new Game();
		new Thread(beta).start();
		Load.init();
	}

}
