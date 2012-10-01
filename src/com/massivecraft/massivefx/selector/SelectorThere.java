package com.massivecraft.massivefx.selector;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.BlockIterator;

import com.massivecraft.massivefx.Const;

public class SelectorThere extends SelectorAbstract
{
	public Collection<Object> getSelection(String data, Object origin)
	{
		ArrayList<Object> ret = new ArrayList<Object>();
		
		if (!(origin instanceof LivingEntity)) return ret;
		
		LivingEntity livingEntity = (LivingEntity)origin;
		
		Block cursorFace = getCursorFace(livingEntity);
		
		ret.add(cursorFace);
		return ret;
	}
	
	public static Block getCursorFace(LivingEntity livingEntity)
	{
		Block ret = null;
		
		Block previous = livingEntity.getEyeLocation().getBlock();
		Block current = null;
		BlockIterator itr = new BlockIterator(livingEntity, Const.fxBlockViewDistanceUnlimited);
		while (itr.hasNext())
		{
			current = itr.next();
			if (current.getType() != Material.AIR)
			{
				ret = previous;
				break;
			}
			previous = current;
		}
		
		return ret;
	}
	
	private SelectorThere()
	{
		super("there", "Select cursor target.", null);
	}
	private static SelectorThere instance = new SelectorThere();
	public static SelectorThere getInstance() { return instance; }
}
