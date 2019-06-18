package com.xujian.thinking.pattern.Creational.Builder;

// "ConcreteBuilder2" 
public class ConcreteBuilder2 extends Builder {
	private Product product = new Product();

	@Override
	public void BuildPartA() {
		product.Add("PartX");
	}

	@Override
	public void BuildPartB() {
		product.Add("PartY");
	}

	@Override
	public Product GetResult() {
		return product;
	}
}
