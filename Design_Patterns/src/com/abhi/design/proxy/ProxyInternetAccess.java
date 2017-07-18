package com.abhi.design.proxy;

public class ProxyInternetAccess implements OfficeInternetAccess{
	RealInternetAccess realInternetAccess;
	String employeeName;
	
	public ProxyInternetAccess(String employeeName) {
		this.employeeName = employeeName;
	}


	@Override
	public void grantInternetAccess() {
		if(getEmployee(employeeName)>5)
		{
			realInternetAccess =new RealInternetAccess(employeeName);
			realInternetAccess.grantInternetAccess();
		}
		
	}


	private int getEmployee(String employeeName2) {
		
		return 6;
	}

}
