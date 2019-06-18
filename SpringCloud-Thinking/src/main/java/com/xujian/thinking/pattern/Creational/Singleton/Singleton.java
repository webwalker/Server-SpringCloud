package com.xujian.thinking.pattern.Creational.Singleton;

// "Singleton"
public class Singleton {
	private static Singleton instance;

	// Note: Constructor is 'protected'
	protected Singleton() {
	}

	public static Singleton Instance() {
		// Uses lazy initialization
		if (instance == null) {
			instance = new Singleton();
		}

		return instance;
	}
}
