package test;

import org.junit.*;
import org.omg.CORBA.PUBLIC_MEMBER;

import main.FlightMap;
import main.VectorClass;

import static org.junit.Assert.assertEquals;

import java.util.Stack;
import java.util.Vector;
import org.junit.Assert;


import main.VectorClass;

public  class TestVectorClass {
	private static final String AssertionError = null;
	VectorClass vec;

	@Test
	public void testCostFromDestination() {
		vec = new VectorClass();
		Vector<Integer> costVec = new Vector<Integer> ();
		costVec.add(1);
		costVec.add(2);
		vec.setCostFromDestination(costVec);
		assertEquals(costVec.get(0), vec.getCostFromDestination().get(0));
	
	}

	@Test
	public  void testGetPathFromDestination() {
		vec = new VectorClass();
		Vector<String> pathFromDest = new Vector<String>();
		pathFromDest.add("ABC");
		pathFromDest.add("EFG");
		vec.setPathFromDestination(pathFromDest);
		//assertIterableEquals(pathFromDest, vec.getPathFromDestination());
		assertEquals(pathFromDest.get(0), vec.getPathFromDestination().get(0));

	}
	
	@Test
	public void testGetDestinationStrings() {
		vec = new VectorClass();
		Vector<String> destStrings = new Vector<String> ();
		destStrings.add("ABC");
		destStrings.add("EFG");
		vec.setDestinationStrings(destStrings);
		assertEquals(destStrings.get(0), vec.getDestinationStrings().get(0));
		
	}	

}
