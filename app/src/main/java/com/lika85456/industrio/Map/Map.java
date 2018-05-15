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
		//TODO: ziskej seznam map z "maps.dat" <-- prosim nezabirat nazev
	}
	
	public Map(MapInfo info) {
		id = info.id;
		name = info.name;
		
		chunkCache = new Chunk[CHUNK_CACHE_SIZE];
		for(int i = 0; i < CHUNK_CACHE_SIZE; i++){
			chunkCache[i] = null;
		}
	}
	public Map(String id){
		this(new MapInfo(id, ""));
	}
	
	public void save(){
		//zadne soubory
		//TODO: uloz cache (a mozna vycisti)
	}
	
	public MapInfo getInfo(){
		return new MapInfo(id, name);
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
}
