package com.linnyk.ocp;

public class OuterClass4 {

	private InnerPeace i = new InnerPeace();

	private class InnerPeace   {
		private String reason = "none";
	}

	void m(){
		System.out.println(i.reason);
	}
}
