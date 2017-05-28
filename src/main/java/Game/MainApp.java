package Game;

public class MainApp {

	public static void main(String[] args) {
		Game beta = new Game();
		new Thread(beta).start();
		Load.init();
	}

}
