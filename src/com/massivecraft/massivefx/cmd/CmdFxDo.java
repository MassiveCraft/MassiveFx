package com.massivecraft.massivefx.cmd;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.cmd.MassiveCommand;
import com.massivecraft.massivecore.cmd.req.ReqHasPerm;
import com.massivecraft.massivecore.cmd.type.TypeString;
import com.massivecraft.massivefx.P;
import com.massivecraft.massivefx.Permission;

public class CmdFxDo extends MassiveCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdFxDo()
	{
		// Aliases
		this.addAliases("do");
		
		// Parameters
		this.addParameter(TypeString.get(), "effect");
		this.addParameter(TypeString.get(), "selector", "there");
		
		// Requirements
		this.addRequirements(new ReqHasPerm(Permission.DO.node));
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform() throws MassiveException
	{
		String what = this.readArg();
		String where = this.readArg("there");
				
		String error = P.p.performEffect(what, where, me);
		
		if (error != null)
		{
			msg(error);
		}
	}
	
}
