import java.util.*;


//	 The FlightMap class, implemented in FlightMap.java, 
//	 stores a map and provides operations that facilitate a search of 
//   the map.

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
	public VectorClass BuildGraph() {                                   
		ListOfList = new ArrayList<ArrayList<DestAndValue>>();
		mapping  = new HashMap<String,Integer>();
		reverseMapping = new HashMap<Integer, String>();
		String origin = FlightList.get(0);
		createCity(FlightList.get(0)); //origin city
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
	private String reverse(String word) {
	    char[] chs = word.toCharArray();

	    int i=0, j=chs.length-1;
	    while (i < j) {
	        char t = chs[i];
	        chs[i] = chs[j];
	        chs[j] = t;
	       i++; j--;
	    }
	    return String.valueOf(chs);
	}
	private void Dfs(Integer start) {	
		marked[start]=true;		//marked[0]=true;
		
		for(DestAndValue i: ListOfList.get(start)) {
			
			if(!marked[i.getDestination()]) {	
				edgeTo[i.getDestination()]= start;
				Dfs(i.getDestination());
				
			}
			
		}
		
		
	}
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
	
	private void createFlight(String city1, String city2, int value) {
		//get both indexes
        int index1 = mapping.get(city1);
        int index2 = mapping.get(city2);
        DestAndValue dv = new DestAndValue(index2, value);

        //add index2 into the arraylist of index1 
        ListOfList.get(index1).add(dv);
		
	}
	private Integer getFlightValue(String city1, String city2) {
		Integer index1 = mapping.get(city1);
        Integer index2 = mapping.get(city2);
        ArrayList<DestAndValue> arr= ListOfList.get(index1);
        Integer access=null;
        for(Integer i=0; i<arr.size(); i++) {
        	   
        	   if(arr.get(i).getDestination().equals(index2)) {access =i;}
        }
        return arr.get(access).getValue();
		
	}

//    public static void printList()
//    {
//        for(String city : mapping.keySet()) {
//            int index = mapping.get(city);
//            System.out.println(city+" ID: "+index+" List: ");
//            for (int i = 0; i < ListOfList.get(index).size(); i++) {
//				System.out.println(ListOfList.get(index).get(i).getDestination()+" , "+ ListOfList.get(index).get(i).getValue());
//			//}+ListOfList.get(index).getDestination());
//            }
//        }
//    }
    
    	
}
