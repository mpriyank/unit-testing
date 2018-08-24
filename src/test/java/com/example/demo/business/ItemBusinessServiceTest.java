package com.example.demo.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.example.demo.data.ItemRepository;
import com.example.demo.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemBusinessServiceTest {

	@InjectMocks
	ItemBusinessService business;

	@Mock
	ItemRepository repository;

	@Test
	public void retrieveAllItems_basic() {
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2, "item2", 1, 1), new Item(3, "item3", 10, 10)));

		List<Item> items = business.retrieveAllItems();

		//assertEquals(100, items.get(0).getValue());
		//assertEquals(400, items.get(1).getValue());
	}

}
