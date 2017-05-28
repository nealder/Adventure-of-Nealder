package Game;

import java.awt.Rectangle;
import java.net.URL;
import java.util.List;

/**
 * 
 * The character class we play with and control.
 * 
 * @author Bencs Dániel
 *
 */
public class Player {

	/**
	 * The x coordinate of the player upleft corner.
	 */
	private int x;
	/**
	 * The y coordinate of the player upleft corner.
	 */
	private int y;
	/**
	 * The counter of which sprite of the players image sprites must be shown.
	 */
	public int sprite_i = 0;
	/**
	 * The direction we iterate through the players image sprites.
	 */
	public int sprite_k = -1;
	/**
	 * The direction of which in the player currently moving.
	 */
	private boolean left, right, up, down;
	/**
	 * The switcher between adventure mode and inventory & stats window.
	 */
	private boolean inventory;
	/**
	 * A necesarry template for the sprites to not switch so fast.
	 */
	public int spriteDelayer;
	/**
	 * Currently unused. The name of the player, in case we will need it later.
	 */
	private String Name;
	/**
	 * Currently unused. Contains the items the player carries with itself.
	 */
	public List<Item> inventoryList;
	/**
	 * The rectangle we use for collision test.
	 */
	public Rectangle collisionTest;
	/**
	 * The location of the sprite images of moving right.
	 */
	public URL moveRightSprite = this.getClass().getResource("/Images/MoveRightSprite.png");
	/**
	 * The location of the sprite images of moving up.
	 */
	public URL moveUpSprite = this.getClass().getResource("/Images/MoveUpSprite.png");
	/**
	 * The location of the sprite images of moving down.
	 */
	public URL moveDownSprite = this.getClass().getResource("/Images/MoveDownSprite.png");
	/**
	 * The location of the sprite images of moving left.
	 */
	public URL moveLeftSprite = this.getClass().getResource("/Images/MoveLeftSprite.png");

	/**
	 * Currently (functionally) unused. Shows how much life point the player
	 * has.
	 */
	public int currentLife;

	/**
	 * Constructor
	 */
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

	/**
	 * Contructor
	 * 
	 * @param x
	 *            - the x coordinate of the player topleft corner
	 * @param y
	 *            - the y coordinate of the player topleft corner
	 * @param name
	 *            - name of the player
	 * @param currentLife
	 *            - the amout of life of the player we want to have at start
	 * @param strenght
	 *            - the amout of strength of the player we want to have at start
	 * @param stamina
	 *            - the amout of stamina of the player we want to have at start
	 * @param maxLife
	 *            - the amout of maximum life of the player we want to have at
	 *            start
	 * @param magic
	 *            - the amout of magic of the player we want to have at start
	 * @param critical_chance
	 *            - the amout of chance to critical hit of the player we want to
	 *            have at start
	 * @param critical_dmg
	 *            - the amout of damage multiplier of the player we want to have
	 *            at start
	 * @param armor
	 *            - the amout of armor of the player we want to have at start
	 */
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

	/**
	 * Currently (functionally) unused. A base stat of the player in combat.
	 */
	private int strength;
	/**
	 * Currently (functionally) unused. A base stat of the player in combat.
	 */
	private int stamina;
	/**
	 * Currently (functionally) unused. A base stat of the player in combat.
	 */
	private int maxLife;
	/**
	 * Currently (functionally) unused. A base stat of the player in combat.
	 */
	private int magic;
	/**
	 * Currently (functionally) unused. A base stat of the player in combat.
	 */
	private float critical_chance;
	/**
	 * Currently (functionally) unused. A base stat of the player in combat.
	 */
	private float critical_dmg;
	/**
	 * Currently (functionally) unused. A base stat of the player in combat.
	 */
	private int armor;

	/**
	 * The procedure that updates the player to simulate movement.
	 */
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

	/**
	 * Sets the players left indicator. 
	 * 
	 * @param newLeft - to newLeft
	 */
	public void setLeft(boolean newLeft) {
		left = newLeft;
	}

	/**
	 * Sets the players up indicator. 
	 * 
	 * @param newUP - to newUp
	 */
	public void setUp(boolean newUp) {
		up = newUp;
	}

	/**
	 * Sets the players down indicator. 
	 * 
	 * @param newDown - to newDown
	 */
	public void setDown(boolean newDown) {
		down = newDown;
	}

	/**
	 * Sets the players right indicator. 
	 * 
	 * @param newRight - to newRight
	 */
	public void setRight(boolean newRight) {
		right = newRight;
	}

	/**
	 * Sets the players inventory indicator.
	 * 
	 * @param newInventory - to newInventory
	 */
	public void setInventory(boolean newInventory) {
		inventory = newInventory;
	}

	/**
	 * Returns the inventory indicator.
	 * 
	 * @return - 
	 */
	public boolean getInventoryStatus() {
		return inventory;
	}

	/**
	 * Returns the x coordinate of the player topleft corner.
	 * 
	 * @return - 
	 */
	public float getX() {
		return x;
	}

	/**
	 * Returns the y coordinate of the player topleft corner.
	 * 
	 * @return - 
	 */
	public float getY() {
		return y;
	}

	/**
	 * Returns the name of the player.
	 * 
	 * @return - 
	 */
	public String getName() {
		return Name;
	}

	/**
	 * Moves the player topleft corner x coordinate.
	 * 
	 * @param x - to x
	 */
	public void setX(int x) {
		this.x = x;
		this.collisionTest.x = (int) (this.x + 10);
	}

	/**
	 * Moves the player topleft corner y coordinate.
	 * 
	 * @param y - to y
	 */
	public void setY(int y) {
		this.y = y;
		this.collisionTest.y = (int) (this.y + 30);
	}

	/**
	 * Sets the name of the player.
	 * 
	 * @param Name - to Name
	 */
	public void setName(String Name) {
		this.Name = Name;
	}

	/**
	 * Returns current life of the player.
	 * 
	 * @return - 
	 */
	public int getCurrentLife() {
		return currentLife;
	}

	/**
	 * Sets the current life points of the player.
	 * 
	 * @param currentLife - to currentLife
	 */
	public void setCurrentLife(int currentLife) {
		this.currentLife = currentLife;
	}

	/**
	 * Returns the strength of the player.
	 * 
	 * @return
	 */
	public int getStrength() {
		return strength;
	}

	/**
	 * Sets the strength of the player.
	 * 
	 * @param strenght - to strength
	 */
	public void setStrength(int strenght) {
		this.strength = strenght;
	}

	/**
	 * Returns the stamina of the player.
	 * 
	 * @return
	 */
	public int getStamina() {
		return stamina;
	}

	/**
	 * Sets the stamina of the player.
	 * 
	 * @param stamina - to stamina
	 */
	public void setStamina(int stamina) {
		this.stamina = stamina;
	}

	/**
	 * Returns the life of the player.
	 * 
	 * @return
	 */
	public int getLife() {
		return maxLife;
	}

	/**
	 * Sets the life of the player.
	 * 
	 * @param life - to life
	 */
	public void setLife(int life) {
		this.maxLife = life;
	}

	/**
	 * Returns the magic of the player.
	 * 
	 * @return
	 */
	public int getMagic() {
		return magic;
	}

	/**
	 * Sets the magic of the player.
	 * 
	 * @param magic - to magic
	 */
	public void setMagic(int magic) {
		this.magic = magic;
	}

	/**
	 * Returns the critical chance of the player.
	 * 
	 * @return
	 */
	public float getCritical_chance() {
		return critical_chance;
	}

	/**
	 * Sets the critical chance of the player.
	 * 
	 * @param critical chance - to critical chance
	 */
	public void setCritical_chance(float critical_chance) {
		this.critical_chance = critical_chance;
	}

	/**
	 * Returns the critical damage of the player.
	 * 
	 * @return
	 */
	public float getCritical_dmg() {
		return critical_dmg;
	}

	/**
	 * Sets the critical damage of the player.
	 * 
	 * @param critical_dmg - to critical_dmg
	 */
	public void setCritical_dmg(float critical_dmg) {
		this.critical_dmg = critical_dmg;
	}

	/**
	 * Returns the armor of the player.
	 * 
	 * @return
	 */
	public int getArmor() {
		return armor;
	}

	/**
	 * Sets the armor of the player.
	 * 
	 * @param armor - to armor
	 */
	public void setArmor(int armor) {
		this.armor = armor;
	}

	/**
	 * Returns the current number of sprite we draw.
	 * 
	 * @return
	 */
	public int getSprite_i() {
		return sprite_i;
	}

	/**
	 * Sets the current number of sprite we draw.
	 * 
	 * @param sprite_i
	 */
	public void setSprite_i(int sprite_i) {
		this.sprite_i = sprite_i;
	}

	/**
	 * Returns the direction of where we iterate the image of sprites. 1 to: left-right, -1 to: right-left.
	 * 
	 * @return
	 */
	public int getSprite_k() {
		return sprite_k;
	}

	/**
	 * Sets the direction of where we iterate the image of sprites. 1 to: left-right, -1 to: right-left.
	 * 
	 * @param sprite_k
	 */
	public void setSprite_k(int sprite_k) {
		this.sprite_k = sprite_k;
	}

	/**
	 * Returns the number of this template we use to slow down the change of sprites.
	 * 
	 * @return
	 */
	public int getSpriteDelayer() {
		return spriteDelayer;
	}

	/**
	 * Sets the number of this template we use to slow down the change of spirtes.
	 * 
	 * @param spriteDelayer
	 */
	public void setSpriteDelayer(int spriteDelayer) {
		this.spriteDelayer = spriteDelayer;
	}

	/**
	 * Currently unused. Returns the list of items the player carries with itself;
	 * 
	 * @return
	 */
	public List<Item> getInventoryList() {
		return inventoryList;
	}

	/**
	 * Currently unused. Sets a the list of items the player carries with itself, with another inventoryList.
	 * 
	 * @param inventoryList
	 */
	public void setInventoryList(List<Item> inventoryList) {
		this.inventoryList = inventoryList;
	}

	/**
	 * Returns the rectangle we use to detect collision with objects.
	 * 
	 * @return
	 */
	public Rectangle getCollisionTest() {
		return collisionTest;
	}

	/**
	 * Sets the rectanglewe use to detect collision with objects.
	 * 
	 * @param collisionTest - collisionTest
	 */
	public void setCollisionTest(Rectangle collisionTest) {
		this.collisionTest = collisionTest;
	}

	/**
	 * Returns the location of where the right movement sprites can be found.
	 * 
	 * @return
	 */
	public URL getMoveRightSprite() {
		return moveRightSprite;
	}

	/**
	 * Sets the variable to the location the where right movement sprites can be found.
	 * 
	 * @param moveLeftSprite
	 */
	public void setMoveRightSprite(URL moveRightSprite) {
		this.moveRightSprite = moveRightSprite;
	}

	/**
	 * Returns the location of where the up movement sprites can be found.
	 * 
	 * @return
	 */
	public URL getMoveUpSprite() {
		return moveUpSprite;
	}

	/**
	 * Sets the variable to the location where the up movement sprites can be found.
	 * 
	 * @param moveLeftSprite
	 */
	public void setMoveUpSprite(URL moveUpSprite) {
		this.moveUpSprite = moveUpSprite;
	}

	/**
	 * Returns the location of where the down movement sprites can be found.
	 * 
	 * @return
	 */
	public URL getMoveDownSprite() {
		return moveDownSprite;
	}

	/**
	 * Sets the variable to the location where the down movement sprites can be found.
	 * 
	 * @param moveLeftSprite
	 */
	public void setMoveDownSprite(URL moveDownSprite) {
		this.moveDownSprite = moveDownSprite;
	}

	/**
	 * Returns the location of where the left movement sprites can be found.
	 * 
	 * @return
	 */
	public URL getMoveLeftSprite() {
		return moveLeftSprite;
	}

	/**
	 * Sets the variable to the location where the left movement sprites can be found.
	 * 
	 * @param moveLeftSprite
	 */
	public void setMoveLeftSprite(URL moveLeftSprite) {
		this.moveLeftSprite = moveLeftSprite;
	}

	/**
	 * Returns the macimum life the player.
	 * 
	 * @return
	 */
	public int getMaxLife() {
		return maxLife;
	}

	/**
	 * Sets the maximum life of the player.
	 * 
	 * @param maxLife - to maxLife
	 */
	public void setMaxLife(int maxLife) {
		this.maxLife = maxLife;
	}

	/**
	 * Returns the left indicator of movement.
	 * 
	 * @return
	 */
	public boolean isLeft() {
		return left;
	}

	/**
	 * Returns the right indicator of movement.
	 * 
	 * @return
	 */
	public boolean isRight() {
		return right;
	}

	/**
	 * Returns the up indicator of movement.
	 * 
	 * @return
	 */
	public boolean isUp() {
		return up;
	}

	/**
	 * Returns the down indicator of movement.
	 * 
	 * @return
	 */
	public boolean isDown() {
		return down;
	}

	/**
	 * Returns the indicator of the inventory&stat window.
	 * 
	 * @return
	 */
	public boolean isInventory() {
		return inventory;
	}

	/**
	 * Returns the left indicator of movement.
	 * 
	 * @return
	 */
	public boolean getLeft() {
		return this.left;
	}

	/**
	 * Returns the up indicator of movement.
	 * 
	 * @return
	 */
	public boolean getUp() {
		return this.up;
	}

	/**
	 * Returns the down indicator of movement.
	 * 
	 * @return
	 */
	public boolean getDown() {
		return this.down;
	}

	/**
	 * Returns the right indicator of movement.
	 * 
	 * @return
	 */
	public boolean getRight() {
		return this.right;
	}
}