package com.massivecraft.massivefx.cmd;

import com.massivecraft.massivecore.cmd.HelpCommand;
import com.massivecraft.massivecore.cmd.MassiveCommand;
import com.massivecraft.massivefx.ConfServer;

public class FxBasecommand extends MassiveCommand
{
	public FxBasecommand()
	{
		this.addAliases(ConfServer.aliases);
		this.addSubCommand(HelpCommand.get());
		this.addSubCommand(new CmdFxList());
		this.addSubCommand(new CmdSelectorList());
		this.addSubCommand(new CmdDo());
	}

}