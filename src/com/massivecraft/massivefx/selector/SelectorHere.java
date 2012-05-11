package com.massivecraft.massivefx.selector;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class SelectorHere extends BaseSelector
{
	public Collection<Object> getSelection(String data, Object origin)
	{
		ArrayList<Object> ret = new ArrayList<Object>();
		
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
