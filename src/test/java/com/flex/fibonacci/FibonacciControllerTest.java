package com.flex.fibonacci;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FibonacciControllerTest {

	@Autowired
	private FibonacciController controller;

	/**
	 * Setup the tests to start at the 13th index of the Fibonacci sequence
	 */
	@BeforeAll
	void setup() {
		Integer count = 12;
		while (count > 0) {
			controller.next();
			count--;
		}
	}

	/**
	 * Confirm that the current method returns the 13th value in the Fibonacci sequence
	 * as setup by the setup method
	 * 
	 * This test will always run first
	 * @throws Exception
	 */
	@Test
	@Order(1)
	void currentTest() throws Exception {
		assertThat(controller.current()).isEqualTo(144.0);
	}

	/**
	 * Confirm that the current method returns the 14th value in the Fibonacci sequence
	 * as setup by the setup method
	 * 
	 * This test will always run second
	 * @throws Exception
	 */
	@Test
	@Order(2)
	void nextTest() throws Exception {
		assertThat(controller.next()).isEqualTo(233.0);
	}

	/**
	 * Confirm that the previous method returns the 12th value in the Fibonacci sequence
	 * after being called twice from the 14th index as setup by the setup method followed by
	 * one call to the next method in the second test
	 * 
	 * This test will always run third
	 * @throws Exception
	 */
	@Test
	@Order(3)
	void previousTest() throws Exception {
		controller.previous();
		assertThat(controller.previous()).isEqualTo(89.0);
	}

}
