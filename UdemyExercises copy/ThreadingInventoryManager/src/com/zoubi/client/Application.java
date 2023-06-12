package com.zoubi.client;

import com.zoubi.inventory.InventoryManager;

public class Application {

	public static void main(String[] args) throws InterruptedException {
		InventoryManager manager = new InventoryManager();
		
		Thread inventoryTask = new Thread(new Runnable() {

			@Override
			public void run() {
				manager.populateSoldProducts();
				
			}
			
			
		});
		
		
		Thread displayTask = new Thread(new Runnable() {

			@Override
			public void run() {
				manager.displaySoldProducts();
				
			}
			
			
		});
		
		inventoryTask.start();
		//this will wait here until inventoryTask() is completed. This is sequential, not multi-threading
		//inventoryTask.join();
		
		Thread.sleep(2000);
		displayTask.start();

	}

}
