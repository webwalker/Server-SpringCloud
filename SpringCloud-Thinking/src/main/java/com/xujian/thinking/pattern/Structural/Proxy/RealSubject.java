package com.xujian.thinking.pattern.Structural.Proxy;

// "RealSubject" 
public class RealSubject extends Subject {
	public void Request() {
		System.out.println("Called RealSubject.Request()");
	}
}
