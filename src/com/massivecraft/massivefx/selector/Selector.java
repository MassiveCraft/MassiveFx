package com.massivecraft.massivefx.selector;

import java.util.Collection;

public interface Selector
{
	String getId();
	String getDescription();
	String getExample();
	Collection<Object> getSelection(String data, Object origin);
}
