package com.massivecraft.massivefx.locator;

import java.util.Collection;

import org.bukkit.Location;

public interface Locator
{
	public boolean canLocate(Object object);
	public Location getLocation(Object object);
	public Collection<Location> getLocations(Object object);
}
