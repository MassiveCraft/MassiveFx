package com.massivecraft.massivefx.cmd;

import com.massivecraft.massivefx.P;
import com.massivecraft.massivefx.Permission;
import com.massivecraft.mcore.cmd.MCommand;
import com.massivecraft.mcore.cmd.req.ReqHasPerm;

public class CmdDo extends MCommand
{
	public CmdDo()
	{
		this.addAliases("do");
		this.addRequiredArg("effect");
		this.addOptionalArg("selector", "there");
		this.addRequirements(new ReqHasPerm(Permission.DO.node));
	}
	
	@Override
	public void perform()
	{
		String what = this.arg(0);
		String where = "there";
		if (this.argIsSet(1))
		{
			where = this.arg(1);
		}
				
		String error = P.p.performEffect(what, where, me);
		
		if (error != null)
		{
			msg(error);
		}
	}
}