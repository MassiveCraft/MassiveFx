package com.massivecraft.massivefx;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;

import com.massivecraft.massivefx.cmd.FxBasecommand;
import com.massivecraft.massivefx.fx.Fx;
import com.massivecraft.massivefx.fx.SmokeFx;
import com.massivecraft.massivefx.fx.StrikeFx;
import com.massivecraft.massivefx.fx.TntFx;
import com.massivecraft.massivefx.fx.VanillaFx;
import com.massivecraft.massivefx.locator.Locator;
import com.massivecraft.massivefx.locator.LocatorHumanEntity;
import com.massivecraft.massivefx.selector.Selector;
import com.massivecraft.massivefx.selector.SelectorHere;
import com.massivecraft.massivefx.selector.SelectorLocation;
import com.massivecraft.massivefx.selector.SelectorMove;
import com.massivecraft.massivefx.selector.SelectorPlayer;
import com.massivecraft.massivefx.selector.SelectorSelf;
import com.massivecraft.massivefx.selector.SelectorSphere;
import com.massivecraft.massivefx.selector.SelectorThere;
import com.massivecraft.mcore5.MPlugin;
import com.massivecraft.mcore5.util.Txt;

public class P extends MPlugin
{
	// Our single plugin instance
	public static P p;
	
	// Command
	public FxBasecommand fxBasecommand;
	
	public P()
	{
		P.p = this;
	}
	
	@Override
	public void onEnable()
	{
		if ( ! preEnable()) return;
		
		// Load Conf from disk
		ConfServer.i.load();
		
		// Add Base Commands
		this.fxBasecommand = new FxBasecommand();
		this.fxBasecommand.register(this);
		
		// Register Fx
		this.registerFx(VanillaFx.POTION_BREAK);
		this.registerFx(VanillaFx.STEP_SOUND);
		this.registerFx(TntFx.instance);
		this.registerFx(StrikeFx.instance);
		this.registerFx(SmokeFx.instance);
		this.registerFx(VanillaFx.MOBSPAWNER_FLAMES);
		this.registerFx(VanillaFx.ENDER_SIGNAL);
		this.registerFx(VanillaFx.CLICK1);
		this.registerFx(VanillaFx.CLICK2);
		this.registerFx(VanillaFx.DOOR_TOGGLE);
		this.registerFx(VanillaFx.ZOMBIE_CHEW_WOODEN_DOOR);
		this.registerFx(VanillaFx.ZOMBIE_CHEW_IRON_DOOR);
		this.registerFx(VanillaFx.ZOMBIE_DESTROY_DOOR);
		this.registerFx(VanillaFx.EXTINGUISH);
		this.registerFx(VanillaFx.GHAST_SHRIEK);
		this.registerFx(VanillaFx.GHAST_SHOOT);
		//this.registerFx(VanillaFx.BLAZE_SHOOT);
		this.registerFx(VanillaFx.BOW_FIRE);
		this.registerFx(VanillaFx.RECORD_PLAY);
		
		// Register Selectors
		this.registerSelector(SelectorSelf.getInstance());
		this.registerSelector(SelectorThere.getInstance());
		this.registerSelector(SelectorHere.getInstance());
		this.registerSelector(SelectorPlayer.getInstance());
		this.registerSelector(SelectorLocation.getInstance());
		this.registerSelector(SelectorSphere.getInstance());
		this.registerSelector(SelectorMove.NORTH);
		this.registerSelector(SelectorMove.EAST);
		this.registerSelector(SelectorMove.SOUTH);
		this.registerSelector(SelectorMove.WEST);
		this.registerSelector(SelectorMove.UP);
		this.registerSelector(SelectorMove.DOWN);
		this.registerSelector(SelectorMove.NORTH_EAST);
		this.registerSelector(SelectorMove.NORTH_WEST);
		this.registerSelector(SelectorMove.SOUTH_EAST);
		this.registerSelector(SelectorMove.SOUTH_WEST);
		this.registerSelector(SelectorMove.RANDOM);
		
		// Register Locators
		this.registerLocator(LocatorHumanEntity.getInstance());
		
		postEnable();
	}
	
	// -------------------------------------------- //
	// FX REGISTRY
	// -------------------------------------------- //
	
	protected Map<String, Fx> id2fx = new LinkedHashMap<String, Fx>();
	
	public Collection<Fx> getFxs()
	{
		return id2fx.values();
	}
	
	public boolean registerFx(Fx fx)
	{
		if (id2fx.containsKey(fx.getId())) return false;
		id2fx.put(fx.getId(), fx);
		return true;
	}
	
	public Fx getFxById(String id)
	{
		return id2fx.get(id);
	}
	
	public List<Fx> getFxByName(String nameStart)
	{
		List<Fx> ret = new ArrayList<Fx>();
		String nameStartFixed = nameStart.toLowerCase().replace("_", "").replace("-", "");
		
		for (Fx fx : id2fx.values())
		{
			for (String candidateName : fx.getNames())
			{
				if (candidateName.toLowerCase().startsWith(nameStartFixed))
				{
					ret.add(fx);
					break;
				}
			}
		}
		return ret;
	}
	
	// -------------------------------------------- //
	// SELECTOR REGISTRY
	// -------------------------------------------- //
	
	protected Map<String, Selector> id2selector = new LinkedHashMap<String, Selector>();
	
	public Collection<Selector> getSelectors()
	{
		return id2selector.values();
	}
	
	public boolean registerSelector(Selector s)
	{
		if (id2selector.containsKey(s.getId())) return false;
		id2selector.put(s.getId(), s);
		return true;
	}
	
	public Selector getSelectorById(String id)
	{
		return id2selector.get(id);
	}
	
	// -------------------------------------------- //
	// LOCATOR REGISTRY
	// -------------------------------------------- //
	
	protected List<Locator> locators = new ArrayList<Locator>();
	
	public boolean registerLocator(Locator l)
	{
		locators.add(l);
		return true;
	}
	
	public Location getLocation(Object object)
	{
		if (object == null)
		{
			return null;
		}
		else if (object instanceof Location)
		{
			return (Location)object;
		}
		else if (object instanceof Block)
		{
			return ((Block)object).getLocation();
		}
		else if (object instanceof Entity)
		{
			return ((Entity)object).getLocation();
		}
		
		for (Locator locator: locators)
		{
			if (locator.canLocate(object))
			{
				return locator.getLocation(object);
			}
		}
		return null;
	}
	
	public Collection<Location> getLocations(Object object)
	{
		List<Location> ret = new ArrayList<Location>();
		
		if (object == null)
		{
			return ret;
		}
		else if (object instanceof Location)
		{
			ret.add((Location)object);
			return ret;
		}
		else if (object instanceof Block)
		{
			ret.add(((Block)object).getLocation());
			return ret;
		}
		
		for (Locator locator: locators)
		{
			if (locator.canLocate(object))
			{
				return locator.getLocations(object);
			}
		}
		return null;
	}
	
	public List<Location> getLocations(Collection<Object> objects)
	{
		List<Location> ret = new ArrayList<Location>();
		for (Object object : objects)
		{
			ret.addAll(this.getLocations(object));
		}
		return ret;
	}
	
	// -------------------------------------------- //
	// PARSING
	// -------------------------------------------- //
	
	public static Entry<String, String> nameDataSplit(String string)
	{
		String name = null;
		String data = null;
		
		int colonIndex = string.indexOf(':');
		Integer digitIndex = Txt.indexOfFirstDigit(string);
		int startIndex = string.indexOf('(');
		int stopIndex = string.indexOf(')');
		
		if (colonIndex != -1)
		{
			name = string.substring(0, colonIndex);
			data = string.substring(colonIndex+1, string.length());
		}
		else if (digitIndex != null)
		{
			name = string.substring(0, digitIndex);
			data = string.substring(digitIndex, string.length());
		}
		else if (startIndex != -1 && stopIndex != -1 && stopIndex > startIndex)
		{
			name = string.substring(0, startIndex);
			data = string.substring(startIndex+1, stopIndex-1);
		}
		else
		{
			name = string;
			data = null;
		}
		
		return new SimpleEntry<String, String>(name, data);
	}
	
	public Entry<Fx, String> parseSingleFxString(String singleFxString) throws Exception
	{
		// Basic checks
		if (singleFxString == null)
		{
			throw new Exception("<b>NPE!");
		}
		
		if (singleFxString.length() == 0)
		{
			throw new Exception("<b>No empty fx entries please.");
		}
		
		Entry<String, String> nameData = nameDataSplit(singleFxString);
		String name = nameData.getKey();
		String data = nameData.getValue();
			
		// Next we match the name
		List<Fx> matches = this.getFxByName(name);
		if (matches.size() == 0)
		{
			throw new Exception("<b>\"<h>"+name+"<b>\" does not match any FX.");
		}
		else if (matches.size() > 1)
		{
			throw new Exception("<b>\"<h>"+name+"<b>\" could match any of these FX: "+Txt.implodeCommaAndDot(matches, "<b>"));
		}
		Fx fx = matches.get(0);
		
		return new SimpleEntry<Fx, String>(fx, data);
	}
	
	public List<Entry<Fx, String>> parseMultiFxString(String multiFxString) throws Exception
	{
		List<Entry<Fx, String>> ret = new ArrayList<Entry<Fx, String>>();
		
		String[] singleFxStrings = multiFxString.split("\\s*,\\s*");
		for (String singleFxString : singleFxStrings)
		{
			Entry<Fx, String> entry = parseSingleFxString(singleFxString);
			ret.add(entry);
		}
		
		return ret;
	}
	
	public Entry<Selector, String> parseSingleSelectorString(String singleSelectorString) throws Exception
	{
		// Basic checks
		if (singleSelectorString == null)
		{
			throw new Exception("<b>NPE!");
		}
		
		if (singleSelectorString.length() == 0)
		{
			throw new Exception("<b>No empty selector entries please.");
		}
		
		Entry<String, String> nameData = nameDataSplit(singleSelectorString);
		String name = nameData.getKey();
		String data = nameData.getValue();
			
		// Next we match the name
		Selector selector = this.getSelectorById(name);
		if (selector == null)
		{
			throw new Exception("<b>\"<h>"+name+"<b>\" does not match any selector.");
		}
		
		return new SimpleEntry<Selector, String>(selector, data);
	}
	
	public List<Entry<Selector, String>> parseMultiSelectorString(String multiSelectorString) throws Exception
	{
		List<Entry<Selector, String>> ret = new ArrayList<Entry<Selector, String>>();
		
		String[] singleSelectorStrings = multiSelectorString.split("\\.");
		for (String singleSelectorString : singleSelectorStrings)
		{
			Entry<Selector, String> entry = parseSingleSelectorString(singleSelectorString);
			ret.add(entry);
		}
		
		return ret;
	}
	
	// -------------------------------------------- //
	// PERFORMING
	// -------------------------------------------- //
	
	public List<Object> applySelector(Selector selector, String data, Collection<Object> origins)
	{
		List<Object> ret = new ArrayList<Object>();
		for (Object origin : origins)
		{
			ret.addAll(selector.getSelection(data, origin));
		}
		return ret;
	}
	
	public String performEffect(String what, String where, Object origin)
	{
		// What are the effects?
		List<Entry<Fx, String>> fxDatas;
		try
		{
			fxDatas = P.p.parseMultiFxString(what);
		}
		catch (Exception e)
		{
			return e.getMessage();
		}
		
		// What are the selectors?
		List<Entry<Selector, String>> selectorDatas;
		try
		{
			selectorDatas = P.p.parseMultiSelectorString(where);
		}
		catch (Exception e)
		{
			return e.getMessage();
		}
		
		// Where are the targets?
		List<Object> targets = new ArrayList<Object>();
		if (origin != null)
		{
			targets.add(origin);
		}
		else
		{
			targets.add(Bukkit.getConsoleSender());
		}
		
		for (Entry<Selector, String> selectorData : selectorDatas)
		{
			Selector selector = selectorData.getKey();
			String data = selectorData.getValue();
			targets = P.p.applySelector(selector, data, targets);
		}
		
		// Where are the Locations?
		List<Location> locations = P.p.getLocations(targets);
		
		// Play them
		for(Entry<Fx, String> fxData : fxDatas)
		{
			Fx fx = fxData.getKey();
			String data = fxData.getValue();
			for (Location location : locations)
			{
				fx.playAt(location, data); 
			}
		}
		
		return null;
	}
}
