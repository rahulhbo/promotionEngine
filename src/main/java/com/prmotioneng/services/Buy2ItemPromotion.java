package com.prmotioneng.services;

import com.prmotioneng.model.Cart;
import com.prmotioneng.model.ItemPrice;
import com.prmotioneng.model.Item;

public class Buy2ItemPromotion implements Promotion {
	
	   Item offerItemA;
	    Item offerItemB;
	    int offerPrice;
	

	public Buy2ItemPromotion(Item offerItemA, Item offerItemB, int offerPrice) {
			super();
			this.offerItemA = offerItemA;
			this.offerItemB = offerItemB;
			this.offerPrice = offerPrice;
		}


	public Buy2ItemPromotion() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public int priceDeductedAfterPromotion(Cart cart, ItemPrice itemPrice) {
        if(cart.getItemsWithQuantity().containsKey(offerItemA) &&cart.getItemsWithQuantity().containsKey(offerItemB)) {
            int eligibleLot = Integer.min(cart.getItemsWithQuantity().get(offerItemA),
                    cart.getItemsWithQuantity().get(offerItemA));
            return (eligibleLot*itemPrice.getItemPerUnitPrice().get(offerItemA)) +
                    (eligibleLot*itemPrice.getItemPerUnitPrice().get(offerItemB)) - (eligibleLot*offerPrice);
        }
        else
            return 0;
    }

	
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((offerItemA == null) ? 0 : offerItemA.hashCode());
		result = prime * result + ((offerItemB == null) ? 0 : offerItemB.hashCode());
		result = prime * result + offerPrice;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Buy2ItemPromotion other = (Buy2ItemPromotion) obj;
		if (offerItemA == null) {
			if (other.offerItemA != null)
				return false;
		} else if (!offerItemA.equals(other.offerItemA))
			return false;
		if (offerItemB == null) {
			if (other.offerItemB != null)
				return false;
		} else if (!offerItemB.equals(other.offerItemB))
			return false;
		if (offerPrice != other.offerPrice)
			return false;
		return true;
	}


	public Item getOfferItemA() {
		return offerItemA;
	}


	public void setOfferItemA(Item offerItemA) {
		this.offerItemA = offerItemA;
	}


	public Item getOfferItemB() {
		return offerItemB;
	}


	public void setOfferItemB(Item offerItemB) {
		this.offerItemB = offerItemB;
	}


	public int getOfferPrice() {
		return offerPrice;
	}


	public void setOfferPrice(int offerPrice) {
		this.offerPrice = offerPrice;
	}


	@Override
	public String toString() {
		return "Buy2ItemPromotion [offerItemA=" + offerItemA + ", offerItemB=" + offerItemB + ", offerPrice="
				+ offerPrice + "]";
	}
	
	
	
	
	
	

}
