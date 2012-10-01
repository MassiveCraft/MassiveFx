package com.massivecraft.massivefx;

import java.util.List;

import com.massivecraft.mcore4.SimpleConfig;
import com.massivecraft.mcore4.util.MUtil;

public class ConfServer extends SimpleConfig
{
	// -------------------------------------------- //
	// FIELDS
	// -------------------------------------------- //
	
	public static List<String> aliases = MUtil.list("fx");
	
	// -------------------------------------------- //
	// Persistance
	// -------------------------------------------- //
	public static transient ConfServer i = new ConfServer();
	private ConfServer()
	{
		super(P.p);
	}
}
