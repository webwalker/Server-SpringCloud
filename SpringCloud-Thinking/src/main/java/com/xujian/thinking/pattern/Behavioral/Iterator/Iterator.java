package com.xujian.thinking.pattern.Behavioral.Iterator;

// "Iterator"
public abstract class Iterator {
	public abstract Object First();

	public abstract Object Next();

	public abstract boolean IsDone();

	public abstract Object CurrentItem();
}