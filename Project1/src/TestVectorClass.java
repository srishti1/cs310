import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;
import java.util.Vector;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

class TestVectorClass {
	private static final String AssertionError = null;
	VectorClass vec;

	@Test
	void testCostFromDestination() {
		vec = new VectorClass();
		Vector<Integer> costVec = new Vector<Integer> ();
		costVec.add(1);
		costVec.add(2);
		vec.setCostFromDestination(costVec);
		assertIterableEquals(costVec, vec.getCostFromDestination());
	
	}

	@Test
	void testGetPathFromDestination() {
		vec = new VectorClass();
		Vector<String> pathFromDest = new Vector<String>();
		pathFromDest.add("ABC");
		pathFromDest.add("EFG");
		vec.setPathFromDestination(pathFromDest);
		//assertIterableEquals(pathFromDest, vec.getPathFromDestination());
		assertIterableEquals(pathFromDest, vec.getPathFromDestination());

	}
	
	@Test
	void testGetDestinationStrings() {
		vec = new VectorClass();
		Vector<String> destStrings = new Vector<String> ();
		destStrings.add("ABC");
		destStrings.add("EFG");
		vec.setDestinationStrings(destStrings);
		assertIterableEquals(destStrings, vec.getDestinationStrings());
		
	}	

}
