package Control;

import java.awt.Rectangle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Model.MapHandler;
import View.Game;

/**
 * Handles thhe possible interaction with tiles while player performs different movement on them.
 * 
 * @author Bencs Dániel
 *
 */
public class TileInteraction {
	
	/**
	 * Logger to an annoying NullPointException.
	 */
	private static Logger logger = LoggerFactory.getLogger(MapHandler.class);
	
	public static void handlePassageWay() {
		if (Instances.player.collisionTest.getX() >= 570 && Instances.player.collisionTest.getY() >= 155
				&& Instances.player.collisionTest.getY() <= 190
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Map1.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Falucska1;
			Instances.player.setX(42);
			Instances.player.setY(158);
			logger.info("Map1 -> Falucska1");
		}
		if (Instances.player.collisionTest.getX() <= 40 && Instances.player.collisionTest.getY() >= 155
				&& Instances.player.collisionTest.getY() <= 194
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Falucska1.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Map1;
			Instances.player.setX(550);
			Instances.player.setY(160);
			logger.info("Falucska1 -> Map1");
		}
		if (Instances.player.collisionTest.getX() >= 266 && Instances.player.collisionTest.getX() <= 305
				&& Instances.player.collisionTest.getY() >= 555
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Map1.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Map2;
			Instances.player.setX(288);
			Instances.player.setY(35);
			logger.info("Map1 -> Map2");
		}
		if (Instances.player.collisionTest.getX() >= 270 && Instances.player.collisionTest.getX() <= 303
				&& Instances.player.collisionTest.getY() <= 35
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Map2.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Map1;
			Instances.player.setX(277);
			Instances.player.setY(520);
			logger.info("Map2 -> Map1");
		}
		if (Instances.player.collisionTest.getX() >= 385 && Instances.player.collisionTest.getX() <= 415
				&& Instances.player.collisionTest.getY() <= 34
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Falucska1.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Falucska2;
			Game.Instances.currentMap.listOfNPCs.clear();
			Game.Instances.currentMap.listOfNPCs.add(Game.Instances.food_potion_vendor);
			Instances.player.setX(390);
			Instances.player.setY(534);
			logger.info("Falucska1 -> Falucska2");
		}
		if (Instances.player.collisionTest.getX() >= 385 && Instances.player.collisionTest.getX() <= 405
				&& Instances.player.collisionTest.getY() >= 577
				&& Game.Instances.currentMap.mapImageGround.equals(Game.Instances.Falucska2.mapImageGround)) {
			Game.Instances.currentMap = Game.Instances.Falucska1;
			Instances.player.setX(390);
			Instances.player.setY(35);
			logger.info("Falucska2 -> Falucska1");
		}

	}
	
	/**
	 * Collision tester of the player and the unpassable rectangles from down.
	 * If collision, then counters the movement that caused collision for smooth
	 * continous "in-place" movement.
	 */
	public static void collisionTestUp() {
		for (Rectangle rec : Game.Instances.currentMap.unpassableRectangle) {
			if (Instances.player.collisionTest.intersects(rec)
					|| (Instances.player.collisionTest.getY() == rec.getY() + rec.getHeight()
							&& Instances.player.collisionTest.getX() <= rec.getX() + rec.getWidth()
							&& Instances.player.collisionTest.getX() + Instances.player.collisionTest.getWidth() >= rec
									.getX())) {
				logger.info("up collision happaned");
				Instances.player.setY((int) Instances.player.getY() + 2);
				break;
			} else
				Instances.player.setUp(true);
		}
	}

	/**
	 * Collision tester of the player and the unpassable rectangles from up. If
	 * collision, then counters the movement that caused collision for smooth
	 * continous "in-place" movement.
	 */
	public static void collisionTestDown() {
		for (Rectangle rec : Game.Instances.currentMap.unpassableRectangle) {
			if (Instances.player.collisionTest.intersects(rec)
					|| (Instances.player.collisionTest.getY() + Instances.player.collisionTest.getHeight() == rec.getY()
							&& Instances.player.collisionTest.getX() + Instances.player.collisionTest.getWidth() >= rec
									.getX()
							&& Instances.player.collisionTest.getX() <= rec.getX() + rec.getWidth())) {
				logger.info("down collision happaned");
				Instances.player.setY((int) Instances.player.getY() - 2);
				break;
			} else
				Instances.player.setDown(true);
		}

	}

	/**
	 * Collision tester of the player and the unpassable rectangles from right.
	 * If collision, then counters the movement that caused collision for smooth
	 * continous "in-place" movement.
	 */
	public static void collisionTestLeft() {
		for (Rectangle rec : Game.Instances.currentMap.unpassableRectangle) {
			if (Instances.player.collisionTest.intersects(rec)
					|| (Instances.player.collisionTest.getX() == rec.getX() + rec.getWidth()
							&& Instances.player.collisionTest.getY() <= rec.getY() + rec.getHeight()
							&& Instances.player.collisionTest.getY() + Instances.player.collisionTest.getHeight() >= rec
									.getY())) {
				logger.info("left collision happaned");
				Instances.player.setX((int) Instances.player.getX() + 2);
				break;
			} else
				Instances.player.setLeft(true);
		}

	}

	/**
	 * Collision tester of the player and the unpassable rectangles from left.
	 * If collision, then counters the movement that caused collision for smooth
	 * continous "in-place" movement.
	 */
	public static void collisionTestRight() {
		for (Rectangle rec : Game.Instances.currentMap.unpassableRectangle) {
			if (Instances.player.collisionTest.intersects(rec)
					|| (Instances.player.collisionTest.getX() + Instances.player.collisionTest.width == rec.getX()
							&& Instances.player.collisionTest.getY() + Instances.player.collisionTest.getHeight() >= rec
									.getY()
							&& Instances.player.collisionTest.getY() <= rec.getY() + rec.getHeight())) {
				logger.info("right collision happaned");
				Instances.player.setX((int) Instances.player.getX() - 2);
				break;
			} else
				Instances.player.setRight(true);
		}

	}

}
