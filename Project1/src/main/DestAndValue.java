package main;
/**
* Stores the destination and the value of the flight to the destination from a given flight
*/
public class DestAndValue {
	int Destination;
	int Value;
	
	public DestAndValue(int dest, int val) {
		Destination = dest;
		Value = val;
	}
	
	/**
	* getter that returns the destination for an object that stores destination and value
	*/
	public Integer getDestination() {
		return Destination;
		//getter for destination
	}

	/**
	* setter that stores the destination for an object that stores destination and value
	*/
	public void setDestination(int destination) {
		Destination = destination;
		//setter for destination
	}

	/**
	* getter that returns the value for an object that stores destination and value
	*/
	public Integer getValue() {
		//getter for value
		return Value;
	}
	/**
	* setter that stores the value for an object that stores destination and value
	*/
	public void setValue(int value) {
		Value = value;
		//setter for value
	}
	

}
