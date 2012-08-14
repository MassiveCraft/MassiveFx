package com.massivecraft.massivefx.fx;

import java.util.Map;

import org.bukkit.Location;

import com.massivecraft.mcore3.util.SmokeUtil;

public class TntFx extends BaseFx
{
	private TntFx(String id, boolean visual, boolean sound, Map<String, Integer> alias2datas, String description, String... names)
	{
		super(id, visual, sound, alias2datas, description, names);
	}

	@Override
	public void playAt(Location location, int data)
	{
	    SmokeUtil.fakeExplosion(location);
	}
	
	public static final TntFx instance = new TntFx("MASSIVEFX_TNT", true, true, null, "Non-damaging tnt explosion", "tnt", "tntexplosion", "explostion");
}

