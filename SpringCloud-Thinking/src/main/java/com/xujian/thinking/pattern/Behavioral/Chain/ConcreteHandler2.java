package com.xujian.thinking.pattern.Behavioral.Chain;

// "ConcreteHandler2"
public class ConcreteHandler2 extends Handler {

	@Override
	public void HandleRequest(int request) {
		if (request >= 10 && request < 20) {
			System.out.println(this.getClass().getName() + " handled request"
					+ request);
		} else if (successor != null) {
			successor.HandleRequest(request);
		}
	}
}
