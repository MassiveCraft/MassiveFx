package com.massivecraft.massivefx.selector;

import java.util.ArrayList;
import java.util.Collection;

public class SelectorSelf extends SelectorAbstract
{
	public Collection<Object> getSelection(String data, Object origin)
	{
		ArrayList<Object> ret = new ArrayList<Object>();
		
		if (origin == null) return ret;
		
		ret.add(origin);
		return ret;
	}
	
	private SelectorSelf()
	{
		super("self", "Select a what is selected already.", null);
	}
	private static SelectorSelf instance = new SelectorSelf();
	public static SelectorSelf getInstance() { return instance; }
}
