package com.massivecraft.massivefx.cmd;

import com.massivecraft.massivecore.command.MassiveCommand;

public class CmdFx extends MassiveCommand
{
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
