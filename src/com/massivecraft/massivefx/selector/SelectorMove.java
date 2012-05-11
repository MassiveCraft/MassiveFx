package com.massivecraft.massivefx.selector;

import java.util.ArrayList;
import java.util.Collection;

import org.bukkit.Location;
import org.bukkit.block.BlockFace;

import com.massivecraft.massivefx.P;
import com.massivecraft.mcore3.MCore;
import com.massivecraft.mcore3.util.IntervalUtil;

public class SelectorMove extends BaseSelector
{
	protected final BlockFace face;
	protected final static BlockFace[] faces = {BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST, BlockFace.UP, BlockFace.DOWN, BlockFace.NORTH_EAST, BlockFace.NORTH_WEST, BlockFace.SOUTH_EAST, BlockFace.SOUTH_WEST};
	public BlockFace getFace()
	{
		if (this.face == null)
		{
			return faces[MCore.random.nextInt(faces.length)];
		}
		return this.face;
	}
	
	public SelectorMove(String id, String name, String code, BlockFace face)
	{
		super(id, "Move "+name+".", "m"+code+"3 m"+code+"0to5");
		this.face = face;
	}
	
	public Collection<Object> getSelection(String data, Object origin)
	{
		ArrayList<Object> ret = new ArrayList<Object>();
		BlockFace face = this.getFace();
		double length = IntervalUtil.randomDoubleFromInterval(data, 1d);
		
		for (Location location : P.p.getLocations(origin))
		{
			Location newLocation = location.clone();
			newLocation.add(face.getModX()*length, face.getModY()*length, face.getModZ()*length);
			ret.add(newLocation);
		}
		
		return ret;
	}
	
	public static SelectorMove NORTH = new SelectorMove("mn", "north", "n", BlockFace.NORTH);
	public static SelectorMove EAST = new SelectorMove("me", "east", "e", BlockFace.EAST);
	public static SelectorMove SOUTH = new SelectorMove("ms","south", "s", BlockFace.SOUTH);
	public static SelectorMove WEST = new SelectorMove("mw", "west", "w", BlockFace.WEST);
	public static SelectorMove UP = new SelectorMove("mu", "up", "u", BlockFace.UP);
	public static SelectorMove DOWN = new SelectorMove("md", "down", "d", BlockFace.DOWN);
	public static SelectorMove NORTH_EAST = new SelectorMove("mne", "north-east", "ne", BlockFace.NORTH_EAST);
	public static SelectorMove NORTH_WEST = new SelectorMove("mnw", "north-west", "nw", BlockFace.NORTH_WEST);
	public static SelectorMove SOUTH_EAST = new SelectorMove("mse", "south-east", "se", BlockFace.SOUTH_EAST);
	public static SelectorMove SOUTH_WEST = new SelectorMove("msw", "south-west", "sw", BlockFace.SOUTH_WEST);
	public static SelectorMove RANDOM = new SelectorMove("mr", "random", "r", null);
}
