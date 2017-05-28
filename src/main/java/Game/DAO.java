package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import Game.MapHandler.Tile;
import ch.qos.logback.core.net.SyslogOutputStream;
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
	public  List<Tile> loadUnpassableTiles(String name) {
		List<Tile> loaderTileList = new ArrayList<>();

		String line;
		try {
			Scanner s = new Scanner(this.getClass().getResourceAsStream("/Maps/" + name)); // this.getClass().getResourceAsStream
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

	/**
	 * Saves the current game, including player position on map and player stats.
	 */
	@SuppressWarnings("unchecked")
	public  void saveGamePlay() {
		JSONObject obj = new JSONObject();
		FileWriter fileWriter;

		obj.put("x", Instances.player.getX());
		obj.put("y", Instances.player.getY());
		obj.put("name", Instances.player.getName());
		obj.put("currentLife", Instances.player.getCurrentLife());
		obj.put("strength", Instances.player.getStrength());
		obj.put("stamina", Instances.player.getStamina());
		obj.put("maxlife", Instances.player.getLife());
		obj.put("magic", Instances.player.getMagic());
		obj.put("critical chance", Instances.player.getCritical_chance());
		obj.put("critical damage", Instances.player.getCritical_dmg());
		obj.put("armor", Instances.player.getArmor());
		obj.put("map", Game.Instances.currentMap.name);

		try {
			URL url = DAO.class.getResource("/GamePlay/asd.json");
			File file = new File(url.toURI());
			fileWriter = new FileWriter(file);
			fileWriter.write(obj.toJSONString());
			fileWriter.close();
		} catch (IOException | URISyntaxException e) {
			e.printStackTrace();
		} finally {
			//System.out.println("saved");
		}

	}

	/**
	 * Currently not used.Loads a saved game.
	 */
	public  void loadGamePlay() {
		JSONParser parser = new JSONParser();

		try {
			InputStream input = DAO.class.getClassLoader().getResourceAsStream("GamePlay/asd.json");
			Reader reader = new InputStreamReader(input);
			//private static File json = new File(GamePlayDataDAO.class.getClassLoader().getResource("json/json").getPath());
			//System.out.println(this.getClass().getClassLoader().getResource("").getPath());
			//Object obj = parser.parse(this.getClass().getClassLoader().getResource("GamePlay/asd.json").getPath());

			Object obj = parser.parse(reader);
			JSONObject jsonObject = (JSONObject) obj;

			Instances.player.setName((String) jsonObject.get("name"));
			Instances.player.setX((int) (long) (double) jsonObject.get("x"));
			Instances.player.setY((int) (long) (double) jsonObject.get("y"));
			Instances.player.setCurrentLife((int) (long) jsonObject.get("currentLife"));
			Instances.player.setStrength((int) (long) jsonObject.get("strength"));
			Instances.player.setStamina((int) (long) jsonObject.get("stamina"));
			Instances.player.setLife((int) (long) jsonObject.get("maxlife"));
			Instances.player.setMagic((int) (long) jsonObject.get("magic"));
			Instances.player.setCritical_chance((float) (double) jsonObject.get("critical chance"));
			Instances.player.setCritical_dmg((float) (double) jsonObject.get("critical damage"));
			Instances.player.setArmor((int) (long) jsonObject.get("armor"));
			for (MapHandler map : Game.Instances.collectionMap) {

				if (map.name.equals(((String) jsonObject.get("map")))) {
					Game.Instances.currentMap = map;

				}
			}

		} catch (ParseException | IOException e) {
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
