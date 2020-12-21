package com.prmotioneng.services;

import com.prmotioneng.model.Cart;
import com.prmotioneng.model.Item;
import com.prmotioneng.model.ItemPrice;

public class BuyNPromotionService implements Promotion {
	
	
    Item item;
    int offerQuantity;
    int offerPrice;


	


	public BuyNPromotionService() {
		super();
		// TODO Auto-generated constructor stub
	}





	public BuyNPromotionService(Item item, int offerQuantity, int offerPrice) {
		super();
		this.item = item;
		this.offerQuantity = offerQuantity;
		this.offerPrice = offerPrice;
	}




	@Override
	public int priceDeductedAfterPromotion(Cart cart, ItemPrice itemPrice) {

        if(cart.getItemsWithQuantity().containsKey(item)){
            int itemQuantity =  cart.getItemsWithQuantity().get(item);
            int totalEligibleLot = (itemQuantity/offerQuantity);
            return  ((totalEligibleLot*offerQuantity*itemPrice.getItemPerUnitPrice().get(item))- 
            		(totalEligibleLot*offerPrice));
        }
        else{
            return 0;
        }
    
	}





	public Item getItem() {
		return item;
	}





	public void setItem(Item item) {
		this.item = item;
	}





	public int getOfferQuantity() {
		return offerQuantity;
	}





	public void setOfferQuantity(int offerQuantity) {
		this.offerQuantity = offerQuantity;
	}





	public int getOfferPrice() {
		return offerPrice;
	}





	public void setOfferPrice(int offerPrice) {
		this.offerPrice = offerPrice;
	}





	@Override
	public String toString() {
		return "BuyNPromotionService [item=" + item + ", offerQuantity=" + offerQuantity + ", offerPrice=" + offerPrice
				+ "]";
	}
	
	
	
	
	
	

}
