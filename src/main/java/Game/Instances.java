package Game;

import java.util.ArrayList;
import java.util.List;

/**
 * The class we store core data like map, npc, player.
 * 
 * @author Bencs Dániel
 *
 */
public class Instances {
	public Player player = new Player();
	public DAO dao = new DAO();
	public NPC food_potion_vendor = new NPC(560, 70, 120, 120,
			this.getClass().getResource("/Images/food&Potion_vendor_onesprite.png"), "Helga, the food and potion vendor");

	public MapHandler currentMap = new MapHandler(this.getClass().getResource("/Maps/falucska2_Ground.png"),
			this.getClass().getResource("/Maps/falucska2_objects.png"), "/falucska2unpassableTiles");

	public MapHandler Map1 = new MapHandler(this.getClass().getResource("/Maps/Map1_Ground.png"),
			this.getClass().getResource("/Maps/Map1_Objects.png"), "/Map1unpassableTiles2");
	public MapHandler Map2 = new MapHandler(this.getClass().getResource("/Maps/Map2_Ground.png"),
			this.getClass().getResource("/Maps/Map2_Objects.png"), "/Map2unpassableTiles");
	public MapHandler Falucska1 = new MapHandler(this.getClass().getResource("/Maps/falucska1_Ground.png"),
			this.getClass().getResource("/Maps/falucska1_Objects.png"), "/falucska1unpassableTiles");
	public MapHandler Falucska2 = new MapHandler(this.getClass().getResource("/Maps/falucska2_Ground.png"),
			this.getClass().getResource("/Maps/falucska2_obejcts.png"), "/falucska2unpassableTiles");

	public List<MapHandler> collectionMap = new ArrayList<MapHandler>();

}