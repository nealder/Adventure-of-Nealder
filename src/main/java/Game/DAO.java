package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Game.MapHandler.Tile;
/**
 * 
 * Saves and loads data.
 * 
 * @author Bencs Dániel
 *
 */
public class DAO {

	/**
	 * 
	 * Loads the list of unpassable tiles.
	 * 
	 * @param name - name of the file which contains the tiles
	 * @return - a list that contains the unpassable tiles
	 */
	public static List<Tile> loadUnpassableTiles(String name) {
		List<Tile> loaderTileList = new ArrayList<>();

		String line;
		try {
			Scanner s = new Scanner(new File("src/main/resources/Maps/" + "/" + name)); // this.getClass().getResourceAsStream
			while (s.hasNext()) {
				line = (s.next());
				String[] linearray;
				linearray = line.split(",");
				loaderTileList.add(new MapHandler.Tile(Integer.parseInt(linearray[0]), Integer.parseInt(linearray[1])));
			}
			s.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return loaderTileList;

	}

	/**
	 * Saves the current game, including player position on map and player stats.
	 */
	@SuppressWarnings("unchecked")
	public static void saveGamePlay() {
		JSONObject obj = new JSONObject();
		FileWriter fileWriter;

		obj.put("x", Game.Instances.player.getX());
		obj.put("y", Game.Instances.player.getY());
		obj.put("name", Game.Instances.player.getName());
		obj.put("currentLife", Game.Instances.player.getCurrentLife());
		obj.put("strength", Game.Instances.player.getStrength());
		obj.put("stamina", Game.Instances.player.getStamina());
		obj.put("maxlife", Game.Instances.player.getLife());
		obj.put("magic", Game.Instances.player.getMagic());
		obj.put("critical chance", Game.Instances.player.getCritical_chance());
		obj.put("critical damage", Game.Instances.player.getCritical_dmg());
		obj.put("armor", Game.Instances.player.getArmor());
		obj.put("map", Game.Instances.currentMap.name);

		try {
			fileWriter = new FileWriter("src/main/resources/GamePlay/asd.json");
			fileWriter.write(obj.toJSONString());
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//System.out.println("saved");
		}

	}

	/**
	 * Loads a saved game.
	 */
	public static void loadGamePlay() {
		JSONParser parser = new JSONParser();

		try {

			Object obj = parser.parse(new FileReader("src/main/resources/GamePlay/asd.json"));

			JSONObject jsonObject = (JSONObject) obj;

			Game.Instances.player.setName((String) jsonObject.get("name"));
			Game.Instances.player.setX((int) (long) (double) jsonObject.get("x"));
			Game.Instances.player.setY((int) (long) (double) jsonObject.get("y"));
			Game.Instances.player.setCurrentLife((int) (long) jsonObject.get("currentLife"));
			Game.Instances.player.setStrength((int) (long) jsonObject.get("strength"));
			Game.Instances.player.setStamina((int) (long) jsonObject.get("stamina"));
			Game.Instances.player.setLife((int) (long) jsonObject.get("maxlife"));
			Game.Instances.player.setMagic((int) (long) jsonObject.get("magic"));
			Game.Instances.player.setCritical_chance((float) (double) jsonObject.get("critical chance"));
			Game.Instances.player.setCritical_dmg((float) (double) jsonObject.get("critical damage"));
			Game.Instances.player.setArmor((int) (long) jsonObject.get("armor"));
			for (MapHandler map : Game.Instances.collectionMap) {

				if (map.name.equals(((String) jsonObject.get("map")))) {
					Game.Instances.currentMap = map;

				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Not part of the current game version. Loads the tiles where the player can pass to another map.
	 * 
	 * @param name - name of the file which contains the tiles
	 * @return - a list that contains the tiles of passageways
	 */
	// nem része a "adventuresofnealder.beta1"-nek
	public List<Tile> loadpassageWays(String name) {
		List<Tile> loaderTileList = new ArrayList<>();

		String line;
		try {
			Scanner s = new Scanner(this.getClass().getResourceAsStream("/Maps/" + name));
			while (s.hasNext()) {
				line = (s.next());
				String[] linearray;
				linearray = line.split(",");
				loaderTileList.add(new MapHandler.Tile(Integer.parseInt(linearray[0]), Integer.parseInt(linearray[1])));
			}
			s.close();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return loaderTileList;

	}
}
