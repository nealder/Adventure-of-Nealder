package Model;

import java.awt.Rectangle;
import java.net.URL;

import Control.Instances;

/**
 * Non Personcontrolled Characters. They are different so they can't be players
 * too.
 * 
 * @author Bencs Dániel
 *
 */
public class NPC {

	/**
	 * The x coordinate of the NPC's topleft corner.
	 */
	public int x;
	/**
	 * The y coordinate of the NPC's topleft corner.
	 */
	public int y;
	/**
	 * The width, within the player can interact with the NPC.
	 */
	public int width;
	/**
	 * The height, within the player can interact with the NPC.
	 */
	public int height;
	/**
	 * The location where the image of the npc can be found.
	 */
	public URL imageNPC;
	/**
	 * The rectangle that defines the area where the player can interact with
	 * the NPC.
	 */
	public Rectangle interactionRectangle;
	/**
	 * The name of the NPC.
	 */
	public String name;
	/**
	 * The indicator of the NPC's interaction.
	 */
	public boolean interactionStatus;
	/**
	 * Currently unused. The dialog or monolog the NPC tells to the player.
	 */
	public String dialog;

	/**
	 * Constructor.
	 * 
	 * @param x
	 *            - the x coordinate of the NPC's topleft corner.
	 * @param y
	 *            - the y coordinate of the NPC's topleft corner.
	 * @param width
	 *            - the width, within the player can interact with the NPC.
	 * @param height
	 *            - the height, within the player can interact with the NPC.
	 * @param imageNPC
	 *            - the location where the image of the npc can be found.
	 * @param name
	 *            - the name of the NPC.
	 */
	public NPC(int x, int y, int width, int height, URL imageNPC, String name) {
		this.x = x;
		this.width = width;
		this.height = height;
		this.y = y;
		this.imageNPC = imageNPC;
		this.name = name;
		this.interactionRectangle = new Rectangle(this.x, this.y, this.width, this.height);
		System.out.println(interactionRectangle);
	}

	/**
	 * Currently alpha version. Handles the diffent interaction the player cna
	 * have with the NPC.
	 */
	public void interaction() {
		interactionStatus = true;
		Instances.player.setInventory(false);
		dialog = "Sorry, not yet the time.";
	}

	/**
	 * Returns the indicator of the interaction.
	 * 
	 * @return - interactionStatus
	 */
	public boolean getInteractionStatus() {
		return interactionStatus;
	}

	/**
	 * Returns the x coordinate of the NPC's topleft corner.
	 * 
	 * @return - x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x coordinate of the NPC's topleft corner.
	 * 
	 * @param x
	 *            - to x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Returns the y coordinate of the NPC's topleft corner.
	 * 
	 * @return - y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y coordinate of the NPC's topleft corner.
	 * 
	 * @param y
	 *            - to y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Returns the width , within the player can have interaction with the NPC.
	 * 
	 * @return - width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Sets the width, within the player can have interaction with the NPC.
	 * 
	 * @param width
	 *            - to width
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Returns the height , within the player can have interaction with the NPC.
	 * 
	 * @return - height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Sets the height, within the player can have interaction with the NPC.
	 * 
	 * @param height
	 *            - to height
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Returns the locations where the image of the NPC is stored.
	 * 
	 * @return - imageNPC
	 */
	public URL getImageNPC() {
		return imageNPC;
	}

	/**
	 * Sets the location where the image of the NPC is stored.
	 * 
	 * @param imageNPC
	 *            - to imageNPC
	 */
	public void setImageNPC(URL imageNPC) {
		this.imageNPC = imageNPC;
	}

	/**
	 * Returns the rectangle that defines the area where the player can interact
	 * with the NPC.
	 * 
	 * @return - interactionRectangle
	 */
	public Rectangle getInteractionRectangle() {
		return interactionRectangle;
	}

	/**
	 * Sets the rectangle that defines the area where the player can interact
	 * with the NPC.
	 * 
	 * @param interactionRectangle
	 *            - Rectangle of interaction
	 */
	public void setInteractionRectangle(Rectangle interactionRectangle) {
		this.interactionRectangle = interactionRectangle;
	}

	/**
	 * Returns the name of the NPC.
	 * 
	 * @return - name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the NPC.
	 * 
	 * @param name
	 *            - Name of the NPC
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the interaction indicator.
	 * 
	 * @param interactionStatus
	 *            - Indicator of interaction
	 */
	public void setInteractionStatus(boolean interactionStatus) {
		this.interactionStatus = interactionStatus;
	}

}
