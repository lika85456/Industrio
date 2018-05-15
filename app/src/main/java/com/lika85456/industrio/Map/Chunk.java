package com.lika85456.industrio.Map;

import java.util.List;

/**
 * Vytvoreno 15.05.2018 jako soucast Industrio.
 */
public class Chunk {
	static final int CHUNK_SIZE = 64;
	
	public byte[][] backGroundTiles;
	public List<BuildingTile> buildingTiles;
	public int x;
	public int y;
	
	public Chunk(byte[] chunkData, int x, int y){
		this.x = x;
		this.y = y;
	}
	public Chunk(String file, int x, int y){
		//TODO: nacti se sam
	}
	
}
