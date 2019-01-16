package com.hniu.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BatchBuyBook {
	@Autowired
	private ShopService shopService;
	
	@Transactional
	public void batchBuy(){
		int [] i = new int[]{1,2};
		for(int x:i){
			shopService.start(x,8);
		}	
	}
}
