package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ButtonHandler extends KeyAdapter {

	public ButtonHandler() {
		//System.out.println(" Button handler initialised! ");
	}

	public void keyPressed(KeyEvent key) {
		Game.Instances.currentMap.handlePassageWay();

		switch (key.getKeyCode()) {
		case KeyEvent.VK_UP:
			Game.Instances.player.setUp(false);
			Game.Instances.player.setDown(false);
			Game.Instances.player.setLeft(false);
			Game.Instances.player.setRight(false);
			if (Game.Instances.player.getInventoryStatus()) {
				break;
			}
			Game.Instances.currentMap.collisionTestUp();
			break;
		case KeyEvent.VK_DOWN:
			Game.Instances.player.setUp(false);
			Game.Instances.player.setDown(false);
			Game.Instances.player.setLeft(false);
			Game.Instances.player.setRight(false);
			if (Game.Instances.player.getInventoryStatus()) {
				break;
			}
			Game.Instances.currentMap.collisionTestDown();
			break;
		case KeyEvent.VK_LEFT:
			Game.Instances.player.setUp(false);
			Game.Instances.player.setDown(false);
			Game.Instances.player.setLeft(false);
			Game.Instances.player.setRight(false);
			if (Game.Instances.player.getInventoryStatus()) {
				break;
			}
			Game.Instances.currentMap.collisionTestLeft();
			break;
		case KeyEvent.VK_RIGHT:
			Game.Instances.player.setUp(false);
			Game.Instances.player.setDown(false);
			Game.Instances.player.setLeft(false);
			Game.Instances.player.setRight(false);
			if (Game.Instances.player.getInventoryStatus()) {
				break;
			}
			Game.Instances.currentMap.collisionTestRight();
			break;
		case KeyEvent.VK_I:
			Game.Instances.player.setUp(false);
			Game.Instances.player.setDown(false);
			Game.Instances.player.setLeft(false);
			Game.Instances.player.setRight(false);
			if (!Game.Instances.player.getInventoryStatus()) {
				Game.Instances.player.setInventory(true);
				Game.Instances.food_potion_vendor.setInteractionStatus(false);
				//System.out.println(" Pressed I to show the inventory!");
			} else {
				Game.Instances.player.setInventory(false);
				//System.out.println(" Pressed I to hide inventory!");
			}
			break;
		case KeyEvent.VK_Q:
			System.out.println("X = " + Game.Instances.player.getX());
			System.out.println("Y = " + Game.Instances.player.getY());
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("space pressed");
			for (NPC npc : Game.Instances.currentMap.listOfNPCs) {
				System.out.println(npc);
				if (Game.Instances.player.collisionTest.intersects(npc.interactionRectangle)) {
					//System.out.println("initializing interaction with " + npc.name);
					npc.interaction();
				}
			}
			break;
		case KeyEvent.VK_ESCAPE:
			if(Game.Instances.player.getInventoryStatus() || Game.Instances.food_potion_vendor.interactionStatus || Game.menustatus){
				Game.Instances.player.setInventory(false);
				Game.Instances.food_potion_vendor.interactionStatus = false;
				Game.menustatus=false;
			}else Game.menustatus=true;
		}

		if (Game.Instances.player.sprite_i == 8) {
			Game.Instances.player.sprite_k *= -1;

		} else if (Game.Instances.player.sprite_i == 0) {
			Game.Instances.player.sprite_k *= -1;

		}
		if (Game.Instances.player.spriteDelayer == 2) {
			Game.Instances.player.sprite_i += Game.Instances.player.sprite_k;
			Game.Instances.player.spriteDelayer = 0;
		} else
			Game.Instances.player.spriteDelayer += 1;

		Game.Instances.player.update();
	}

	public void keyReleased(KeyEvent key) {
		switch (key.getKeyCode()) {
		case KeyEvent.VK_UP:
			Game.Instances.player.setUp(false);
			System.out.println(" Released UP! ");
			break;
		case KeyEvent.VK_DOWN:
			System.out.println(" Released DOWN! ");
			Game.Instances.player.setDown(false);
			break;
		case KeyEvent.VK_LEFT:
			System.out.println(" Released LEFT! ");
			Game.Instances.player.setLeft(false);
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println(" Released RIGHT! ");
			Game.Instances.player.setRight(false);
			break;
		case KeyEvent.VK_SPACE:
			System.out.println(" Released SPACE");
		}
	}

	public void keyTyped(KeyEvent key) {

	}
}