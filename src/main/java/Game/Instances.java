package Game;

import java.util.ArrayList;
import java.util.List;

public class Instances {
	public static Player player = new Player();
	public static NPC food_potion_vendor = new NPC(560, 70, 120, 120,
			"src/main/resources/Images/food&Potion_vendor_onesprite.png", "Helga, the food and potion vendor");

	public static MapHandler currentMap = new MapHandler("src/main/resources/Maps/falucska2.png",
			"src/main/resources/Maps/falucska2_Objects.png", "falucska2unpassableTiles");

	public static MapHandler Map1 = new MapHandler("src/main/resources/Maps/Map1.png",
			"src/main/resources/Maps/Map1ObjectsLayer.png", "Map1unpassableTiles2");
	public static MapHandler Map2 = new MapHandler("src/main/resources/Maps/Map2.png",
			"src/main/resources/Maps/Map2_Objects.png", "Map2unpassableTiles");
	public static MapHandler Falucska1 = new MapHandler("src/main/resources/Maps/falucska1.png",
			"src/main/resources/Maps/falucska1_Objects.png", "falucska1unpassableTiles");
	public static MapHandler Falucska2 = new MapHandler("src/main/resources/Maps/falucska2.png",
			"src/main/resources/Maps/falucska2_Objects.png", "falucska2unpassableTiles");

	public static List<MapHandler> collectionMap = new ArrayList<MapHandler>();

}