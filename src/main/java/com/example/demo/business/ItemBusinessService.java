package com.example.demo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.data.ItemRepository;
import com.example.demo.model.Item;


public class ItemBusinessService {
	
	@Autowired
	private ItemRepository repository;
	
	public Item retrieveHardcodedItem() {
		return new Item(1,"Ball",10,100);
	}
	
	public List<Item> retrieveAllItems() {
		
		List<Item> items =  repository.findAll();
		
		for(Item i : items) {
			i.setValue(i.getQuantity()*i.getPrice());
		}
		
		return items;
		
	}
	
	

}
