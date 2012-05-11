package com.massivecraft.massivefx;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

public class Conf
{	
	public static int fxBlockViewDistanceUnlimited = (Bukkit.getViewDistance()+1)*16*2;
	public static int fxBlockViewDistanceLimited = 64;
	public static List<String> aliases = new ArrayList<String>();
	
	static
	{
		aliases.add("fx");
	}
	
	// -------------------------------------------- //
	// Persistance
	// -------------------------------------------- //
	private static transient Conf i = new Conf();
	public static void load()
	{
		P.p.one.loadOrSaveDefault(i, Conf.class);
	}
	public static void save()
	{
		P.p.one.save(i);
	}
}
