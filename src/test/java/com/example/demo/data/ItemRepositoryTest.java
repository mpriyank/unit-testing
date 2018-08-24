package com.example.demo.data;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.model.Item;



@RunWith(SpringRunner.class)
@DataJpaTest //important for testing the repository class
public class ItemRepositoryTest {
	
	@Autowired
	ItemRepository repository;
	
	@Test
	public void test_findAll() {
		
		List<Item> list =  repository.findAll();
		
		Assert.assertEquals(5,list.size() );
	}
	
	

}
