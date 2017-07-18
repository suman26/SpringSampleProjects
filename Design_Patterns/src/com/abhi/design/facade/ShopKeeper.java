package com.abhi.design.facade;

public class ShopKeeper {
	MobileShop nokia;
	MobileShop samsung;
	MobileShop iphone;
	public ShopKeeper() {
		nokia=new Nokia();
		samsung=new Samsung();
		iphone=new Iphone();
	}
	public void iphoneSale(){  
        iphone.modelNo();  
        iphone.price();  
    }  
        public void samsungSale(){  
        samsung.modelNo();  
        samsung.price();  
    }
        
        public void nokiaSale(){  
            nokia.modelNo();  
            nokia.price();  
        }
            
	
	

}
