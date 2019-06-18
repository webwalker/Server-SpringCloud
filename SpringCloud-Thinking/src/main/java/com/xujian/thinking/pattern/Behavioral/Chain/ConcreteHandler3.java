package com.xujian.thinking.pattern.Behavioral.Chain;

// "ConcreteHandler3"
public class ConcreteHandler3 extends Handler {
	@Override
	public void HandleRequest(int request) {
		if (request >= 20 && request < 30) {
			System.out.println(this.getClass().getName() + " handled request"
					+ request);
		} else if (successor != null) {
			successor.HandleRequest(request);
		}
	}
}
