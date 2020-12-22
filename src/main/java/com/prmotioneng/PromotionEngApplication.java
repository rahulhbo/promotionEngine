package com.prmotioneng;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.prmotioneng.exception.InvalidCardException;
import com.prmotioneng.model.Cart;
import com.prmotioneng.model.Item;
import com.prmotioneng.model.ItemPrice;
import com.prmotioneng.services.Buy2ItemPromotion;
import com.prmotioneng.services.BuyNPromotionService;
import com.prmotioneng.services.CartServiceImpl;
import com.prmotioneng.services.Promotion;

@SpringBootApplication
public class PromotionEngApplication {
	
	static CartServiceImpl cartService;
   static  Map<Character, Item> items;
   static  ItemPrice itemPrice;
    
    
    
    public PromotionEngApplication() {
    	//Add new product type 
    	 items = new HashMap<>();
         items.put('A', new Item('A'));
         items.put('B', new Item('B'));
         items.put('C', new Item('C'));
         items.put('D', new Item('D'));

         cartService = CartServiceImpl.getCartServiceInstance();
         Map<Item, Integer> itemPerUnit = new HashMap<>();
         itemPerUnit.put(items.get('A'), 50);
         itemPerUnit.put(items.get('B'), 30);
         itemPerUnit.put(items.get('C'), 20);
         itemPerUnit.put(items.get('D'), 15);
         itemPrice = new ItemPrice(itemPerUnit);
         
	}
    

   
	/*
	 * itemsWithQuantity.put(items.get('A'), 1);
	 * itemsWithQuantity.put(items.get('B'), 1);
	 * itemsWithQuantity.put(items.get('C'), 1);
	 */

    //Cart cart = new Cart(itemsWithQuantity);

    
    
	public static void main(String[] args) throws InvalidCardException, IOException {
		SpringApplication.run(PromotionEngApplication.class, args);
		
		 Map<Item, Integer> itemsWithQuantity = new HashMap<>();
		
		 BufferedReader reader =  
                 new BufferedReader(new InputStreamReader(System.in)); 
		 System.out.println("Please enter the productes type A,B,C & D & there "
		 		+ "Qty in below formet  ");
		 
		 System.out.println("A 5,B 5,C 1");
			  
		
       
    
      String s = reader.readLine(); 
		 
		
			String [] arr= s.trim().replaceAll("\\s"," ").split(",");
			
			
		        for(int i=0;i<arr.length;i++)
		        {
		        	String[] itemVal=arr[i].split(" ");
		
		        	
		        itemsWithQuantity.put(items.get(itemVal[0].charAt(0)), Integer.valueOf(itemVal[1]));
		
	       
		        }
		 
		
		Cart cart = new Cart(itemsWithQuantity);
		
		 ArrayList<Promotion> promotions = new ArrayList<>();
	        promotions.add(new BuyNPromotionService(items.get('A'), 3, 130));
	        promotions.add(new BuyNPromotionService(items.get('B'), 2, 45));
	        promotions.add(new Buy2ItemPromotion(items.get('C'), items.get('D'), 30));
		
		System.out.println("Total Price :"+cartService.getCartPriceWithPromotion(cart, itemPrice,promotions));
		
		
	}

}
