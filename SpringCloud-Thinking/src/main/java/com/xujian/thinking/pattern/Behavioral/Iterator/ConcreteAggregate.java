package com.xujian.thinking.pattern.Behavioral.Iterator;

import java.util.ArrayList;

// "ConcreteAggregate" 
public class ConcreteAggregate extends Aggregate {

	@Override
	public Iterator CreateIterator() {
		return new ConcreteIterator(this);
	}

	private ArrayList<Object> list = new ArrayList<Object>();

	/**
	 * @return the items
	 */
	public Object getItems(int index) {
		return list.get(index);
	}

	/**
	 * @param items
	 *            the items to set
	 */
	public void setItems(int index, Object data) {
		list.add(index, data);
	}

	// Property
	public int getCount() {
		return list.size();
	}
}