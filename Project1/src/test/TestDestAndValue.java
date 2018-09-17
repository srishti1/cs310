package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.DestAndValue;

class TestDestAndValue {
	DestAndValue tester;
	
	
	@Test
	void testGetDestination() {
		DestAndValue tester = new DestAndValue(0, 200);
		Integer expected =0;
		Integer a = 200;
		assertEquals(expected, tester.getDestination());
		assertEquals(a, tester.getValue());
	}
	
	@Test
	void testGetValue() {
		tester = new DestAndValue(0, 300);
		tester.setValue(500);
		Integer expected = 500;
		assertEquals(expected, tester.getValue());
		
	}

}
