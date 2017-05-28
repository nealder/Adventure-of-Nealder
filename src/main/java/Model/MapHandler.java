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
	public List<NPC> listOfNPCs = new ArrayList<NPC>();

	// nem része a "adventuresofnealder.beta1"-nek
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

	// nem része a "adventuresofnealder.beta1"-nek
	/**
	 * Currently unused. The list of tiles where the player can get to another map.
	 */
	public List<Tile> passageWays;

	/**
	 * Constructor.
	 * 
	 * @param mapImageGround - the location of the ground image of the map
	 * @param mapImageObjects - the location of the object image of the map
	 * @param name - the name of the map
	 */
	public MapHandler(URL mapImageGround, URL mapImageObjects, String name) {
		// super();
		//System.out.println("maphandler initializing with " + name);
		this.unpassableTiles = Instances.dao.loadUnpassableTiles(name); 
		//unpassableTiles = DAO.loadUnpassableTiles(name);
		unpassableTilesTOunpassableRectangle();
		this.name=name;
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
		 * @param x - the x component of the tile's ID
		 * @param y - the y component of the tile's ID
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
			// System.out.println(unpassableRectangle);
			logger.info(this.getClass()+" initialized its unpassable Rectangles");
		}
	}

	/**
	 * Currently alpha (functionally) version of passageway handling. Tests the passageways if the player is in them. If so, the corresponding map loads in.
	 */
	public void handlePassageWay() {
		if (Instances.player.collisionTest.getX() >= 570 && Instances.player.collisionTest.getY() >= 155
				&& Instances.player.collisionTest.getY() <= 190
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Map1.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Falucska1;
			Instances.player.setX(42);
			Instances.player.setY(158);
		}
		if (Instances.player.collisionTest.getX() <= 40 && Instances.player.collisionTest.getY() >= 155
				&& Instances.player.collisionTest.getY() <= 194
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Falucska1.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Map1;
			Instances.player.setX(550);
			Instances.player.setY(160);
		}
		if (Instances.player.collisionTest.getX() >= 266 && Instances.player.collisionTest.getX() <= 305
				&& Instances.player.collisionTest.getY() >= 555
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Map1.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Map2;
			Instances.player.setX(288);
			Instances.player.setY(35);
		}
		if (Instances.player.collisionTest.getX() >= 270 && Instances.player.collisionTest.getX() <= 303
				&& Instances.player.collisionTest.getY() <= 35
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Map2.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Map1;
			Instances.player.setX(277);
			Instances.player.setY(520);
		}
		if (Instances.player.collisionTest.getX() >= 385 && Instances.player.collisionTest.getX() <= 415
				&& Instances.player.collisionTest.getY() <= 34
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Falucska1.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Falucska2;
			Game.Instances.currentMap.listOfNPCs.clear();
			Game.Instances.currentMap.listOfNPCs.add(Game.Instances.food_potion_vendor);
			Instances.player.setX(390);
			Instances.player.setY(534);
		}
		if (Instances.player.collisionTest.getX() >= 385 && Instances.player.collisionTest.getX() <= 405
				&& Instances.player.collisionTest.getY() >= 577
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Falucska2.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Falucska1;
			Instances.player.setX(390);
			Instances.player.setY(35);
		}

	}

	/**
	 * Collision tester of the player and the unpassable rectangles from down. If collision,
	 *  then counters the movement that caused collision for smooth continous "in-place" movement.
	 */
	public void collisionTestUp() {
		for (Rectangle rec : Game.Instances.currentMap.unpassableRectangle) {
			if (Instances.player.collisionTest.intersects(rec)
					|| (Instances.player.collisionTest.getY() == rec.getY() + rec.getHeight()
							&& Instances.player.collisionTest.getX() <= rec.getX() + rec.getWidth()
							&& Instances.player.collisionTest.getX() + Instances.player.collisionTest.getWidth() >= rec
									.getX())) {
				System.out.println("up collision");
				Instances.player.setY((int) Instances.player.getY() + 2);
				break;
			} else
				Instances.player.setUp(true);
		}
	}

	/**
	 * Collision tester of the player and the unpassable rectangles from up. If collision,
	 *  then counters the movement that caused collision for smooth continous "in-place" movement.
	 */
	public void collisionTestDown() {
		for (Rectangle rec : Game.Instances.currentMap.unpassableRectangle) {
			if (Instances.player.collisionTest.intersects(rec)
					|| (Instances.player.collisionTest.getY() + Instances.player.collisionTest.getHeight() == rec.getY()
							&& Instances.player.collisionTest.getX() + Instances.player.collisionTest.getWidth() >= rec
									.getX()
							&& Instances.player.collisionTest.getX() <= rec.getX() + rec.getWidth())) {
				System.out.println("down collision");
				Instances.player.setY((int) Instances.player.getY() - 2);
				break;
			} else
				Instances.player.setDown(true);
		}

	}

	/**
	 * Collision tester of the player and the unpassable rectangles from right. If collision,
	 *  then counters the movement that caused collision for smooth continous "in-place" movement.
	 */
	public void collisionTestLeft() {
		for (Rectangle rec : Game.Instances.currentMap.unpassableRectangle) {
			if (Instances.player.collisionTest.intersects(rec)
					|| (Instances.player.collisionTest.getX() == rec.getX() + rec.getWidth()
							&& Instances.player.collisionTest.getY() <= rec.getY() + rec.getHeight()
							&& Instances.player.collisionTest.getY() + Instances.player.collisionTest.getHeight() >= rec
									.getY())) {
				System.out.println("Left collision");
				Instances.player.setX((int) Instances.player.getX() + 2);
				break;
			} else
				Instances.player.setLeft(true);
		}

	}
	
	/**
	 * Collision tester of the player and the unpassable rectangles from left. If collision,
	 *  then counters the movement that caused collision for smooth continous "in-place" movement.
	 */
	public void collisionTestRight() {
		for (Rectangle rec : Game.Instances.currentMap.unpassableRectangle) {
			if (Instances.player.collisionTest.intersects(rec)
					|| (Instances.player.collisionTest.getX() + Instances.player.collisionTest.width == rec.getX()
							&& Instances.player.collisionTest.getY() + Instances.player.collisionTest.getHeight() >= rec
									.getY()
							&& Instances.player.collisionTest.getY() <= rec.getY() + rec.getHeight())) {
				System.out.println("right collision");
				Instances.player.setX((int) Instances.player.getX() - 2);
				break;
			} else
				Instances.player.setRight(true);
		}

	}

}
