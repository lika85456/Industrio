package com.lika85456.industrio.Map;

import com.lika85456.industrio.StorageManager;

import java.util.List;

/**
 * Vytvoreno 15.05.2018 jako soucast Industrio.
 *
 * shrnuti obsahu souboru(mel jsem v tom trochu zmatek):
 *
 * - maps.dat
 *   - rada 64-bitovych id map
 *
 * - ?mapId?.map
 *   - jmeno mapy v 16-bitovych charech ukoncene 0x0000 //tohle není úplně nejlepší způsob :D (stačí na začátek napsat jak je to velký a začít novou strukturu až po těch x bytech)
 *   - rada 32+32-bitovych id chunku
 *
 * - ?mapId??chunkId?.cnk
 *   - CHUNK_SIZE * CHUNK_SIZE 8-bitovych id BackgroundTile
 *   - seznam staveb az do konce souboru
 */
public class Map {

	static final int CHUNK_CACHE_SIZE = 8;
	
	private String mapId;
	private String name;
	String[] chunks;
	
	Chunk[] chunkCache;
	
	public Map(MapInfo info) {
		mapId = info.id;
		name = info.name;
		chunks = info.chunks;
		
		chunkCache = new Chunk[CHUNK_CACHE_SIZE];
		for(int i = 0; i < CHUNK_CACHE_SIZE; i++){
			chunkCache[i] = null;
		}
	}
	public Map(String id){
		//TODO: nacist
		this(new MapInfo(id, "", null));
	}
	
	public static Map createNewMap(String name){
		long timeStamp = System.currentTimeMillis();
		return new Map(new MapInfo(longToString(timeStamp), name, null));
	}
	public static MapInfo[] getAvailableMaps() {
		byte[] mapsData = StorageManager.loadBytes("maps.dat");

        //TODO make this return
		return null;
	}
	private static MapInfo loadInfoFile(String id){
		byte[] data = StorageManager.loadBytes(id + ".map");
		String name = "";
		String[] chunks = null;
		int nameEndPos = 0;
		
		for(nameEndPos = 0; data[nameEndPos] + data[nameEndPos + 1] != 0; nameEndPos+=2){
			name += (char)(data[nameEndPos] + data[nameEndPos + 1]);
		}
		
		chunks = new String[(data.length  - nameEndPos + 2) / 8/*pls*/];
		
		for(int i = 0; i < (data.length  - nameEndPos + 2); i += 8){
            //?
		}
		
		return new MapInfo(id, name, chunks);
	}
	private static String longToString(long number){
		String toReturn = "";
        for (int i = 0; i < 16; i++) //jak rozeznáš long od intu v tý tvý struktuře? (moc to nechápu) (string = char můžeš mít 2 byte, jakýkoliv data)
			toReturn += (char)((number >> (i * 4)) & 0xF + (int)'A');
		return toReturn;
	}
	private static String intToString(int number){
		String toReturn = "";
		for(int i = 0; i < 8; i++)
			toReturn += (char)((number >> (i * 4)) & 0xF + (int)'A');
		return toReturn;
	}
	
	
	public void save(){
		for(int i = 0; i < CHUNK_CACHE_SIZE; i++){
			chunkCache[i].save();
		}
		//TODO: uloz mapInfo
	}
	public MapInfo getInfo(){
		return new MapInfo(mapId, name, chunks);
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
	
	private class Chunk {
		static final int CHUNK_SIZE = 64;
		
		public byte[][] backGroundTiles;
		public List<BuildingTile> buildingTiles;
		public final int x;
		public final int y;
		public final String chunkId;
		
		public Chunk(byte[] chunkData, int x, int y){
			this.x = x;
			this.y = y;
			chunkId = intToString(x) + intToString(y);
		}
		public Chunk(int x, int y){
			this(StorageManager.loadBytes(mapId + intToString(x) + intToString(y) + ".cnk"), x, y);
		}
		public void save(){
		
		}
	}
}
