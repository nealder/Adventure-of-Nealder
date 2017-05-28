package DAO;

import View.Game;

/**
 * A class we use to load things in which reguire control.
 * 
 * @author Nealder
 *
 */
public class Load {

	/**
	 * A procedure we call once to load up the specified list.
	 */
	public static void init() {
		Game.Instances.collectionMap.add(Game.Instances.Map1);
		Game.Instances.collectionMap.add(Game.Instances.Map2);
		Game.Instances.collectionMap.add(Game.Instances.Falucska1);
		Game.Instances.collectionMap.add(Game.Instances.Falucska2);
		Game.Instances.currentMap=Game.Instances.Falucska2;
		Game.Instances.currentMap.listOfNPCs.add(Game.Instances.food_potion_vendor);
	}

}
