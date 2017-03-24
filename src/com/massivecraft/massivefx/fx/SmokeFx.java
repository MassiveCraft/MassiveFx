package com.massivecraft.massivefx.fx;

import com.massivecraft.massivefx.Const;
import com.massivecraft.massivefx.MassiveFx;
import org.bukkit.Effect;
import org.bukkit.Location;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.TreeMap;

public class SmokeFx extends FxAbstract
{
	private SmokeFx(String id, boolean visual, boolean sound, Map<String, Integer> alias2datas, String description, String... names)
	{
		super(id, visual, sound, alias2datas, description, names);
	}

	@Override
	public void playAt(Location location, String dataString)
	{
		if (dataString == null || dataString.length() == 0)
		{
			spawnAll(location);
			return;
		}
		
		char first = dataString.toLowerCase().charAt(0);
		
		if(first == 'r') 
		{
			// Random!
			Entry<String, String> randomAndCountstring = MassiveFx.nameDataSplit(dataString);
			String countstring = randomAndCountstring.getValue();
			if (countstring != null)
			{
				int count = 1;
				try
				{
					count = Integer.parseInt(countstring);
				}
				catch (Exception e){}
				spawnRandom(location, count);
				return;
			}
		}
		Integer data = this.parseDataString(dataString, null);
		if (data != null)
		{
			this.playAt(location, data);
			return;
		}
		
		spawnAll(location);
	}
	
	@Override
	public void playAt(Location location, int data)
	{
		spawnSingle(location, data);
	}
	
	protected final static Map<String, Integer> aliases;
	static
	{
		aliases = new TreeMap<String, Integer>(String.CASE_INSENSITIVE_ORDER);
		aliases.put("0", 0);
		aliases.put("1", 1);
		aliases.put("2", 2);
		aliases.put("3", 3);
		aliases.put("4", 4);
		aliases.put("5", 5);
		aliases.put("6", 6);
		aliases.put("7", 7);
		aliases.put("8", 8);
		
		aliases.put("northwest", 0);
		aliases.put("north", 1);
		aliases.put("northeast", 2);
		aliases.put("west", 3);
		aliases.put("up", 4);
		aliases.put("east", 5);
		aliases.put("southwest", 6);
		aliases.put("south", 7);
		aliases.put("southeast", 8);
		
		aliases.put("nw", 0);
		aliases.put("n", 1);
		aliases.put("ne", 2);
		aliases.put("w", 3);
		aliases.put("u", 4);
		aliases.put("e", 5);
		aliases.put("sw", 6);
		aliases.put("s", 7);
		aliases.put("se", 8);
		
		aliases.put("middle", 4);
		aliases.put("m", 4);
	}
	
	public static final SmokeFx instance = new SmokeFx("MASSIVEFX_SMOKE", true, false, aliases, "Smoke particles", "smoke", "smokes");
	
	// -------------------------------------------- //
	// SMOKE PARTICLE UTILS
	// -------------------------------------------- //
	
	public static Random random = new Random();
	
	// Single ========
	public static void spawnSingle(Location location, int direction)
	{
		if (location == null) return;
		location.getWorld().playEffect(location, Effect.SMOKE, direction, Const.fxBlockViewDistanceLimited);
	}
	
	public static void spawnSingleRandom(Location location)
	{
		spawnSingle(location, random.nextInt(9));
	}
	
	// Simple Cloud ========
	public static void spawnAll(Location location)
	{
		for (int i = 0; i <= 8; i++)
		{
			spawnSingle(location, i);
		}
	}
	
	// Random Cloud ========
	public static void spawnRandom(Location location, int count)
	{
		for (int i = 0; i < count; i++)
		{
			spawnSingleRandom(location);
		}
	}
}

