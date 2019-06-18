package com.xujian.thinking.pattern.Behavioral.Iterator;

// "ConcreteIterator" 
public class ConcreteIterator extends Iterator {
	private ConcreteAggregate aggregate;
	private int current = 0;

	// Constructor
	public ConcreteIterator(ConcreteAggregate aggregate) {
		this.aggregate = aggregate;
	}

	@Override
	public Object First() {
		return aggregate.getItems(0);
	}

	@Override
	public Object Next() {
		Object ret = null;
		if (current < aggregate.getCount() - 1) {
			ret = aggregate.getItems(++current);
		}

		return ret;
	}

	@Override
	public boolean IsDone() {
		return current >= aggregate.getCount() ? true : false;
	}

	@Override
	public Object CurrentItem() {
		return aggregate.getItems(current);
	}
}
