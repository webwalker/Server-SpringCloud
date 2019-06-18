package com.xujian.thinking.pattern.Structural.Facade;

// "Facade"
public class Facade {
	SubSystemOne one;
	SubSystemTwo two;
	SubSystemThree three;
	SubSystemFour four;

	public Facade() {
		one = new SubSystemOne();
		two = new SubSystemTwo();
		three = new SubSystemThree();
		four = new SubSystemFour();
	}

	public void MethodA() {
		System.out.println("\nMethodA() ---- ");
		one.MethodOne();
		two.MethodTwo();
		four.MethodFour();
	}

	public void MethodB() {
		System.out.println("\nMethodB() ---- ");
		two.MethodTwo();
		three.MethodThree();
	}
}
