package com.example.demo.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations= {"classpath:test-configuration.properties"})
public class CustomerTestPropertyTest {
	
	@Value("${test.name}")
	private String name;
	 
	@Test
	public void test_customProperty() {
		assertEquals("mpriyank",name);
	}
	
	
	
	

}
