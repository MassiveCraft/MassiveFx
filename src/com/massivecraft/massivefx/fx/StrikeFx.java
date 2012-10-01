package com.massivecraft.massivefx.fx;

import java.util.Map;
import org.bukkit.Location;

public class StrikeFx extends FxAbstract
{
	private StrikeFx(String id, boolean visual, boolean sound, Map<String, Integer> alias2datas, String description, String... names)
	{
		super(id, visual, sound, alias2datas, description, names);
	}

	@Override
	public void playAt(Location location, int data)
	{
		location.getWorld().strikeLightningEffect(location);
	}
	
	public static final StrikeFx instance = new StrikeFx("MASSIVEFX_STRIKE", true, true, null, "Non-damaging lightning strike", "strike", "lightningstrike", "thunder");
}

