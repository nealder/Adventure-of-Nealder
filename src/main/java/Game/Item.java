package Game;

/**
 * Currently unused. Far from developping into the project.
 * 
 * @author Nealder
 *
 */
public class Item {

	public int GoldValue;
	public String Name;
	public String ImgPath;
	public String Description;

	public int strenght, stamina, life, magic;
	public int damage;
	public float critical_chance, critical_dmg;
	public int armor;

	public int ID;

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

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getValue() {
		return GoldValue;
	}

	public void setValue(int value) {
		GoldValue = value;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getImgPath() {
		return ImgPath;
	}

	public void setImgPath(String imgPath) {
		ImgPath = imgPath;
	}

}
