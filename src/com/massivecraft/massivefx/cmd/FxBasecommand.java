package com.massivecraft.massivefx.cmd;

import com.massivecraft.massivefx.Conf;
import com.massivecraft.mcore4.cmd.HelpCommand;

public class FxBasecommand extends FxCommand
{
	public FxBasecommand()
	{
		super();
		this.addAliases(Conf.aliases);
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