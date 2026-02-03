package com.devsecops.calculator;

import com.devsecops.calculator.service.CalculatorService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

	CalculatorService service = new CalculatorService();

	@Test
	void testAdd() {
		assertEquals(10, service.add(5, 5));
	}

	@Test
	void testSubtract() {
		assertEquals(5, service.subtract(10, 5));
	}
}
