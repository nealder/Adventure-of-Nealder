package Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Control.Instances;
import View.Game;

import java.awt.Rectangle;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Handler of the whole map system.
 * 
 * @author Bencs Dániel
 *
 */
public class MapHandler {
	/**
	 * Logger to an annoying NullPointException.
	 */
	private static Logger logger = LoggerFactory.getLogger(MapHandler.class);

	/**
	 * Name of the map. Currently slightly missleading.
	 */
	public String name;
	/**
	 * The location of the ground image of the map.
	 */
	public URL mapImageGround;
	/**
	 * List of the npc's located on the map.
	 */
	public List<NPC> listOfNPCs = new ArrayList<NPC>(); 	// nem része a "adventuresofnealder.beta1"-nek

	/**
	 * The location of the object image of the map.
	 */
	public URL mapImageObjects;

	/**
	 * The list of the tiles which are unpassable by player.
	 */
	public List<Tile> unpassableTiles;
	/**
	 * The list of rectangles that are used to collision test with player.
	 */
	public List<Rectangle> unpassableRectangle = new ArrayList<Rectangle>();

	/**
	 * Currently unused. The list of tiles where the player can get to another
	 * map.
	 */
	public List<Tile> passageWays; // nem része a "adventuresofnealder.beta1"-nek

	/**
	 * Constructor.
	 * 
	 * @param mapImageGround
	 *            - the location of the ground image of the map
	 * @param mapImageObjects
	 *            - the location of the object image of the map
	 * @param name
	 *            - the name of the map
	 */
	public MapHandler(URL mapImageGround, URL mapImageObjects, String name) {
		this.unpassableTiles = Instances.dao.loadUnpassableTiles(name);
		unpassableTilesTOunpassableRectangle();
		this.name = name;
		this.mapImageGround = mapImageGround;
		this.mapImageObjects = mapImageObjects;

		logger.info("maphandler initializing with " + name);
	}

	/**
	 * Nested class of MapHandler. Handles tiles.
	 * 
	 * @author Nealder
	 *
	 */
	public static class Tile {
		/**
		 * the x coordinate of the tile's upleft corner.
		 */
		int x;
		/**
		 * the y coordinate of the tile's upleft corner.
		 */
		int y;
		/**
		 * the dx coordinate of the tile's width.
		 */
		int dx = 32;
		/**
		 * the dy coordinate of the tile's height.
		 */
		int dy = 32;

		/**
		 * Constructor.
		 * 
		 * @param x
		 *            - the x component of the tile's ID
		 * @param y
		 *            - the y component of the tile's ID
		 */
		public Tile(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	/**
	 * Loading the unpassable rectangles's list using the tile list.
	 */
	public void unpassableTilesTOunpassableRectangle() {
		for (Tile imp : this.unpassableTiles) {
			this.unpassableRectangle.add(new Rectangle((imp.x - 1) * 32, (imp.y - 1) * 32, 32, 32));
			logger.info(this.getClass() + " initialized its unpassable Rectangles");
		}
	}

}
