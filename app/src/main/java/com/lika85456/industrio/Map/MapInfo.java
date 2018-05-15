package com.lika85456.industrio.Map;

/**
 * Vytvoreno 15.05.2018 jako soucast Industrio.
 */
public class MapInfo {
	public String id;
	public String name;
	
	public MapInfo(String id, String name){
		this.id = id;
		this.name = name;
	}
	
	public MapInfo(MapInfo info){
		id = info.id;
		name = info.name;
	}
}
