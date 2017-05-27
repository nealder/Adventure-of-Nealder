package Game;

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
			if (Instances.player.getInventoryStatus()) {
				break;
			}
			Instances.currentMap.collisionTestUp();
			break;
		case KeyEvent.VK_DOWN:
			Instances.player.setUp(false);
			Instances.player.setDown(false);
			Instances.player.setLeft(false);
			Instances.player.setRight(false);
			if (Instances.player.getInventoryStatus()) {
				break;
			}
			Instances.currentMap.collisionTestDown();
			break;
		case KeyEvent.VK_LEFT:
			Instances.player.setUp(false);
			Instances.player.setDown(false);
			Instances.player.setLeft(false);
			Instances.player.setRight(false);
			if (Instances.player.getInventoryStatus()) {
				break;
			}
			Instances.currentMap.collisionTestLeft();
			break;
		case KeyEvent.VK_RIGHT:
			Instances.player.setUp(false);
			Instances.player.setDown(false);
			Instances.player.setLeft(false);
			Instances.player.setRight(false);
			if (Instances.player.getInventoryStatus()) {
				break;
			}
			Instances.currentMap.collisionTestRight();
			break;
		case KeyEvent.VK_I:
			Instances.player.setUp(false);
			Instances.player.setDown(false);
			Instances.player.setLeft(false);
			Instances.player.setRight(false);
			if (!Instances.player.getInventoryStatus()) {
				Instances.player.setInventory(true);
				Instances.food_potion_vendor.setInteractionStatus(false);
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
			System.out.println("space pressed");
			for (NPC npc : Instances.currentMap.listOfNPCs) {
				System.out.println(npc);
				if (Instances.player.collisionTest.intersects(npc.interactionRectangle)) {
					System.out.println("initializing interaction with " + npc.name);
					npc.interaction();
				}
			}
			break;
		case KeyEvent.VK_ESCAPE:
			Instances.player.setInventory(false);
			Instances.food_potion_vendor.interactionStatus = false;
		}

		if (Instances.player.sprite_i == 8) {
			Instances.player.sprite_k *= -1;

		} else if (Instances.player.sprite_i == 0) {
			Instances.player.sprite_k *= -1;

		}
		if (Instances.player.spriteDelayer == 2) {
			Instances.player.sprite_i += Instances.player.sprite_k;
			Instances.player.spriteDelayer = 0;
		} else
			Instances.player.spriteDelayer += 1;

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
		case KeyEvent.VK_SPACE:
			System.out.println(" Released SPACE");
		}
	}

	public void keyTyped(KeyEvent key) {

	}
}