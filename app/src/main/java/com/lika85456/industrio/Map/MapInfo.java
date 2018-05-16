package com.lika85456.industrio.Map;

/**
 * Vytvoreno 15.05.2018 jako soucast Industrio.
 */
public class MapInfo {
	public final String id;
	public final String name;
	public final String[] chunks;
	public final int chunkCount;
	
	public MapInfo(String id, String name, String[] chunks, int chunkCount){
		this.id = id;
		this.name = name;
		this.chunks = chunks;
		this.chunkCount = chunkCount;
	}
	
	public MapInfo(MapInfo info){
		id = info.id;
		name = info.name;
		chunks = info.chunks;
		chunkCount = info.chunkCount;
	}
}
