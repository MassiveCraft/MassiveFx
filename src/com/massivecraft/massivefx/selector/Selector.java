package com.massivecraft.massivefx.selector;

import java.util.Collection;

public interface Selector
{
	public String getId();
	public String getDescription();
	public String getExample();
	public Collection<Object> getSelection(String data, Object origin);
}
