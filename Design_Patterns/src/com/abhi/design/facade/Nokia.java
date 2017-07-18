package com.abhi.design.facade;

public class Nokia implements MobileShop{

	@Override
	public void modelNo() {
		System.out.println("Nokia 6s");
		
	}

	@Override
	public void price() {
		System.out.println("40000.00");
		
	}

}
