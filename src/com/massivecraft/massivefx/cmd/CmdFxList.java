package com.massivecraft.massivefx.cmd;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.massivefx.P;
import com.massivecraft.massivefx.Permission;
import com.massivecraft.massivefx.fx.Fx;
import com.massivecraft.mcore3.cmd.req.ReqHasPerm;
import com.massivecraft.mcore3.util.Txt;

public class CmdFxList extends FxCommand
{
	public CmdFxList()
	{
		super();
		this.addAliases("fl","fxlist");
		this.addOptionalArg("page", "1");
		this.addRequirements(new ReqHasPerm(Permission.FX_LIST.node));
	}
	
	@Override
	public void perform()
	{
		Integer pageHumanBased = this.argAs(0, Integer.class, 1);
		if (pageHumanBased == null) return;
		
		List<String> lines = new ArrayList<String>();
		lines.add("<a># <i>There is one FX per line in this list.");
		lines.add("<a># <i>S = Sound, V = Visual, D = Data");
		
		for(Fx fx: P.p.getFxs())
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
		this.sendMessage(Txt.getPage(lines, pageHumanBased, "Available FX"));
	}
}