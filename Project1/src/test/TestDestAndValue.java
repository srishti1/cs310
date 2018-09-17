package test;

import main.DestAndValue;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import org.omg.CORBA.PUBLIC_MEMBER;

import main.FlightMap;
import main.VectorClass;


public class TestDestAndValue {
	DestAndValue tester;
	
	
	@Test
	public void testGetDestination() {
		DestAndValue tester = new DestAndValue(0, 200);
		Integer expected =0;
		Integer a = 200;
		assertEquals(expected, tester.getDestination());
		assertEquals(a, tester.getValue());
	}
	
	@Test
	public void testGetValue() {
		tester = new DestAndValue(0, 300);
		tester.setValue(500);
		Integer expected = 500;
		assertEquals(expected, tester.getValue());
		
	}

}
