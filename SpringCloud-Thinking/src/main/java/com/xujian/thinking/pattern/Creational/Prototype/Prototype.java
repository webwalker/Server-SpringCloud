package com.xujian.thinking.pattern.Creational.Prototype;

// "Prototype" 
public abstract class Prototype {
	private String id;

	// Constructor
	public Prototype(String id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	public abstract Prototype Clone();
}
