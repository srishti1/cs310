package test;


import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.Vector;

import org.junit.*;
import org.omg.CORBA.PUBLIC_MEMBER;

import main.DestAndValue;
import main.FlightMap;
import main.VectorClass;

public class TestFlightMap {
	FlightMap flightMap;
	
	@Test
	public void testBuildGraph(){
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
	
	@Test
	public void testGetFlightList() {
		Vector<String> flights = new Vector<String>();
		flights.add("A");
		flights.add("A B 200");
		flights.add("B C 150");
		flightMap = new FlightMap(null);
		flightMap.setFlightList(flights);
		Vector<String> returnFlights = flightMap.getFlightList();
		assertEquals(flights,returnFlights);

	}
	
	@Test
	public void testGetCost() {
		flightMap = new FlightMap(null);
		Integer testInteger = 500;
		flightMap.setCost(testInteger);
		Integer returnCost=	flightMap.getCost();
		assertEquals(testInteger, returnCost);
			
	}
	
	@Test
	public void testGetEdgeTo() {
		flightMap = new FlightMap(null);
		Integer[] arr = new Integer[2];
		arr[0]=1;
		arr[1]=3;
		flightMap.setEdgeTo(arr);
		Integer[] returnArr = flightMap.getEdgeTo();
		assertEquals(arr[0], returnArr[0]);
		assertEquals(arr[1], returnArr[1]);
	
	}
	
	@Test
	public void testGetMarked() {
		flightMap = new FlightMap(null);
		boolean[] boolArr = new boolean[2];
		boolArr[0]=true;
		boolArr[1]=false;
		flightMap.setMarked(boolArr);
		boolean[] returnBoolArr = flightMap.getMarked();
		assertEquals(boolArr[0], returnBoolArr[0]);
		assertEquals(boolArr[1], returnBoolArr[1]);
	
	}
	@Test
	public void testGetAvailableId() {
		flightMap = new FlightMap(null);
		Integer id = 500;
		flightMap.setAvailableId(id);
		Integer returnId=	flightMap.getAvailableId();
		assertEquals(id, returnId);
			
	}
	

	@Test
	public void testGetCostFromDestination() {
		flightMap = new FlightMap(null);
		Vector<Integer> costVec = new Vector<Integer> ();
		costVec.add(1);
		costVec.add(2);
		flightMap.setCostFromDestination(costVec);
		Vector<Integer> returnCostVector = flightMap.getCostFromDestination();
		assertEquals(costVec.get(0), returnCostVector.get(0));
	
	}
	
	@Test
	public void testGetPathFromDestination() {
		flightMap = new FlightMap(null);
		Vector<String> pathVec = new Vector<String> ();
		pathVec.add("a");
		pathVec.add("b");
		flightMap.setPathFromDestination(pathVec);
		Vector<String> returnPathVector = flightMap.getPathFromDestination();
		assertEquals(pathVec.get(0), returnPathVector.get(0));
	
	}
	
	@Test
	public void testGetDestinationStrings() {
		flightMap = new FlightMap(null);
		Vector<String> destVec = new Vector<String> ();
		destVec.add("a");
		destVec.add("b");
		flightMap.setDestinationStrings(destVec);
		Vector<String> returnDestVector = flightMap.getDestinationStrings();
		assertEquals(destVec.get(0), returnDestVector.get(0));
	
	}
	
	@Test
	public void testGetReverseMapping() {
		flightMap = new FlightMap(null);
		HashMap<Integer, String> map= new HashMap<Integer, String>();  
		map.put(1, "a");
		flightMap.setReverseMapping(map);
		HashMap<Integer, String> returnMap = flightMap.getReverseMapping();
		assertEquals(map, returnMap);	
	}
	
	@Test
	public void testGetMapping() {
		flightMap = new FlightMap(null);
		HashMap<String, Integer > map= new HashMap<String, Integer>();  
		map.put( "a", 1);
		flightMap.setMapping(map);
		HashMap<String, Integer> returnMap = flightMap.getMapping();
		assertEquals(map, returnMap);	
	}
	
	@Test
	public void testGetListOfList() {
		flightMap = new FlightMap(null);
		ArrayList<ArrayList<DestAndValue>> ListOfList = new  ArrayList<ArrayList<DestAndValue>>();  
		DestAndValue dest1 = new DestAndValue(0, 200);
		DestAndValue dest2 = new DestAndValue(1, 300);
		ArrayList<DestAndValue> arr =new ArrayList<DestAndValue>();
		arr.add(dest1);
		arr.add(dest2);
		ListOfList.add(arr);
		flightMap.setListOfList(ListOfList);
		ArrayList<ArrayList<DestAndValue>> returnListOfList = flightMap.getListOfList();
		assertEquals(ListOfList, returnListOfList);
	
		
	}
}
