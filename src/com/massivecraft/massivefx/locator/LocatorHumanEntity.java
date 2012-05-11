package com.massivecraft.massivefx.locator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.entity.HumanEntity;

public class LocatorHumanEntity implements Locator
{
	@Override
	public boolean canLocate(Object object)
	{
		return object instanceof HumanEntity;
	}

	@Override
	public Location getLocation(Object object)
	{
		HumanEntity he = (HumanEntity)object;
		return he.getLocation();
	}

	@Override
	public Collection<Location> getLocations(Object object)
	{
		List<Location> ret = new ArrayList<Location>();
		
		HumanEntity he = (HumanEntity)object;
		
		ret.add(he.getLocation());
		ret.add(he.getEyeLocation());
		
		return ret;
	}
	
	private LocatorHumanEntity() {}
	private static LocatorHumanEntity instance = new LocatorHumanEntity();
	public static LocatorHumanEntity getInstance() { return instance; }
}
