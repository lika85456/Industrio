package com.lika85456.industrio.Map;

/**
 * Vytvoreno 15.05.2018 jako soucast Industrio.
 */
public class BackgroundTileInfo {
	
	public final boolean walkable;
	public final boolean freeToBuild;
	
	public BackgroundTileInfo(byte tileType){
		switch(tileType){
			case BackgroundTileType.WATER:
				walkable = false;
				freeToBuild = true;
				break;
			case BackgroundTileType.GRASS:
				walkable = true;
				freeToBuild = true;
				break;
			case BackgroundTileType.DIRT:
				walkable = true;
				freeToBuild = true;
				break;
			case BackgroundTileType.STONE:
				walkable = true;
				freeToBuild = true;
				break;
			case BackgroundTileType.STONE_BLOCK:
				walkable = false;
				freeToBuild = false;
				break;
			case BackgroundTileType.IRON_ORE:
				walkable = true;
				freeToBuild = true;
				break;
			case BackgroundTileType.COAL_ORE:
				walkable = true;
				freeToBuild = true;
				break;
			default:
				throw new IllegalArgumentException("Invalid background tile type: " + String.valueOf(tileType));
		}
	}
	
}
