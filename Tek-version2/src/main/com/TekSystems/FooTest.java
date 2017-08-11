package com.tek.interview.question;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest extends calculate {

	private calculate calculate;

	@Before
	public void setUp() throws Exception {
		calculate = new calculator();
	}

	@After
	public void tearDown() throws Exception {
		calculate = null;
	}

	@Test
	public void testCalculate() throws Exception {
		Map<String, Order> order1 = new HashMap<String, Order>();

		Order new = new Order();

		new.add(new OrderLine(new Item("book",  10), 1));
		new.add(new OrderLine(new Item("music CD",  10), 1));
		new.add(new OrderLine(new Item("chocolate bar",  10), 1));

		order1.put("Order 1", new);
		
		double totalPrice = calculate.calculate(order1);
		assertEquals("Expected result is not returned",33.00, totalPrice,.01);
		
	}

	@Test
	public void salesTax()  throws Exception{
		double tax = calculate.salesTax(new OrderLine(new Item("book",  10), 1));
		assertEquals("Expected result is not returned",1.00, tax,.00);
		
		tax = calculate.salesTax(new OrderLine(new Item("new book",  10), 1));
		assertEquals("Expected result is returned",1.50, tax,.00);
		
		tax = calculate.salesTax(new OrderLine(new Item("new book",  10), 3));
		assertEquals("Expected result is not returned",4.50, tax,.00);
	}
}