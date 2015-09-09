package com.massivecraft.massivefx.cmd;

import com.massivecraft.massivecore.cmd.MassiveCommand;

public class CmdFx extends MassiveCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdFx()
	{
		// Aliases
		this.addAliases("fx");
		
		// SubCommands
		this.addSubCommand(new CmdFxList());
		this.addSubCommand(new CmdFxSelectorList());
		this.addSubCommand(new CmdFxDo());
	}

}
