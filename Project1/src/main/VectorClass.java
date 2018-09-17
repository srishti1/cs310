package main;
import java.util.Vector;

public class VectorClass {
	Vector<String> DestinationStrings = new Vector<String>();
	Vector<String> PathFromDestination = new Vector<String>();
	Vector<Integer> CostFromDestination = new Vector<Integer>();
	
	public Vector<String> getDestinationStrings() {
		return DestinationStrings;
	}
	public void setDestinationStrings(Vector<String> destinationStrings) {
		DestinationStrings = destinationStrings;
	}
	public Vector<String> getPathFromDestination() {
		return PathFromDestination;
	}
	public void setPathFromDestination(Vector<String> pathFromDestination) {
		PathFromDestination = pathFromDestination;
	}
	public Vector<Integer> getCostFromDestination() {
		return CostFromDestination;
	}
	public void setCostFromDestination(Vector<Integer> costFromDestination) {
		CostFromDestination = costFromDestination;
	}
	
	

}
