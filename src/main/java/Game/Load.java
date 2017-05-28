package Game;

public class Load {

	public static void init() {
		Game.Instances.Map1.unpassableTiles = DAO.loadUnpassableTiles("Map1unpassableTiles2");
		Game.Instances.collectionMap.add(Game.Instances.Map1);
		Game.Instances.Map1.unpassableTilesTOunpassableRectangle();
	}

}
