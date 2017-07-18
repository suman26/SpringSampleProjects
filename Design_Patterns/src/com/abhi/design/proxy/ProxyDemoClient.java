package com.abhi.design.proxy;

public class ProxyDemoClient {

	public static void main(String[] args) {
		
		OfficeInternetAccess access=new ProxyInternetAccess("Abhi");
		access.grantInternetAccess();
	}

}
