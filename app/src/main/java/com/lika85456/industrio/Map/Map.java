package com.lika85456.industrio.Map;

import com.lika85456.industrio.StorageManager;

import java.util.*;

/**
 * Vytvoreno 15.05.2018 jako soucast Industrio.
 */
public class Map {
	static final int CHUNK_CACHE_SIZE = 8;
	
	private String id;
	private String name;
	String[] chunks;
	
	Chunk[] chunkCache;
	
	public Map(MapInfo info) {
		id = info.id;
		name = info.name;
		chunks = info.chunks;
		
		chunkCache = new Chunk[CHUNK_CACHE_SIZE];
		for(int i = 0; i < CHUNK_CACHE_SIZE; i++){
			chunkCache[i] = null;
		}
	}
	public Map(String id){
		//TODO: nacist
		this(new MapInfo(id, "", null, 0));
	}
	
	public static Map createNewMap(String name){
		long timeStamp = System.currentTimeMillis();
		return new Map(new MapInfo(longToString(timeStamp), name, null, 0));
	}
	public static MapInfo[] getAvailableMaps() {
		byte[] maps = StorageManager.loadBytes("maps.dat");
		
		return null; //zadny StorageManager, zadne mapy
		//TODO: ziskej seznam map z "maps.dat" <-- prosim nezabirat nazev
	}
	public void save(){
		//zadne soubory
		//TODO: uloz cache (a mozna vycisti)
		//TODO: uloz mapInfo
	}
	public MapInfo getInfo(){
		return new MapInfo(id, name, chunks, chunks.length);
	}
	public boolean isTileWalkable(int x, int y){
		return getBackgroundTileInfo(x, y).walkable && true;
		//TODO: stavby
	}
	public BackgroundTileInfo getBackgroundTileInfo(int x, int y){
		return new BackgroundTileInfo(getBackgroundTile(x, y));
	}
	private byte getBackgroundTile(int x, int y) {
		for (int i = 0; i < CHUNK_CACHE_SIZE; i++) {
		
		}
		return (byte)255;
	}
	
	private static String longToString(long number){
		String toReturn = "";
		for(int i = 0; i < 16; i++)
			toReturn += (char)((number >> (i * 4)) & 0xF + (int)'A');
		return toReturn;
	}
	
	private class Chunk {
		static final int CHUNK_SIZE = 64;
		
		public byte[][] backGroundTiles;
		public List<BuildingTile> buildingTiles;
		public int x;
		public int y;
		
		public Chunk(byte[] chunkData, int x, int y){
			this.x = x;
			this.y = y;
		}
		public Chunk(int x, int y){
			
			//TODO: nacti se sam
		}
		
	}
}
