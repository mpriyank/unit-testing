package com.example.demo.spike;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class JsonPathTest {
	
	@Test
	public void learning() {
		
		String responseFromService = "[" + 
				"{\"id\":10001,\"name\":\"pen\",\"quantity\":10}," + 
				"{\"id\":10002,\"name\":\"pencil\",\"quantity\":120}," + 
				"{\"id\":10003,\"name\":\"eraser\",\"quantity\":20}" + 
				"]";
		
		DocumentContext context = JsonPath.parse(responseFromService);
		
		int length = context.read("$.length()");
		assertThat(length).isEqualTo(3);
		
		List<Integer> ids = context.read("$..id");
		assertThat(ids).containsExactly(10001,10002,10003);
		
		System.out.println(context.read("$.[1]").toString());//prints with index-1
		System.out.println(context.read("$.[1:3]").toString());
		System.out.println(context.read("$.[?(@.name=='eraser')]").toString());
		System.out.println(context.read("$.[?(@.name=='eraser')].id").toString());
		System.out.println(context.read("$.[?(@.quantity==5)]").toString());
		System.out.println(context.read("$.[?(@.quantity==10)]").toString());
		
	}

}
