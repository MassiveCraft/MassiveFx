package com.massivecraft.massivefx.locator;

import org.bukkit.Location;

import java.util.Collection;

public interface Locator
{
	public boolean canLocate(Object object);
	public Location getLocation(Object object);
	public Collection<Location> getLocations(Object object);
}
