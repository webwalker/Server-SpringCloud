package com.xujian.thinking.pattern.Structural.Composite;

import java.util.ArrayList;

// "Composite" 
public class Composite extends Component {
	public Composite(String name) {
		super(name);
	}

	private ArrayList<Component> children = new ArrayList<Component>();

	public void Add(Component component) {
		children.add(component);
	}

	public void Remove(Component component) {
		children.remove(component);
	}

	public void Display(int depth) {
		System.out.println(new String("-" + depth) + name);

		// Recursively display child nodes
		for (Component component : children) {
			component.Display(depth + 2);
		}
	}
}
