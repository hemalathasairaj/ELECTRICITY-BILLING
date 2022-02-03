package com.mph.testcase;

import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import com.mph.controller.CustomerRestController;

public class CustomerControllerTest {

	CustomerRestController customerRestController;
	@Rule
	public ExpectedException exception = ExpectedException.none();
	@Before
	public void setUp() {
		System.out.println("@Before called");
		customerRestController = new CustomerRestController();
	}
	
}
