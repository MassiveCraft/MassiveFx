package com.massivecraft.massivefx.selector;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.entity.Player;

import com.massivecraft.mcore.util.IdUtil;

public class SelectorPlayer extends SelectorAbstract
{	
	public Collection<Object> getSelection(String data, Object origin)
	{
		ArrayList<Object> ret = new ArrayList<Object>();
		
		for (String playerName : data.split("\\s*,\\s*"))
		{
			Player player = IdUtil.getPlayer(playerName);
			if (player != null)
			{
				ret.add(player);
			}
		}
				
		return ret;
	}
	
	private SelectorPlayer()
	{
		super("player", "Select a player.", "player:notch");
	}
	private static SelectorPlayer instance = new SelectorPlayer();
	public static SelectorPlayer getInstance() { return instance; }
}
