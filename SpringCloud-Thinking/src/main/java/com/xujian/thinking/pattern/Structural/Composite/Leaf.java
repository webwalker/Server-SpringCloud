package com.xujian.thinking.pattern.Structural.Composite;

// "Leaf" 
public class Leaf extends Component {
	public Leaf(String name) {
		super(name);
	}

	public void Add(Component c) {
		System.out.println("Cannot add to a leaf");
	}

	public void Remove(Component c) {
		System.out.println("Cannot remove from a leaf");
	}

	public void Display(int depth) {
		System.out.println(new String("-" + depth) + name);
	}
}
