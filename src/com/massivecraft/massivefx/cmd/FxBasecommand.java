package com.massivecraft.massivefx.cmd;

import com.massivecraft.massivefx.ConfServer;
import com.massivecraft.mcore.cmd.HelpCommand;
import com.massivecraft.mcore.cmd.MCommand;

public class FxBasecommand extends MCommand
{
	public FxBasecommand()
	{
		super();
		this.addAliases(ConfServer.aliases);
		this.addSubCommand(HelpCommand.getInstance());
		this.addSubCommand(new CmdFxList());
		this.addSubCommand(new CmdSelectorList());
		this.addSubCommand(new CmdDo());
	}
	
	@Override
	public void perform()
	{
		this.getCommandChain().add(this);
		HelpCommand.getInstance().execute(this.sender, this.args, this.commandChain);
	}
}