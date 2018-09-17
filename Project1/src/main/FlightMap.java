package main;
import java.util.*;


//	 The FlightMap class, implemented in FlightMap.java, 
//	 stores a map and has functions that facilitate a search of 
//   the map.
/**
*  The FlightMap class, implemented in FlightMap.java, 
*   stores a map and has functions which gives  access to required information about the map
*/
public class FlightMap {
	static HashMap<String,Integer> mapping;     //member variables
	HashMap<Integer, String> reverseMapping;
	static ArrayList<ArrayList<DestAndValue>> ListOfList;
	Vector<String> destinationStrings;
	Vector<String> pathFromDestination;
	Vector<Integer> costFromDestination;
	int availableId=0; 
	boolean[] marked;
	Integer[] edgeTo;
	Integer cost=0;
	Vector<String> FlightList = new Vector<>();
	
	public FlightMap(Vector<String> flights) {    //constructor
		FlightList= flights;	
	}
	/**
	* returns three vectors which holds destinations, path and cost which are used to generate output
	*/
	public VectorClass BuildGraph() {   
		
		ListOfList = new ArrayList<ArrayList<DestAndValue>>();
		mapping  = new HashMap<String,Integer>();
		reverseMapping = new HashMap<Integer, String>();
		String origin = FlightList.get(0);
		createCity(FlightList.get(0));
		int value =0;
		for (int i = 1; i < FlightList.size(); i++) {
			String s= FlightList.get(i);
			String[] words = s.split("[\\s']");
			for (int j = 0; j < words.length; j++) {
				words[j] = words[j].replaceAll("[^\\w]", "");
			}
			value  = Integer.parseInt(words[2]);
			createCity(words[0]);
			createCity(words[1]);
			createFlight(words[0], words[1],value );
			
		}
		return runDfs(origin);
	
		
	}
	/**
	* calls a recursive function which finds path for all unvisited nodes
	*/
	private VectorClass runDfs(String origin) {
		destinationStrings = new Vector<String>();
		pathFromDestination = new Vector<String>();
		costFromDestination = new Vector<Integer>();
		marked = new boolean[availableId];
		edgeTo = new Integer[availableId];
		
		Integer originIndex = mapping.get(origin);
		//System.out.println(originIndex);
		Dfs(originIndex);
		String pathway="";
		 for(String city : mapping.keySet()) {
	            int index = mapping.get(city);
	            if( marked[index]==true && index!= originIndex) {
//		            	 System.out.println(reverseMapping.get(originIndex)+" to " + reverseMapping.get(index)+ " :");
		            	 destinationStrings.add(reverseMapping.get(index));
		            	 pathway="";
		            	 for(int i: pathTo(index, originIndex)) {
		       
		            		 pathway+=reverseMapping.get(i);

		            	 } 
		            	 pathway=reverse(pathway);

		            	 pathFromDestination.add(pathway);
		            	 costFromDestination.add(cost);
		            	 
		            	 
	            }
       
	        }
		 VectorClass vectorClass = new VectorClass();
	    	 vectorClass.setDestinationStrings(destinationStrings);
	    	 vectorClass.setPathFromDestination(pathFromDestination);
	    	 vectorClass.setCostFromDestination(costFromDestination);
	    	 return vectorClass;
	}
	/**
	* reverses the string, used to display path in correct order
	*/
	private String reverse(String word) {
	    char[] chs = word.toCharArray();
//reverses the path to get them in right order
	    int i=0, j=chs.length-1;
	    while (i < j) {
	        char t = chs[i];
	        chs[i] = chs[j];
	        chs[j] = t;
	       i++; j--;
	    }
	    return String.valueOf(chs);
	}
	/**
	* recursive function which finds path from a given node to unvisited nodes
	*/
	private void Dfs(Integer start) {	
		marked[start]=true;		//marked[0]=true;
		
		for(DestAndValue i: ListOfList.get(start)) {
			
			if(!marked[i.getDestination()]) {	
				edgeTo[i.getDestination()]= start;
				Dfs(i.getDestination());
				
			}
			
		}
		
		
	}
	/**
	* returns stack with path from origin city to the given city
	*/
	
	private 	Stack<Integer> pathTo(int index, int originIndex ) {
		cost=0;
		if(!marked[index]) {return null;}
	    	Stack<Integer> path = new Stack<Integer>();
	    	//Stack<Integer> cost= new Stack<Integer>();
	    	for(int x = index; x!= originIndex; x= edgeTo[x]) {
	    		path.push(x);    
	    		cost+= getFlightValue(reverseMapping.get(edgeTo[x]), reverseMapping.get(x) );	    		
	    	}
	    	path.push(originIndex);
		return path;
	}

	/**
	* creates a node for each city in the graph
	*/
	
	private void createCity(String city) {
		 if(!mapping.containsKey(city))
	        {  
	            //assign available ID
	            mapping.put(city,availableId);
	            reverseMapping.put(availableId, city);
	            availableId++;                                //make increment in available id
	            ListOfList.add(new ArrayList<DestAndValue>());     //Add an Empty ArrayList
	        }
		
	}
	/**
	* creates an edge between two nodes in graph and stores the cost
	*/
	private void createFlight(String city1, String city2, int value) {
		//get both indexes
        int index1 = mapping.get(city1);
        int index2 = mapping.get(city2);
        DestAndValue dv = new DestAndValue(index2, value);

        //add index2 into the arraylist of index1 
        ListOfList.get(index1).add(dv);
		
	}
	/**
	* returns the cost of the edge between two nodes
	*/
	private Integer getFlightValue(String city1, String city2) {
		//gets the cost of flight
		Integer index1 = mapping.get(city1);
        Integer index2 = mapping.get(city2);
        ArrayList<DestAndValue> arr= ListOfList.get(index1);
        Integer access=null;
        for(Integer i=0; i<arr.size(); i++) {
        	   
        	   if(arr.get(i).getDestination().equals(index2)) {access =i;}
        }
        return arr.get(access).getValue();
		
	}
	
	
	
	//Getters and setters for class variables 
	/**
	* getter for a HashMap
	*/
	public static HashMap<String, Integer> getMapping() {
		return mapping;
	}
	/**
	* setter for a HashMap
	*/
	public static void setMapping(HashMap<String, Integer> mapping) {
		FlightMap.mapping = mapping;
	}
	/**
	* getter for a HashMap which stores reverse of directed edges in map
	*/
	public HashMap<Integer, String> getReverseMapping() {
		return reverseMapping;
	}
	/**
	* setter for a HashMap which stores reverse of directed edges in map
	*/
	public void setReverseMapping(HashMap<Integer, String> reverseMapping) {
		this.reverseMapping = reverseMapping;
	}
	
	/**
	* getter for graph stored in Adjacency list
	*/
	public static ArrayList<ArrayList<DestAndValue>> getListOfList() {
		return ListOfList;
	}
	/**
	* setter for graph stored in Adjacency list
	*/
	public static void setListOfList(ArrayList<ArrayList<DestAndValue>> listOfList) {
		ListOfList = listOfList;
	}
	
	/**
	* getter for list that stores all destinations
	*/
	public Vector<String> getDestinationStrings() {
		return destinationStrings;
	}
	/**
	* setter for list that stores all destinations
	*/
	public void setDestinationStrings(Vector<String> destinationStrings) {
		this.destinationStrings = destinationStrings;
	}
	
	/**
	* getter for list that stores all paths to destinations
	*/
	public Vector<String> getPathFromDestination() {
		return pathFromDestination;
	}
	
	/**
	* setter for list that stores all paths to destinations
	*/
	public void setPathFromDestination(Vector<String> pathFromDestination) {
		this.pathFromDestination = pathFromDestination;
	}
	
	/**
	* getter for list that stores all costs of paths 
	*/
	public Vector<Integer> getCostFromDestination() {
		return costFromDestination;
	}
	/**
	* setter for list that stores all costs of paths 
	*/
	public void setCostFromDestination(Vector<Integer> costFromDestination) {
		this.costFromDestination = costFromDestination;
	}
	
	/**
	* returns largest available id used to represent a node 
	*/
	public int getAvailableId() {
		return availableId;
	}
	/**
	* stores largest available id used to represent a node 
	*/
	public void setAvailableId(int availableId) {
		this.availableId = availableId;
	}
	
	/**
	* getter for array that stores if node has a path
	*/
	public boolean[] getMarked() {
		return marked;
	}
	/**
	* setter for array that stores if node has a path
	*/
	public void setMarked(boolean[] marked) {
		this.marked = marked;
	}
	
	/**
	* getter for array that stores a node's previous node in path
	*/
	public Integer[] getEdgeTo() {
		return edgeTo;
	}
	
	/**
	* setter for array that stores a node's previous node in path
	*/
	public void setEdgeTo(Integer[] edgeTo) {
		this.edgeTo = edgeTo;
	}
	
	/**
	* getter for cost variable
	*/
	public Integer getCost() {
		return cost;
	}
	/**
	* setter for cost variable
	*/
	public void setCost(Integer cost) {
		this.cost = cost;
	}
	
	/**
	* getter for list of all flights
	*/
	public Vector<String> getFlightList() {
		return FlightList;
	}
	
	/**
	* setter for list of all flights
	*/
	public void setFlightList(Vector<String> flightList) {
		FlightList = flightList;
	}

    	
}
