package Game;

import java.awt.Rectangle;
import java.util.List;

public class Player {

	private float x = 380;
	private float y = 90;
	public int sprite_i = 0;
	public int sprite_k = -1;
	public boolean left, right, up, down, inventory;
	public int spriteDelayer;
	private String Name;
	public List<Item> inventoryList;
	public Rectangle collisionTest = new Rectangle((int) x + 10, (int) y + 30, 30, 30);
	public String moveRightSprite = "src/main/resources/Images/MoveRightSprite.png";
	public String moveUpSprite = "src/main/resources/Images/MoveUpSprite.png";
	public String moveDownSprite = "src/main/resources/Images/MoveDownSprite.png";
	public String moveLeftSprite = "src/main/resources/Images/MoveLeftSprite.png";

	public int currentLife = 30;

	public int strenght = 1, stamina = 1, maxLife = 40, magic = 1;
	public float critical_chance = (float) 0.0500, critical_dmg = (float) 2.0000;
	public int armor;

	public void update() {
		if (left) {
			x -= 1;
			collisionTest.x -= 1;
		}
		if (right) {
			x += 1;
			collisionTest.x += 1;
		}
		if (up) {
			y -= 1;
			collisionTest.y -= 1;
		}
		if (down) {
			y += 1;
			collisionTest.y += 1;
		}
	}

	public void setLeft(boolean newLeft) {
		left = newLeft;
	}

	public void setUp(boolean newUp) {
		up = newUp;
	}

	public void setDown(boolean newDown) {
		down = newDown;
	}

	public void setRight(boolean newRight) {
		right = newRight;
	}

	public void setInventory(boolean newInventory) {
		inventory = newInventory;
	}

	public boolean getInventoryStatus() {
		return inventory;
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public String getName() {
		return Name;
	}

	public void setX(int x) {
		this.x = x;
		this.collisionTest.x = (int) (this.x + 10);
	}

	public void setY(int y) {
		this.y = y;
		this.collisionTest.y = (int) (this.y + 30);
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getCurrentLife() {
		return currentLife;
	}

	public void setCurrentLife(int currentLife) {
		this.currentLife = currentLife;
	}

	public int getStrenght() {
		return strenght;
	}

	public void setStrenght(int strenght) {
		this.strenght = strenght;
	}

	public int getStamina() {
		return stamina;
	}

	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	public int getLife() {
		return maxLife;
	}

	public void setLife(int life) {
		this.maxLife = life;
	}

	public int getMagic() {
		return magic;
	}

	public void setMagic(int magic) {
		this.magic = magic;
	}

	public float getCritical_chance() {
		return critical_chance;
	}

	public void setCritical_chance(float critical_chance) {
		this.critical_chance = critical_chance;
	}

	public float getCritical_dmg() {
		return critical_dmg;
	}

	public void setCritical_dmg(float critical_dmg) {
		this.critical_dmg = critical_dmg;
	}

	public int getArmor() {
		return armor;
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}
}