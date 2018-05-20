package com.lika85456.industrio.Game.Map;

/**
 * Vytvoreno 15.05.2018 jako soucast Industrio.
 */
public class MapInfo {
	public final String id;
	public final String name;
	public final String[] chunks;
	public final int chunkCount;

    //do mapInfo bych přidal nějakou statistiku, to znamená hours played,

	public MapInfo(String id, String name, String[] chunks){
		this.id = id;
		this.name = name;
		this.chunks = chunks;
		chunkCount = chunks == null?0:chunks.length;
	}
	
	public MapInfo(MapInfo info){
		id = info.id;
		name = info.name;
		chunks = info.chunks;
		chunkCount = info.chunkCount;
	}
}
