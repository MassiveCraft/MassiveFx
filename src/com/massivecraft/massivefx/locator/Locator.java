package com.massivecraft.massivefx.locator;

import org.bukkit.Location;

import java.util.Collection;

public interface Locator
{
	boolean canLocate(Object object);
	Location getLocation(Object object);
	Collection<Location> getLocations(Object object);
}
