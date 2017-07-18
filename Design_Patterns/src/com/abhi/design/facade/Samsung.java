package com.abhi.design.facade;

public class Samsung implements MobileShop{

	@Override
	public void modelNo() {
		System.out.println("Samsung galaxy");
		
	}

	@Override
	public void price() {
		System.out.println("55000.00");
		
	}

}
