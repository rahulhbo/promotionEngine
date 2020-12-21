package com.prmotioneng.model;

import java.util.*;

public class Cart {
	 private Map<Item, Integer> itemsWithQuantity;
	 
	 

	public Cart(Map<Item, Integer> itemsWithQuantity) {
		super();
		this.itemsWithQuantity = itemsWithQuantity;
	}
	
	
	

	public Map<Item, Integer> getItemsWithQuantity() {
		return itemsWithQuantity;
	}

	public void setItemsWithQuantity(Map<Item, Integer> itemsWithQuantity) {
		this.itemsWithQuantity = itemsWithQuantity;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemsWithQuantity == null) ? 0 : itemsWithQuantity.hashCode());
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
		Cart other = (Cart) obj;
		if (itemsWithQuantity == null) {
			if (other.itemsWithQuantity != null)
				return false;
		} else if (!itemsWithQuantity.equals(other.itemsWithQuantity))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "Cart [itemsWithQuantity=" + itemsWithQuantity + "]";
	}
	 
	
	
	
	 

}
