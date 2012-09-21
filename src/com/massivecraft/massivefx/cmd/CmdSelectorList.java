package com.massivecraft.massivefx.cmd;

import java.util.ArrayList;
import java.util.List;

import com.massivecraft.massivefx.P;
import com.massivecraft.massivefx.Permission;
import com.massivecraft.massivefx.selector.Selector;
import com.massivecraft.mcore4.cmd.arg.ARInteger;
import com.massivecraft.mcore4.cmd.req.ReqHasPerm;
import com.massivecraft.mcore4.util.Txt;

public class CmdSelectorList extends FxCommand
{
	public CmdSelectorList()
	{
		super();
		this.addAliases("sl","selectorlist");
		this.addOptionalArg("page", "1");
		this.addRequirements(new ReqHasPerm(Permission.SELECTOR_LIST.node));
	}
	
	@Override
	public void perform()
	{
		Integer pageHumanBased = this.arg(0, ARInteger.get(), 1);
		if (pageHumanBased == null) return;
		
		List<String> lines = new ArrayList<String>();
		lines.add("<a># <i>There is one selector per line in this list.");
		lines.add("<a># <i>Selectors have data after a colon like sphere:2");
		lines.add("<a># <i>Chain selectors using dots like there.sphere:3");
		
		for(Selector selector: P.p.getSelectors())
		{
			StringBuilder sb = new StringBuilder();
			
			
			sb.append("<h>");
			sb.append(selector.getId());
			
			sb.append(" <i>");
			sb.append(selector.getDescription());
			
			if (selector.getExample() != null)
			{
				sb.append(" <aqua>");
				sb.append(selector.getExample());
			}
			
			lines.add(sb.toString());
		}
		
		lines = Txt.parseWrap(lines);
		this.sendMessage(Txt.getPage(lines, pageHumanBased, "Available Selectors"));
	}
}