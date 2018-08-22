package com.example.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.demo.business.ItemBusinessService;
import com.example.demo.model.Item;

@RunWith(SpringRunner.class)
@WebMvcTest(ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ItemBusinessService businessService;

	@Test
	public void dummyItem_basicTest() throws Exception {
		RequestBuilder request = MockMvcRequestBuilders.get("/dummy-item").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"Ball\",\"price\":10,\"quantity\":100}")).andReturn();

		// assertEquals("hello-world", result.getResponse().getContentAsString());

	}

	@Test
	public void itemForBusinessService_basicTest() throws Exception {

		when(businessService.retrieveHardcodedItem()).thenReturn(new Item(2, "item2", 1, 1));

		RequestBuilder request = MockMvcRequestBuilders.get("/item-from-business-service")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{id:2,name:item2,price:1,quantity:1}")).andReturn();

	}

	@Test
	public void itemForBusinessService_allItemsFromDatabase() throws Exception {

		when(businessService.retrieveAllItems()).thenReturn(Arrays.asList(new Item(2, "item2", 1, 1),new Item(3, "item3", 10, 10)));

		RequestBuilder request = MockMvcRequestBuilders.get("/all-items-from-database")
				.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("[{id:2,name:item2,price:1,quantity:1},{id:3,name:item3,price:10,quantity:10}]")).andReturn();

	}

}
