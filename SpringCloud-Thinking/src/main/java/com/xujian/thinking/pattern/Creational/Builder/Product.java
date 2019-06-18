package com.xujian.thinking.pattern.Creational.Builder;

import java.util.ArrayList;

// "Product" 
public class Product {
	ArrayList<String> parts = new ArrayList<String>();

	public void Add(String part) {
		parts.add(part);
	}

	public void Show() {
		System.out.println("\nProduct Parts -------");
		for (String part : parts)
			System.out.println(part);
	}
}
