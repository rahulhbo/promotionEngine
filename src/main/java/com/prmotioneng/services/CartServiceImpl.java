package com.prmotioneng.services;

import com.prmotioneng.model.Cart;
import com.prmotioneng.model.Item;
import com.prmotioneng.model.ItemPrice;
import com.prmotioneng.exception.InvalidCardException;
import java.util.*;

public class CartServiceImpl {
	
	 private static CartServiceImpl cartServiceImpl = null;

	    public static CartServiceImpl getCartServiceInstance(){
	        if(cartServiceImpl == null)
	        	cartServiceImpl = new CartServiceImpl();
	        return cartServiceImpl;
	    }
	    
	    
	    public int getCartPrice(Cart cart, ItemPrice itemPrice) throws InvalidCardException {
	        if(cart == null || itemPrice == null)
	            throw new InvalidCardException("Cart or ItemPrice is not valid");

	        int totalPriceWithoutPromotion = 0;
	        for(Map.Entry<Item, Integer> cartItem: cart.getItemsWithQuantity().entrySet()){
	            totalPriceWithoutPromotion =
	                    totalPriceWithoutPromotion + (itemPrice.getItemPerUnitPrice().get(cartItem.getKey()))*(cartItem.getValue());
	        }

	        return totalPriceWithoutPromotion;
	    }


	    public int getCartPriceWithPromotion(Cart cart, ItemPrice itemPrice, ArrayList<Promotion> promotions) throws InvalidCardException {

	        int totalPrice = getCartPrice(cart, itemPrice);
	        if(promotions == null || promotions.size() == 0)
	            return totalPrice;
	        for(Promotion promotion: promotions){
	            totalPrice = totalPrice - promotion.priceDeductedAfterPromotion(cart, itemPrice);
	        }
	        return totalPrice;
	    }
	    
	    
	
	

}
