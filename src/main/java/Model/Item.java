package Model;

/**
 * Currently unused. Far from developping into the project.
 * 
 * @author Nealder
 *
 */
public class Item {

	/**
	 * Currently not yet in use.
	 */
	public int GoldValue;
	/**
	 * Currently not yet in use.
	 */
	public String Name;
	/**
	 * Currently not yet in use.
	 */
	public String ImgPath;
	/**
	 * Currently not yet in use.
	 */
	public String Description;

	/**
	 * Currently not yet in use.
	 */
	public int strenght;
	/**
	 * Currently not yet in use.
	 */
	public int stamina;
	/**
	 * Currently not yet in use.
	 */
	public int life;
	/**
	 * Currently not yet in use.
	 */
	public int magic;
	/**
	 * Currently not yet in use.
	 */
	public int damage;
	/**
	 * Currently not yet in use.
	 */
	public float critical_chance;
	/**
	 * Currently not yet in use.
	 */
	public float critical_dmg;
	/**
	 * Currently not yet in use.
	 */
	public int armor;

	/**
	 * Currently not yet in use.
	 */
	public int ID;

	/**
	 * Constructor.
	 * 
	 * @param iD - the ID
	 * @param goldValue - the gold value the item can be traded for
	 * @param name - name of the item
	 * @param imgPath - location where the image of the item is lacated at
	 * @param description - description of the item
	 * @param strenght - the amout of strength the item gives
	 * @param stamina - the amout of stamina the item gives
	 * @param life - the amout of life the item gives
	 * @param magic - the amout of magic the item gives
	 * @param damage - the amout of damage the item gives
	 * @param critical_chance - the amout of critical_chance the item gives
	 * @param critical_dmg - the amout of critical_dmg the item gives
	 * @param armor - the amout of armor the item gives
	 */
	public Item(int iD, int goldValue, String name, String imgPath, String description, int strenght, int stamina,
			int life, int magic, int damage, float critical_chance, float critical_dmg, int armor) {
		super();
		ID = iD;
		GoldValue = goldValue;
		Name = name;
		ImgPath = imgPath;
		Description = description;
		this.strenght = strenght;
		this.stamina = stamina;
		this.life = life;
		this.magic = magic;
		this.damage = damage;
		this.critical_chance = critical_chance;
		this.critical_dmg = critical_dmg;
		this.armor = armor;
	}

	/**
	 * Returns the ID of the item.
	 * 
	 * @return - ID
	 */
	public int getID() {
		return ID;
	}

	/**
	 * Sets the ID of the item.
	 * 
	 * @param iD - to iD
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * Returns the gold value of the item.
	 * 
	 * @return - GoldValue
	 */
	public int getValue() {
		return GoldValue;
	}

	/**
	 * Sets the gold value of the item.
	 * 
	 * @param value - to value
	 */
	public void setValue(int value) {
		GoldValue = value;
	}

	/**
	 * Returns the name of item.
	 * 
	 * @return - Name
	 */
	public String getName() {
		return Name;
	}

	/**
	 * Sets the name of the item.
	 * 
	 * @param name - to name
	 */
	public void setName(String name) {
		Name = name;
	}

	/**
	 * Returns the location of the image of the item.
	 * 
	 * @return - ImgPath
	 */
	public String getImgPath() {
		return ImgPath;
	}

	/**
	 * Sets the location of the image of the item.
	 * 
	 * @param imgPath - to imgPath
	 */
	public void setImgPath(String imgPath) {
		ImgPath = imgPath;
	}

}
