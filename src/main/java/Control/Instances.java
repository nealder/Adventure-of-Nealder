package Control;

import java.util.ArrayList;
import java.util.List;

import DAO.DAO;
import Model.MapHandler;
import Model.NPC;
import Model.Player;

/**
 * The class we store core data like map, npc, player.
 * 
 * @author Bencs Dániel
 *
 */
public class Instances {
	/**
	 * The player we are goint to play with.
	 */
	public static Player player = new Player();
	/**
	 * The DAO we are goint to use to acces objetc datas.
	 */
	public static DAO dao = new DAO();
	/**
	 * The food vendor in falucska2.
	 */
	public NPC food_potion_vendor = new NPC(560, 70, 120, 120,
			this.getClass().getResource("/Images/food&Potion_vendor_onesprite.png"), "Helga, the food and potion vendor");

	/**
	 * Current map to track where are we currently.
	 */
	public MapHandler currentMap = new MapHandler(this.getClass().getResource("/Maps/falucska2_Ground.png"),
			this.getClass().getResource("/Maps/falucska2_objects.png"), "falucska2unpassableTiles");

	/**
	 * Map1 stores the image of map1 and the unpassable tiles of map1.
	 */
	public MapHandler Map1 = new MapHandler(this.getClass().getResource("/Maps/Map1_Ground.png"),
			this.getClass().getResource("/Maps/Map1_Objects.png"), "Map1unpassableTiles2");
	/**
	 * Map2 stores the image of Map2 and the unpassable tiles of Map2.
	 */
	public MapHandler Map2 = new MapHandler(this.getClass().getResource("/Maps/Map2_Ground.png"),
			this.getClass().getResource("/Maps/Map2_Objects.png"), "Map2unpassableTiles");
	/**
	 * Falucsak1 stores the image of Falucsak1 and the unpassable tiles of Falucsak1.
	 */
	public MapHandler Falucska1 = new MapHandler(this.getClass().getResource("/Maps/falucska1_Ground.png"),
			this.getClass().getResource("/Maps/falucska1_Objects.png"), "falucska1unpassableTiles");
	/**
	 * Falucska2 stores the image of Falucska2 and the unpassable tiles of Falucska2.
	 */
	public MapHandler Falucska2 = new MapHandler(this.getClass().getResource("/Maps/falucska2_Ground.png"),
			this.getClass().getResource("/Maps/falucska2_obejcts.png"), "falucska2unpassableTiles");

	/**
	 * Collection of maps which are in the game now.
	 */
	public List<MapHandler> collectionMap = new ArrayList<MapHandler>();

}