package com.lika85456.industrio.Map;

/**
 * Vytvoreno 15.05.2018 jako soucast Industrio.
 */
public class BackgroundTileInfo {
	public static final byte WATER       =   0;
	public static final byte GRASS       =   1;
	public static final byte DIRT        =   2;
	public static final byte STONE       =   3;
	public static final byte STONE_BLOCK =   4;
	public static final byte IRON_ORE    =   5;
	public static final byte COAL_ORE    =   6;
	
	public boolean walkable;
	
	public BackgroundTileInfo(byte tileType){
		switch(tileType){
			case WATER:
				walkable = false;
				break;
			case GRASS:
				walkable = true;
				break;
			case DIRT:
				walkable = true;
				break;
			case STONE:
				walkable = true;
				break;
			case STONE_BLOCK:
				walkable = false;
				break;
			case IRON_ORE:
				walkable = true;
				break;
			case COAL_ORE:
				walkable = true;
				break;
			default:
				throw new IllegalArgumentException("Invalid background tile type: " + String.valueOf(tileType));
		}
	}
	
}
