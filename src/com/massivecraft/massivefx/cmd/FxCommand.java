package com.massivecraft.massivefx.cmd;

import com.massivecraft.massivefx.P;
import com.massivecraft.mcore3.cmd.MCommand;

public abstract class FxCommand extends MCommand
{
	public P p;
	public FxCommand()
	{
		super();
		this.p = P.p;
	}
	
	@Override
	public P p()
	{
		return P.p;
	}
	
	/*public GPlayer gme;
	@Override
	public void fixSenderVars()
	{
		this.gme = GPlayers.i.get(this.me);
	}*/
	
}
