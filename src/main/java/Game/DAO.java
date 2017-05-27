package Game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Game.MapHandler.Tile;

public class DAO {

	public static List<Tile> loadUnpassableTiles(String name) {
		List<Tile> loaderTileList = new ArrayList<>();

		String line;
		try {
			Scanner s = new Scanner(new File("src/main/resources/Maps/" + name));
			while (s.hasNext()) {
				line = (s.next());
				String[] linearray;
				linearray = line.split(",");
				loaderTileList.add(new MapHandler.Tile(Integer.parseInt(linearray[0]), Integer.parseInt(linearray[1])));
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return loaderTileList;

	}

	// nem része a "adventuresofnealder.beta1"-nek
	public static List<Tile> loadpassageWays(String name) {
		List<Tile> loaderTileList = new ArrayList<>();

		String line;
		try {
			Scanner s = new Scanner(new File("src/main/resources/Maps/" + name));
			while (s.hasNext()) {
				line = (s.next());
				String[] linearray;
				linearray = line.split(",");
				loaderTileList.add(new MapHandler.Tile(Integer.parseInt(linearray[0]), Integer.parseInt(linearray[1])));
			}
			s.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}

		return loaderTileList;

	}
}
