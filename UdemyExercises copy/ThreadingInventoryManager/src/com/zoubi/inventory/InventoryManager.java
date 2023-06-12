package com.zoubi.inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

//works same as arraylist except it uses synchronize and for this it is a Thread safe collection
//when collection of data needs to be accessed by 2 threads, you need to use the below concurrent package, not 
//the java.util package
import java.util.concurrent.CopyOnWriteArrayList; 

public class InventoryManager {
	
	List<Product> soldProductsList = new CopyOnWriteArrayList<Product>();
	List<Product> purchasedProductsList = new ArrayList<Product>();
	
	Vector vector = new Vector();
	
	public void populateSoldProducts() {
		for(int i = 0; i <1000; i++) {
			Product prod = new Product(i, "Test_Product_" + i); 
			
			soldProductsList.add(prod);
			
			System.out.println("ADDED: " + prod);
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void displaySoldProducts() {
		for(Product product: soldProductsList) {
			System.out.println("PRINTING SOLD PRODUCTS: " + product);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
