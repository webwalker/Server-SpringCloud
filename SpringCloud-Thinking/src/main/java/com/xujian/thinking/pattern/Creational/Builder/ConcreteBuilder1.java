package com.xujian.thinking.pattern.Creational.Builder;

// "ConcreteBuilder1" 
public class ConcreteBuilder1 extends Builder {
	private Product product = new Product();

	@Override
	public void BuildPartA() {
		product.Add("PartA");
	}

	@Override
	public void BuildPartB() {
		product.Add("PartB");
	}

	@Override
	public Product GetResult() {
		return product;
	}
}
