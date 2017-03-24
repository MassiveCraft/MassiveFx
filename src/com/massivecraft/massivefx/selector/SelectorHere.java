package com.massivecraft.massivefx.selector;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

import java.util.ArrayList;
import java.util.Collection;

public class SelectorHere extends SelectorAbstract
{
	public Collection<Object> getSelection(String data, Object origin)
	{
		ArrayList<Object> ret = new ArrayList<>();
		
		if (!(origin instanceof Entity)) return ret;
		
		Entity entity = (Entity)origin;
		
		Location location = entity.getLocation();
		
		ret.add(location);
		return ret;
	}
	
	public SelectorHere()
	{
		super("here", "Select single location from entity.", null);
	}
	
	private static SelectorHere instance = new SelectorHere();
	public static SelectorHere getInstance() { return instance; }
}
