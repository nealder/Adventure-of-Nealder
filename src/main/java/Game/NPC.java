package Game;

import java.awt.Rectangle;

public class NPC {

	public int x;
	public int y;
	public int width;
	public int height;
	public String imageNPC;
	public Rectangle interactionRectangle;
	public String name;
	public boolean interactionStatus;

	public NPC(int x, int y, int width, int height, String imageNPC, String name) {
		this.x = x;
		this.width = width;
		this.height = height;
		this.y = y;
		this.imageNPC = imageNPC;
		this.name = name;
		this.interactionRectangle = new Rectangle(this.x, this.y, this.width, this.height);
		System.out.println(interactionRectangle);
	}

	public void interaction() {
		interactionStatus = true;
		Instances.player.setInventory(false);
	}

	public boolean getInteractionStatus() {
		return interactionStatus;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getImageNPC() {
		return imageNPC;
	}

	public void setImageNPC(String imageNPC) {
		this.imageNPC = imageNPC;
	}

	public Rectangle getInteractionRectangle() {
		return interactionRectangle;
	}

	public void setInteractionRectangle(Rectangle interactionRectangle) {
		this.interactionRectangle = interactionRectangle;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setInteractionStatus(boolean interactionStatus) {
		this.interactionStatus = interactionStatus;
	}

}
