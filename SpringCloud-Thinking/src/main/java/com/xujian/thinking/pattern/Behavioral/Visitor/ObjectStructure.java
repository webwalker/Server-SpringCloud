package com.xujian.thinking.pattern.Behavioral.Visitor;

import java.util.ArrayList;

// "ObjectStructure" 
public class ObjectStructure {
	private ArrayList<Element> elements = new ArrayList<Element>();

	public void Attach(Element element) {
		elements.add(element);
	}

	public void Detach(Element element) {
		elements.remove(element);
	}

	public void Accept(Visitor visitor) {
		for (Element e : elements) {
			e.Accept(visitor);
		}
	}
}
