package com.massivecraft.massivefx.cmd;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.type.primitive.TypeString;
import com.massivecraft.massivefx.MassiveFx;
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
		this.addRequirements(new RequirementHasPerm(Permission.DO.node));
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform() throws MassiveException
	{
		String what = this.readArg();
		String where = this.readArg("there");
				
		String error = MassiveFx.get().performEffect(what, where, me);
		
		if (error != null)
		{
			msg(error);
		}
	}
	
}
