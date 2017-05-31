package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Control.Instances;
import Control.TileInteraction;
import Model.MapHandler;
import Model.Player;
import View.Game;

public class TestTileInteraction {
	
	/**
	 * Logger.
	 */
	private static Logger logger = LoggerFactory.getLogger(MapHandler.class); 

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testRightCollision() {

		Game testGame = new Game();
		Player testPlayer = new Player(40, 100, "testerPlayer", (int) 1, (int) 1, (int) 1, (int) 2, (int) 1,
				(float) 1.00, (float) 1.00, (int) 1);
		Instances testInstances = testGame.Instances;
		TileInteraction testTileInteraction = testInstances.tileinteraction;

		testGame.Instances.currentMap.unpassableTilesTOunpassableRectangle();
		testGame.Instances.player = testPlayer;
		testGame.Instances.player.setRight(false);
		testGame.Instances.tileinteraction.collisionTestRight(testGame);

		assertEquals(true, testGame.Instances.player.getRight());

	}

	@Test
	public void testUpCollision() {

		Game testGame = new Game();
		Player testPlayer = new Player(40, 100, "testerPlayer", (int) 1, (int) 1, (int) 1, (int) 2, (int) 1,
				(float) 1.00, (float) 1.00, (int) 1);
		Instances testInstances = testGame.Instances;
		TileInteraction testTileInteraction = testInstances.tileinteraction;

		testGame.Instances.currentMap.unpassableTilesTOunpassableRectangle();
		testGame.Instances.player = testPlayer;
		testGame.Instances.player.setUp(false);
		testGame.Instances.tileinteraction.collisionTestUp(testGame);

		assertEquals(true, testGame.Instances.player.getUp());

	}

	@Test
	public void testDownCollision() {

		Game testGame = new Game();
		Player testPlayer = new Player(40, 100, "testerPlayer", (int) 1, (int) 1, (int) 1, (int) 2, (int) 1,
				(float) 1.00, (float) 1.00, (int) 1);
		Instances testInstances = testGame.Instances;
		TileInteraction testTileInteraction = testInstances.tileinteraction;

		testGame.Instances.currentMap.unpassableTilesTOunpassableRectangle();
		testGame.Instances.player = testPlayer;
		testGame.Instances.player.setDown(false);
		testGame.Instances.tileinteraction.collisionTestDown(testGame);

		assertEquals(true, testGame.Instances.player.getDown());

	}

	@Test
	public void testLeftCollision() {

		Game testGame = new Game();
		Player testPlayer = new Player(40, 100, "testerPlayer", (int) 1, (int) 1, (int) 1, (int) 2, (int) 1,
				(float) 1.00, (float) 1.00, (int) 1);
		Instances testInstances = testGame.Instances;
		TileInteraction testTileInteraction = testInstances.tileinteraction;

		testGame.Instances.currentMap.unpassableTilesTOunpassableRectangle();
		testGame.Instances.player = testPlayer;
		testGame.Instances.player.setLeft(false);
		testGame.Instances.tileinteraction.collisionTestLeft(testGame);

		assertEquals(true, testGame.Instances.player.getLeft());

	}

	@Test
	public void testLeftnoCollision() {

		Game testGame = new Game();
		Player testPlayer = new Player(374, 34, "testerPlayer", (int) 1, (int) 1, (int) 1, (int) 2, (int) 1,
				(float) 1.00, (float) 1.00, (int) 1);
		Instances testInstances = testGame.Instances;
		TileInteraction testTileInteraction = testInstances.tileinteraction;

		testGame.Instances.currentMap.unpassableTilesTOunpassableRectangle();
		testGame.Instances.player = testPlayer;
		double testPlayersY = testGame.Instances.player.getY();
		testGame.Instances.player.setLeft(false);
		testGame.Instances.tileinteraction.collisionTestLeft(testGame);

		assertEquals(testPlayersY, testGame.Instances.player.getY(), 2.00);

	}

	@Test
	public void testUpnoCollision() {

		Game testGame = new Game();
		Player testPlayer = new Player(374, 34, "testerPlayer", (int) 1, (int) 1, (int) 1, (int) 2, (int) 1,
				(float) 1.00, (float) 1.00, (int) 1);
		Instances testInstances = testGame.Instances;
		TileInteraction testTileInteraction = testInstances.tileinteraction;

		testGame.Instances.currentMap.unpassableTilesTOunpassableRectangle();
		testGame.Instances.player = testPlayer;
		double testPlayersY = testGame.Instances.player.getY();
		testGame.Instances.player.setLeft(false);
		testGame.Instances.tileinteraction.collisionTestLeft(testGame);

		assertEquals(testPlayersY, testGame.Instances.player.getY(), 2.00);

	}

	@Test
	public void testDownnoCollision() {

		Game testGame = new Game();
		Player testPlayer = new Player(567, 99, "testerPlayer", (int) 1, (int) 1, (int) 1, (int) 2, (int) 1,
				(float) 1.00, (float) 1.00, (int) 1);
		Instances testInstances = testGame.Instances;
		TileInteraction testTileInteraction = testInstances.tileinteraction;

		testGame.Instances.currentMap.unpassableTilesTOunpassableRectangle();
		testGame.Instances.player = testPlayer;
		double testPlayersY = testGame.Instances.player.getY();
		testGame.Instances.player.setDown(false);
		testGame.Instances.tileinteraction.collisionTestLeft(testGame);

		assertEquals(testPlayersY, testGame.Instances.player.getY(), 2.00);

	}

	@Test
	public void testRightnoCollision() {

		Game testGame = new Game();
		Player testPlayer = new Player(567, 99, "testerPlayer", (int) 1, (int) 1, (int) 1, (int) 2, (int) 1,
				(float) 1.00, (float) 1.00, (int) 1);
		Instances testInstances = testGame.Instances;
		TileInteraction testTileInteraction = testInstances.tileinteraction;

		testGame.Instances.currentMap.unpassableTilesTOunpassableRectangle();
		testGame.Instances.player = testPlayer;
		double testPlayersx = testGame.Instances.player.getX();
		testGame.Instances.player.setRight(false);
		testGame.Instances.tileinteraction.collisionTestLeft(testGame);

		assertEquals(testPlayersx, testGame.Instances.player.getX(), 2.00);

	}

	@Test
	public void testPassageWays() {
		Game testGame = new Game();
		Player testPlayer = new Player(390, 578, "testerPlayer", (int) 1, (int) 1, (int) 1, (int) 2, (int) 1,
				(float) 1.00, (float) 1.00, (int) 1);
		Instances testInstances = testGame.Instances;
		TileInteraction testTileInteraction = testInstances.tileinteraction;

		testGame.Instances.currentMap.unpassableTilesTOunpassableRectangle();
		testGame.Instances.player = testPlayer;
		testGame.Instances.tileinteraction.handlePassageWay();

		assertNotEquals(testGame.Instances.Falucska2.name, testGame.Instances.currentMap.name);

	}
	
	@Test
	public void testnoPassageWays() {
		Game testGame = new Game();
		Player testPlayer = new Player(390, 0, "testerPlayer", (int) 1, (int) 1, (int) 1, (int) 2, (int) 1,
				(float) 1.00, (float) 1.00, (int) 1);
		Instances testInstances = testGame.Instances;
		TileInteraction testTileInteraction = testInstances.tileinteraction;

		testGame.Instances.currentMap.unpassableTilesTOunpassableRectangle();
		testGame.Instances.player = testPlayer;
		testGame.Instances.currentMap = testGame.Instances.Falucska2;
		testGame.Instances.tileinteraction.handlePassageWay();

		assertEquals(testGame.Instances.Falucska2.mapImageGround, testGame.Instances.currentMap.mapImageGround);

	}

}
