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
	 
	 

}
