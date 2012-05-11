package com.massivecraft.massivefx.fx;

import java.util.List;

import org.bukkit.Location;


public interface Fx
{
	public String getId();
	public List<String> getNames();
	public String getDescription();
	public boolean hasVisual();
	public boolean hasSound();
	public void playAt(Location location, String dataString);
	public void playAt(Location location, int data);
	public void playAt(Location location);
}
