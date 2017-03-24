package com.massivecraft.massivefx.fx;

import org.bukkit.Location;

import java.util.List;


public interface Fx
{
	String getId();
	List<String> getNames();
	String getDescription();
	boolean hasVisual();
	boolean hasSound();
	void playAt(Location location, String dataString);
	void playAt(Location location, int data);
	void playAt(Location location);
}
