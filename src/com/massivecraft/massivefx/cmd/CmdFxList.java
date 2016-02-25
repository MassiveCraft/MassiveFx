package com.massivecraft.massivefx.cmd;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.Parameter;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.util.Txt;
import com.massivecraft.massivefx.MassiveFx;
import com.massivecraft.massivefx.Permission;
import com.massivecraft.massivefx.fx.Fx;

public class CmdFxList extends MassiveCommand
{
	// -------------------------------------------- //
	// CONSTRUCT
	// -------------------------------------------- //
	
	public CmdFxList()
	{
		// Aliases
		this.addAliases("fl", "fxlist");
		
		// Parameters
		this.addParameter(Parameter.getPage());
		
		// Requirements
		this.addRequirements(new RequirementHasPerm(Permission.FX_LIST.node));
	}
	
	// -------------------------------------------- //
	// OVERRIDE
	// -------------------------------------------- //
	
	@Override
	public void perform() throws MassiveException
	{
		int page = this.readArg();
		
		List<String> lines = new ArrayList<String>();
		lines.add("<a># <i>There is one FX per line in this list.");
		lines.add("<a># <i>S = Sound, V = Visual, D = Data");
		
		for (Fx fx: MassiveFx.get().getFxs())
		{
			StringBuilder sb = new StringBuilder();
			
			sb.append(fx.hasVisual() ? "<g>" : "<b>");
			sb.append("V ");
			
			sb.append(fx.hasSound() ? "<g>" : "<b>");
			sb.append("S ");
			
			sb.append("<h>");
			sb.append(fx.getNames().get(0));
			
			sb.append(" <i>");
			sb.append(fx.getDescription());
			lines.add(sb.toString());
		}
		
		lines = Txt.parseWrap(lines);
		this.message(Txt.getPage(lines, page, "Available FX", this));
	}
	
}
