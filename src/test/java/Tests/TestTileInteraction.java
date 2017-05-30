package Tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Control.Instances;
import Control.TileInteraction;
import Model.Player;
import View.Game;

public class TestTileInteraction {

	
	
	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testRightCollision() {
		
		Game testGame = new Game();
		Player testPlayer = new Player(40, 100, "testerPlayer",(int) 1,(int) 1,(int) 1,(int) 2,(int) 1,
				(float) 1.00,(float) 1.00,(int) 1);
		Instances testInstances = testGame.Instances;
		TileInteraction testTileInteraction = testInstances.tileinteraction;
		
		testGame.Instances.currentMap.unpassableTilesTOunpassableRectangle();
		testGame.Instances.player = testPlayer;
		testGame.Instances.player.setRight(false);
		testGame.Instances.tileinteraction.collisionTestRight(testGame);
		
		assertEquals(true,testGame.Instances.player.getRight());
		
		
	}
	
	@Test
	public void testUpCollision() {
		
		Game testGame = new Game();
		Player testPlayer = new Player(40, 100, "testerPlayer",(int) 1,(int) 1,(int) 1,(int) 2,(int) 1,
				(float) 1.00,(float) 1.00,(int) 1);
		Instances testInstances = testGame.Instances;
		TileInteraction testTileInteraction = testInstances.tileinteraction;
		
		testGame.Instances.currentMap.unpassableTilesTOunpassableRectangle();
		testGame.Instances.player = testPlayer;
		testGame.Instances.player.setUp(false);
		testGame.Instances.tileinteraction.collisionTestUp(testGame);
		
		assertEquals(true,testGame.Instances.player.getUp());
		
		
	}
	
	@Test
	public void testDownCollision() {
		
		Game testGame = new Game();
		Player testPlayer = new Player(40, 100, "testerPlayer",(int) 1,(int) 1,(int) 1,(int) 2,(int) 1,
				(float) 1.00,(float) 1.00,(int) 1);
		Instances testInstances = testGame.Instances;
		TileInteraction testTileInteraction = testInstances.tileinteraction;
		
		testGame.Instances.currentMap.unpassableTilesTOunpassableRectangle();
		testGame.Instances.player = testPlayer;
		testGame.Instances.player.setDown(false);
		testGame.Instances.tileinteraction.collisionTestDown(testGame);
		
		assertEquals(true,testGame.Instances.player.getDown());
		
	}
	
	@Test
	public void testLeftCollision() {
		
		Game testGame = new Game();
		Player testPlayer = new Player(40, 100, "testerPlayer",(int) 1,(int) 1,(int) 1,(int) 2,(int) 1,
				(float) 1.00,(float) 1.00,(int) 1);
		Instances testInstances = testGame.Instances;
		TileInteraction testTileInteraction = testInstances.tileinteraction;
		
		testGame.Instances.currentMap.unpassableTilesTOunpassableRectangle();
		testGame.Instances.player = testPlayer;
		testGame.Instances.player.setLeft(false);
		testGame.Instances.tileinteraction.collisionTestLeft(testGame);
		
		assertEquals(true,testGame.Instances.player.getLeft());
		
	}

}










