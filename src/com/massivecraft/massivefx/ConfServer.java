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
	// Persistence
	// -------------------------------------------- //
	public static transient ConfServer i = new ConfServer();
	public ConfServer() { super(P.p); }
}
