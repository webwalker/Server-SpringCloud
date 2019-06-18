package com.xujian.thinking.pattern.Behavioral.Strategy;

// "Context" 
public class Context {
	Strategy strategy;

	// Constructor
	public Context(Strategy strategy) {
		this.strategy = strategy;
	}

	public void ContextInterface() {
		strategy.AlgorithmInterface();
	}
}