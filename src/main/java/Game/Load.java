package Game;

public class Load {

	public static void init() {
		Instances.Map1.unpassableTiles = DAO.loadUnpassableTiles("Map1unpassableTiles2");
		Instances.collectionMap.add(Instances.Map1);
		Instances.Map1.unpassableTilesTOunpassableRectangle();
	}

}
