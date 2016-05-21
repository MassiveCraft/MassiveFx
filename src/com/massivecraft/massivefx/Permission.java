package com.massivecraft.massivefx;

import org.bukkit.command.CommandSender;

import com.massivecraft.massivecore.util.PermissionUtil;

public enum Permission
{
	FX_LIST("fxlist"),
	SELECTOR_LIST("selectorlist"),
	DO("do"),
	;
	
	public final String node;
	
	Permission(final String permissionNode)
	{
		this.node = "massivefx."+permissionNode;
    }
	
	public boolean has(CommandSender sender, boolean informSenderIfNot)
	{
		return PermissionUtil.has(sender, this.node, informSenderIfNot);
	}
	
	public boolean has(CommandSender sender)
	{
		return has(sender, false);
	}
}