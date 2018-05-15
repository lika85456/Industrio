package com.lika85456.industrio.Map;

/**
 * Vytvoreno 15.05.2018 jako soucast Industrio.
 */
public class Map {
	static final int CHUNK_CACHE_SIZE = 8;
	
	String id;
	String name;
	
	Chunk[] chunkCache;
	
	public static MapInfo[] getAvailableMaps() {
		return null; //zadny StorageManager, zadne mapy
	}
	
	public Map(MapInfo info) {
		id = info.id;
		name = info.name;
		
		chunkCache = new Chunk[CHUNK_CACHE_SIZE];
	}
	public Map(String id){
		this(new MapInfo(id, ""));
	}
	
	public void save(){
		//zadne soubory
	}
	
	public MapInfo getInfo(){
		return new MapInfo(id, name);
	}
}
