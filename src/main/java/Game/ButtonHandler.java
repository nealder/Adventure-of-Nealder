package Game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * The class that handles inputs from keyboard.
 * 
 * @author Nealder
 *
 */
public class ButtonHandler extends KeyAdapter {

	/**
	 * Constructor.
	 */
	public ButtonHandler() {
	}

	/**
	 * Procedure which is called by the parent canvas each time a keyboard input happens.
	 * 
	 * @param key - key which was recently pressed
	 */
	public void keyPressed(KeyEvent key) {
		Game.Instances.currentMap.handlePassageWay();

		switch (key.getKeyCode()) {
		case KeyEvent.VK_UP:
			Instances.player.setUp(false);
			Instances.player.setDown(false);
			Instances.player.setLeft(false);
			Instances.player.setRight(false);
			if (Instances.player.getInventoryStatus()) {
				break;
			}
			Game.Instances.currentMap.collisionTestUp();
			break;
		case KeyEvent.VK_DOWN:
			Instances.player.setUp(false);
			Instances.player.setDown(false);
			Instances.player.setLeft(false);
			Instances.player.setRight(false);
			if (Instances.player.getInventoryStatus()) {
				break;
			}
			Game.Instances.currentMap.collisionTestDown();
			break;
		case KeyEvent.VK_LEFT:
			Instances.player.setUp(false);
			Instances.player.setDown(false);
			Instances.player.setLeft(false);
			Instances.player.setRight(false);
			if (Instances.player.getInventoryStatus()) {
				break;
			}
			Game.Instances.currentMap.collisionTestLeft();
			break;
		case KeyEvent.VK_RIGHT:
			Instances.player.setUp(false);
			Instances.player.setDown(false);
			Instances.player.setLeft(false);
			Instances.player.setRight(false);
			if (Instances.player.getInventoryStatus()) {
				break;
			}
			Game.Instances.currentMap.collisionTestRight();
			break;
		case KeyEvent.VK_I:
			Instances.player.setUp(false);
			Instances.player.setDown(false);
			Instances.player.setLeft(false);
			Instances.player.setRight(false);
			if (!Instances.player.getInventoryStatus()) {
				Instances.player.setInventory(true);
				Game.Instances.food_potion_vendor.setInteractionStatus(false);
				//System.out.println(" Pressed I to show the inventory!");
			} else {
				Instances.player.setInventory(false);
				//System.out.println(" Pressed I to hide inventory!");
			}
			break;
		case KeyEvent.VK_Q:
			System.out.println("X = " + Instances.player.getX());
			System.out.println("Y = " + Instances.player.getY());
			break;
		case KeyEvent.VK_SPACE:
			System.out.println("space pressed");
			for (NPC npc : Game.Instances.currentMap.listOfNPCs) {
				System.out.println(npc);
				if (Instances.player.collisionTest.intersects(npc.interactionRectangle)) {
					System.out.println("initializing interaction with " + npc.name);
					npc.interaction();
				}
			}
			break;
		case KeyEvent.VK_ESCAPE:
			if(Instances.player.getInventoryStatus() || Game.Instances.food_potion_vendor.interactionStatus || Game.menustatus){
				Instances.player.setInventory(false);
				Game.Instances.food_potion_vendor.interactionStatus = false;
				Game.menustatus=false;
			}else Game.menustatus=true;
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

	/**
	 * Procedure which is called by the parent canvas every time a keyboard input stops happening.
	 * 
	 * @param key - key which was recently pressed
	 */
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

	/**
	 * Currently unused.
	 * 
	 * @param key - key which was recently pressed
	 */
	public void keyTyped(KeyEvent key) {

	}
}