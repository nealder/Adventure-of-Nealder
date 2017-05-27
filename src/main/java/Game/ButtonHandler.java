package Game;

import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ButtonHandler extends KeyAdapter {

	public ButtonHandler() {
		System.out.println(" Button handler initialised! ");
	}

	public void keyPressed(KeyEvent key) {
		Instances.currentMap.handlePassageWay();

		switch (key.getKeyCode()) {
		case KeyEvent.VK_UP:
			Instances.player.setUp(false);
			Instances.player.setDown(false);
			Instances.player.setLeft(false);
			Instances.player.setRight(false);
			Instances.currentMap.collisionTestUp();
			break;
		case KeyEvent.VK_DOWN:
			Instances.player.setUp(false);
			Instances.player.setDown(false);
			Instances.player.setLeft(false);
			Instances.player.setRight(false);
			Instances.currentMap.collisionTestDown();
			break;
		case KeyEvent.VK_LEFT:
			Instances.player.setUp(false);
			Instances.player.setDown(false);
			Instances.player.setLeft(false);
			Instances.player.setRight(false);
			Instances.currentMap.collisionTestLeft();
			break;
		case KeyEvent.VK_RIGHT:
			Instances.player.setUp(false);
			Instances.player.setDown(false);
			Instances.player.setLeft(false);
			Instances.player.setRight(false);
			Instances.currentMap.collisionTestRight();
			break;
		case KeyEvent.VK_I:
			Instances.player.setUp(false);
			Instances.player.setDown(false);
			Instances.player.setLeft(false);
			Instances.player.setRight(false);
			if (!Instances.player.getInventoryStatus()) {
				Instances.player.setInventory(true);
				System.out.println(" Pressed I to show the inventory!");
			} else {
				Instances.player.setInventory(false);
				System.out.println(" Pressed I to hide inventory!");
			}
			break;
		case KeyEvent.VK_Q:
			System.out.println("X = " + Instances.player.getX());
			System.out.println("Y = " + Instances.player.getY());
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("megnyomtad a spacet, majd kesobb funckioja is lesz");
			break;
		}
		if (Instances.player.sprite_i == 8) {
			Instances.player.sprite_k *= -1;
		} else if (Instances.player.sprite_i == 0) {
			Instances.player.sprite_k *= -1;
		}
		Instances.player.sprite_i += Instances.player.sprite_k;

		// Instances.Map1.collision();

		Instances.player.update();
	}

	public void keyReleased(KeyEvent key) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_UP:
			Instances.player.setUp(false);
			System.out.println(" Released UP! ");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println(" Released DOWN! ");
			Instances.player.setDown(false);
			break;
		case KeyEvent.VK_LEFT:
			System.out.println(" Released LEFT! ");
			Instances.player.setLeft(false);
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println(" Released RIGHT! ");
			Instances.player.setRight(false);
			break;
		}
	}

	public void keyTyped(KeyEvent key) {

	}
}