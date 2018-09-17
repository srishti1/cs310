package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;
import java.util.Vector;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import main.FlightMap;
import main.VectorClass;

class TestFlightMap {
	FlightMap flightMap;
	
	@Test
	void testBuildGraph(){
		Vector<String> flights = new Vector<String>();
		flights.add("A");
		flights.add("A B 200");
		flights.add("B C 150");
		flightMap = new FlightMap(flights);
		VectorClass vectorClass =   flightMap.BuildGraph();
		String path ="AB";
		assertEquals(new Integer(200), vectorClass.getCostFromDestination().get(0));
		assertEquals(path, vectorClass.getPathFromDestination().get(0));
		assertEquals("B", vectorClass.getDestinationStrings().get(0));
		assertEquals(new Integer(350), vectorClass.getCostFromDestination().get(1));
		assertEquals("ABC", vectorClass.getPathFromDestination().get(1));
		assertEquals("C", vectorClass.getDestinationStrings().get(1));
	}

}
