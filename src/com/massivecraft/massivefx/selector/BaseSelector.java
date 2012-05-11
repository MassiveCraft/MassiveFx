package com.massivecraft.massivefx.selector;

public abstract class BaseSelector implements Selector
{
	protected String id; 
	@Override public String getId() { return this.id; }
	
	protected String description;
	@Override public String getDescription() { return this.description; }
	
	protected String example;
	@Override public String getExample() { return this.example; }
	
	
	public BaseSelector(String id, String description, String example)
	{
		this.id = id;
		this.description = description;
		this.example = example;
	}
	
}
