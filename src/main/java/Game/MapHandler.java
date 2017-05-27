package Game;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class MapHandler {

	public String mapImageGround;
	
	//nem része a "adventuresofnealder.beta1"-nek
	public String mapImageObjects;
	
	public List<Tile> unpassableTiles;
	public List<Rectangle> unpassableRectangle = new ArrayList<Rectangle>();
	
	//nem része a "adventuresofnealder.beta1"-nek
	public List<Tile> passageWays;

	public MapHandler(String mapImageGround, String mapImageObjects, String name) {
		// super();
		System.out.println("maphandler initializing with " + name);
		unpassableTiles = DAO.loadUnpassableTiles(name);
		unpassableTilesTOunpassableRectangle();
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
		if (Instances.player.collisionTest.getX() >= 570 && Instances.player.collisionTest.getY() >= 155
				&& Instances.player.collisionTest.getY() <= 190
				&& Instances.currentMap.mapImageGround.equals(Instances.Map1.mapImageGround)) {
			Instances.currentMap = Instances.Falucska1;
			Instances.player.setX(42);
			Instances.player.setY(158);
		}
		if (Instances.player.collisionTest.getX() <= 40 && Instances.player.collisionTest.getY() >= 155
				&& Instances.player.collisionTest.getY() <= 194
				&& Instances.currentMap.mapImageGround.equals(Instances.Falucska1.mapImageGround)) {
			Instances.currentMap = Instances.Map1;
			Instances.player.setX(550);
			Instances.player.setY(160);
		}
		if (Instances.player.collisionTest.getX() >= 266 && Instances.player.collisionTest.getX() <= 305
				&& Instances.player.collisionTest.getY() >= 555
				&& Instances.currentMap.mapImageGround.equals(Instances.Map1.mapImageGround)) {
			Instances.currentMap = Instances.Map2;
			Instances.player.setX(288);
			Instances.player.setY(35);
		}
		if (Instances.player.collisionTest.getX() >= 270 && Instances.player.collisionTest.getX() <= 303
				&& Instances.player.collisionTest.getY() <= 35
				&& Instances.currentMap.mapImageGround.equals(Instances.Map2.mapImageGround)) {
			Instances.currentMap = Instances.Map1;
			Instances.player.setX(277);
			Instances.player.setY(520);
		}
		if (Instances.player.collisionTest.getX() >= 385 && Instances.player.collisionTest.getX() <= 415
				&& Instances.player.collisionTest.getY() <= 34
				&& Instances.currentMap.mapImageGround.equals(Instances.Falucska1.mapImageGround)) {
			Instances.currentMap = Instances.Falucska2;
			Instances.player.setX(390);
			Instances.player.setY(534);
		}
		if (Instances.player.collisionTest.getX() >= 385 && Instances.player.collisionTest.getX() <= 405
				&& Instances.player.collisionTest.getY() >= 577
				&& Instances.currentMap.mapImageGround.equals(Instances.Falucska2.mapImageGround)) {
			Instances.currentMap = Instances.Falucska1;
			Instances.player.setX(390);
			Instances.player.setY(35);
		}

	}

	public void collisionTestUp() {
		for (Rectangle rec : Instances.currentMap.unpassableRectangle) {
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

	public void collisionTestDown() {
		for (Rectangle rec : Instances.currentMap.unpassableRectangle) {
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

	public void collisionTestLeft() {
		for (Rectangle rec : Instances.currentMap.unpassableRectangle) {
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

	public void collisionTestRight() {
		for (Rectangle rec : Instances.currentMap.unpassableRectangle) {
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
