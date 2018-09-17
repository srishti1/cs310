package main;
import java.util.Vector;

/**
* Stores three vectors used to generate output
*/
public class VectorClass {
	Vector<String> DestinationStrings = new Vector<String>();
	Vector<String> PathFromDestination = new Vector<String>();
	Vector<Integer> CostFromDestination = new Vector<Integer>();
	
	
	
	/**
	* getter that returns the vector that contains all destinations
	*/
	public Vector<String> getDestinationStrings() {
		return DestinationStrings;
	}
	/**
	* setter that stores the vector that contains all destinations
	*/
	public void setDestinationStrings(Vector<String> destinationStrings) {
		DestinationStrings = destinationStrings;
	}
	
	/**
	* getter that returns the vector that contains all paths to destinations
	*/
	public Vector<String> getPathFromDestination() {
		return PathFromDestination;
	}
	/**
	* setter that stores the vector that contains all paths to destinations
	*/
	public void setPathFromDestination(Vector<String> pathFromDestination) {
		PathFromDestination = pathFromDestination;
	}
	/**
	* getter that returns the vector that contains all cost of paths
	*/
	public Vector<Integer> getCostFromDestination() {
		return CostFromDestination;
	}
	/**
	* setter that stores the vector that contains all cost of paths
	*/
	public void setCostFromDestination(Vector<Integer> costFromDestination) {
		CostFromDestination = costFromDestination;
	}
	
	

}
