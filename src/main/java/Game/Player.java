package Game;

import java.awt.Rectangle;
import java.net.URL;
import java.util.List;

public class Player {

	private int x;
	private int y;
	public int sprite_i = 0;
	public int sprite_k = -1;
	public boolean left, right, up, down, inventory;
	public int spriteDelayer;
	private String Name;
	public List<Item> inventoryList;
	public Rectangle collisionTest;
	public URL moveRightSprite = this.getClass().getResource("/Images/MoveRightSprite.png");
	public URL moveUpSprite = this.getClass().getResource("/Images/MoveUpSprite.png");
	public URL moveDownSprite = this.getClass().getResource("/Images/MoveDownSprite.png");
	public URL moveLeftSprite = this.getClass().getResource("/Images/MoveLeftSprite.png");

	public int currentLife;

	public Player() {
		super();
		strength = 1;
		stamina = 1;
		maxLife = 40;
		magic = 1;
		critical_chance = (float) 0.0500;
		critical_dmg = (float) 2.0000;
		currentLife = 30;
		y = 90;
		x = 380;
		collisionTest = new Rectangle((int) x + 10, (int) y + 30, 30, 30);
	}

	public Player(int x, int y, String name, int currentLife, int strenght, int stamina, int maxLife, int magic,
			float critical_chance, float critical_dmg, int armor) {
		super();
		this.x = x;
		this.y = y;
		Name = name;
		this.currentLife = currentLife;
		this.strength = strenght;
		this.stamina = stamina;
		this.maxLife = maxLife;
		this.magic = magic;
		this.critical_chance = critical_chance;
		this.critical_dmg = critical_dmg;
		this.armor = armor;
	}

	public int strength, stamina, maxLife, magic;
	public float critical_chance, critical_dmg;
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

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strenght) {
		this.strength = strenght;
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

	public int getSprite_i() {
		return sprite_i;
	}

	public void setSprite_i(int sprite_i) {
		this.sprite_i = sprite_i;
	}

	public int getSprite_k() {
		return sprite_k;
	}

	public void setSprite_k(int sprite_k) {
		this.sprite_k = sprite_k;
	}

	public int getSpriteDelayer() {
		return spriteDelayer;
	}

	public void setSpriteDelayer(int spriteDelayer) {
		this.spriteDelayer = spriteDelayer;
	}

	public List<Item> getInventoryList() {
		return inventoryList;
	}

	public void setInventoryList(List<Item> inventoryList) {
		this.inventoryList = inventoryList;
	}

	public Rectangle getCollisionTest() {
		return collisionTest;
	}

	public void setCollisionTest(Rectangle collisionTest) {
		this.collisionTest = collisionTest;
	}

	public URL getMoveRightSprite() {
		return moveRightSprite;
	}

	public void setMoveRightSprite(URL moveRightSprite) {
		this.moveRightSprite = moveRightSprite;
	}

	public URL getMoveUpSprite() {
		return moveUpSprite;
	}

	public void setMoveUpSprite(URL moveUpSprite) {
		this.moveUpSprite = moveUpSprite;
	}

	public URL getMoveDownSprite() {
		return moveDownSprite;
	}

	public void setMoveDownSprite(URL moveDownSprite) {
		this.moveDownSprite = moveDownSprite;
	}

	public URL getMoveLeftSprite() {
		return moveLeftSprite;
	}

	public void setMoveLeftSprite(URL moveLeftSprite) {
		this.moveLeftSprite = moveLeftSprite;
	}

	public int getMaxLife() {
		return maxLife;
	}

	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public boolean isUp() {
		return up;
	}

	public boolean isDown() {
		return down;
	}

	public boolean isInventory() {
		return inventory;
	}
}