package com.massivecraft.massivefx.cmd;

import com.massivecraft.massivecore.command.MassiveCommand;

public class CmdFx extends MassiveCommand
{
	// -------------------------------------------- //
	// INSTANCE
	// -------------------------------------------- //
	
	private static CmdFx i = new CmdFx();
	public static CmdFx get() { return i; }
	
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdFx()
	{
		// Aliases
		this.addAliases("fx");
		
		// Children
		this.addChild(new CmdFxList());
		this.addChild(new CmdFxSelectorList());
		this.addChild(new CmdFxDo());
	}

}
