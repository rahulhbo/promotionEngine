package com.prmotioneng.services;


import com.prmotioneng.model.Cart;
import com.prmotioneng.model.ItemPrice;

public interface Promotion {
	
	 int priceDeductedAfterPromotion(Cart cart, ItemPrice itemPrice);

}
