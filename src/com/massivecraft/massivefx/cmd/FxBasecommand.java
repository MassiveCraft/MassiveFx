package com.massivecraft.massivefx.cmd;

import com.massivecraft.massivefx.ConfServer;
import com.massivecraft.mcore.cmd.HelpCommand;
import com.massivecraft.mcore.cmd.MCommand;

public class FxBasecommand extends MCommand
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