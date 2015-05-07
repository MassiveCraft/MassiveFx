package com.massivecraft.massivefx.fx;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;

public abstract class FxAbstract implements Fx
{
	protected final Map<String, Integer> alias2datas;
	
	protected final String id;
	@Override public String getId() { return this.id; }
	
	protected final boolean visual;
	@Override public boolean hasVisual() { return this.visual; }

	protected final boolean sound;
	@Override public boolean hasSound() { return this.sound; }
	
	protected final String description;
	@Override public String getDescription() { return this.description; }
	
	protected final List<String> names;
	@Override public List<String> getNames() { return this.names; }
	
	public FxAbstract(String id, boolean visual, boolean sound, Map<String, Integer> alias2datas, String description, String... names)
	{
		this.id = id;
		this.visual = visual;
		this.sound = sound;
		this.alias2datas = alias2datas;
		this.description = description;
		this.names = Arrays.asList(names);
	}
	
	@Override
	public void playAt(Location location, String dataString)
	{
		int data = this.parseDataString(dataString, 0);
		this.playAt(location, data);
	}

	@Override
	public void playAt(Location location)
	{
		this.playAt(location, 0);
	}
	
	public Integer parseDataString(String dataString, Integer def)
	{
		if (dataString == null) return def;
		
		if (this.alias2datas != null)
		{
			Integer i = this.alias2datas.get(dataString);
			if (i != null)
			{
				return i.intValue();
			}
		}
		Integer idata = def;
		try
		{
			idata = Integer.valueOf(dataString).intValue();
		}
		catch (Exception e){}
		return idata;
	}
	
}
