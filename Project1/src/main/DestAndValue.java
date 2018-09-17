package main;

public class DestAndValue {
	int Destination;
	int Value;
	public DestAndValue(int dest, int val) {
		Destination = dest;
		Value = val;
	}
	public Integer getDestination() {
		return Destination;
		//getter for destination
	}
	public void setDestination(int destination) {
		Destination = destination;
		//setter for destination
	}
	public Integer getValue() {
		//getter for value
		return Value;
	}
	public void setValue(int value) {
		Value = value;
		//setter for value
	}
	

}
