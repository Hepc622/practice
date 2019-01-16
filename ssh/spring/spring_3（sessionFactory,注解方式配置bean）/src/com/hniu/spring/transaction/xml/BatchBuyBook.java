package com.hniu.spring.transaction.xml;


public class BatchBuyBook {
	private ShopService shopService;
	
	public void batchBuy(){
		int [] i = new int[]{1,2};
		for(int x:i){
			shopService.start(x,8);
		}	
	}
}
