package com.massivecraft.massivefx.selector;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import com.massivecraft.mcore4.util.IntervalUtil;

public class SelectorLocation extends BaseSelector
{
	public Collection<Object> getSelection(String data, Object origin)
	{
		ArrayList<Object> ret = new ArrayList<Object>();
		
		Location location = this.locFromData(data);
		if (location != null)
		{
			ret.add(location);
		}
		
		return ret;
	}
	
	public Location locFromData(String data)
	{
		String[] parts = data.split(",");
		if (parts.length != 4) return null;
		World world = Bukkit.getWorld(parts[0]);
		Double x = IntervalUtil.parseDouble(parts[1], null);
		Double y = IntervalUtil.parseDouble(parts[2], null);
		Double z = IntervalUtil.parseDouble(parts[3], null);
		
		if (world == null) return null;
		if (x == null) return null;
		if (y == null) return null;
		if (z == null) return null;
		
		return new Location(world, x, y, z);
	}
	
	public SelectorLocation()
	{
		super("loc", "Select location", "loc:world,1,2,3");
	}
	
	private static SelectorLocation instance = new SelectorLocation();
	public static SelectorLocation getInstance() { return instance; }
}
