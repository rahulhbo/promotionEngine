package com.prmotioneng.model;

import java.util.*;

public class ItemPrice {
	
	private Map<Item, Integer> itemPerUnitPrice;

	
	
	
	public ItemPrice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemPrice(Map<Item, Integer> itemPerUnitPrice) {
		super();
		this.itemPerUnitPrice = itemPerUnitPrice;
	}
	
	

	public Map<Item, Integer> getItemPerUnitPrice() {
		return itemPerUnitPrice;
	}

	public void setItemPerUnitPrice(Map<Item, Integer> itemPerUnitPrice) {
		this.itemPerUnitPrice = itemPerUnitPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemPerUnitPrice == null) ? 0 : itemPerUnitPrice.hashCode());
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
		ItemPrice other = (ItemPrice) obj;
		if (itemPerUnitPrice == null) {
			if (other.itemPerUnitPrice != null)
				return false;
		} else if (!itemPerUnitPrice.equals(other.itemPerUnitPrice))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ItemPrice [itemPerUnitPrice=" + itemPerUnitPrice + "]";
	}
	
	
	

}
