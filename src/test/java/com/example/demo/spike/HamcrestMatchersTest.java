package com.example.demo.spike;





import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class HamcrestMatchersTest {

	@Test
	public void learning() {
		List<Integer> numbers = Arrays.asList(11,22,33);
		
		assertThat(numbers , hasItems(11,22,33));
		
		
	}
	
}
