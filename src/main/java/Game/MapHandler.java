package Game;

import java.awt.Rectangle;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MapHandler {

	public String name;
	public URL mapImageGround;
	public List<NPC> listOfNPCs = new ArrayList<NPC>();

	// nem része a "adventuresofnealder.beta1"-nek
	public URL mapImageObjects;

	public List<Tile> unpassableTiles;
	public List<Rectangle> unpassableRectangle = new ArrayList<Rectangle>();

	// nem része a "adventuresofnealder.beta1"-nek
	public List<Tile> passageWays;

	public MapHandler(URL mapImageGround, URL mapImageObjects, String name) {
		// super();
		//System.out.println("maphandler initializing with " + name);
		unpassableTiles = DAO.loadUnpassableTiles(name); //unpassableTiles = Game.Instances.dao.loadUnpassableTiles(name);
		unpassableTilesTOunpassableRectangle();
		this.name=name;
		this.mapImageGround = mapImageGround;
		this.mapImageObjects = mapImageObjects;
	}

	public static class Tile {
		int x;
		int y;
		int dx = 32;
		int dy = 32;

		public Tile(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public void unpassableTilesTOunpassableRectangle() {
		for (Tile imp : this.unpassableTiles) {
			this.unpassableRectangle.add(new Rectangle((imp.x - 1) * 32, (imp.y - 1) * 32, 32, 32));
			// System.out.println(unpassableRectangle);
		}
	}

	public void handlePassageWay() {
		if (Game.Instances.player.collisionTest.getX() >= 570 && Game.Instances.player.collisionTest.getY() >= 155
				&& Game.Instances.player.collisionTest.getY() <= 190
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Map1.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Falucska1;
			Game.Instances.player.setX(42);
			Game.Instances.player.setY(158);
		}
		if (Game.Instances.player.collisionTest.getX() <= 40 && Game.Instances.player.collisionTest.getY() >= 155
				&& Game.Instances.player.collisionTest.getY() <= 194
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Falucska1.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Map1;
			Game.Instances.player.setX(550);
			Game.Instances.player.setY(160);
		}
		if (Game.Instances.player.collisionTest.getX() >= 266 && Game.Instances.player.collisionTest.getX() <= 305
				&& Game.Instances.player.collisionTest.getY() >= 555
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Map1.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Map2;
			Game.Instances.player.setX(288);
			Game.Instances.player.setY(35);
		}
		if (Game.Instances.player.collisionTest.getX() >= 270 && Game.Instances.player.collisionTest.getX() <= 303
				&& Game.Instances.player.collisionTest.getY() <= 35
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Map2.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Map1;
			Game.Instances.player.setX(277);
			Game.Instances.player.setY(520);
		}
		if (Game.Instances.player.collisionTest.getX() >= 385 && Game.Instances.player.collisionTest.getX() <= 415
				&& Game.Instances.player.collisionTest.getY() <= 34
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Falucska1.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Falucska2;
			Game.Instances.currentMap.listOfNPCs.clear();
			Game.Instances.currentMap.listOfNPCs.add(Game.Instances.food_potion_vendor);
			Game.Instances.player.setX(390);
			Game.Instances.player.setY(534);
		}
		if (Game.Instances.player.collisionTest.getX() >= 385 && Game.Instances.player.collisionTest.getX() <= 405
				&& Game.Instances.player.collisionTest.getY() >= 577
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Falucska2.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Falucska1;
			Game.Instances.player.setX(390);
			Game.Instances.player.setY(35);
		}

	}

	public void collisionTestUp() {
		for (Rectangle rec : Game.Instances.currentMap.unpassableRectangle) {
			if (Game.Instances.player.collisionTest.intersects(rec)
					|| (Game.Instances.player.collisionTest.getY() == rec.getY() + rec.getHeight()
							&& Game.Instances.player.collisionTest.getX() <= rec.getX() + rec.getWidth()
							&& Game.Instances.player.collisionTest.getX() + Game.Instances.player.collisionTest.getWidth() >= rec
									.getX())) {
				System.out.println("up collision");
				Game.Instances.player.setY((int) Game.Instances.player.getY() + 2);
				break;
			} else
				Game.Instances.player.setUp(true);
		}
	}

	public void collisionTestDown() {
		for (Rectangle rec : Game.Instances.currentMap.unpassableRectangle) {
			if (Game.Instances.player.collisionTest.intersects(rec)
					|| (Game.Instances.player.collisionTest.getY() + Game.Instances.player.collisionTest.getHeight() == rec.getY()
							&& Game.Instances.player.collisionTest.getX() + Game.Instances.player.collisionTest.getWidth() >= rec
									.getX()
							&& Game.Instances.player.collisionTest.getX() <= rec.getX() + rec.getWidth())) {
				System.out.println("down collision");
				Game.Instances.player.setY((int) Game.Instances.player.getY() - 2);
				break;
			} else
				Game.Instances.player.setDown(true);
		}

	}

	public void collisionTestLeft() {
		for (Rectangle rec : Game.Instances.currentMap.unpassableRectangle) {
			if (Game.Instances.player.collisionTest.intersects(rec)
					|| (Game.Instances.player.collisionTest.getX() == rec.getX() + rec.getWidth()
							&& Game.Instances.player.collisionTest.getY() <= rec.getY() + rec.getHeight()
							&& Game.Instances.player.collisionTest.getY() + Game.Instances.player.collisionTest.getHeight() >= rec
									.getY())) {
				System.out.println("Left collision");
				Game.Instances.player.setX((int) Game.Instances.player.getX() + 2);
				break;
			} else
				Game.Instances.player.setLeft(true);
		}

	}

	public void collisionTestRight() {
		for (Rectangle rec : Game.Instances.currentMap.unpassableRectangle) {
			if (Game.Instances.player.collisionTest.intersects(rec)
					|| (Game.Instances.player.collisionTest.getX() + Game.Instances.player.collisionTest.width == rec.getX()
							&& Game.Instances.player.collisionTest.getY() + Game.Instances.player.collisionTest.getHeight() >= rec
									.getY()
							&& Game.Instances.player.collisionTest.getY() <= rec.getY() + rec.getHeight())) {
				System.out.println("right collision");
				Game.Instances.player.setX((int) Game.Instances.player.getX() - 2);
				break;
			} else
				Game.Instances.player.setRight(true);
		}

	}

}
