import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

/*

The file SearchMap.java contains the “client” code (Main()
 function that handles command-line options 
and file read and write) that uses a FlightMap
 */

public class SearchMap {

public static void main(String args[]) throws IOException{
	System.out.print("Enter the input file ");
	Scanner input;
	Vector<String> inputVector=new Vector<String>();
	try {
		input = new Scanner(System.in);
		File file = new File(input.nextLine());
		input = new Scanner(file);
		while (input.hasNextLine()) {
		    String line = input.nextLine();
		    inputVector.add(line);
		}
		input.close();
	}catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	FlightMap AdjacencyList= new FlightMap(inputVector);
	VectorClass vec =    AdjacencyList.BuildGraph();
	Vector<String> destinationStrings = vec.getDestinationStrings();
	Vector<String> pathFromDestination = vec.getPathFromDestination();
	Vector<Integer> costFromDestination = vec.getCostFromDestination();
	
	Integer size = destinationStrings.size();
	System.out.print("Enter the output file ");
	Scanner in;
	in = new Scanner(System.in);
	FileReader fileReader = new FileReader(in.nextLine());
	FileWriter f0 = new FileWriter("output.txt");

	String newLine = System.getProperty("line.separator");


	for(Integer i=0;i<size;i++)
	{
	    f0.write(destinationStrings.get(i)+"     "+pathFromDestination.get(i)+ "     "+costFromDestination.get(i));
	    f0.write(newLine);
	}
	f0.close();


 
	for(Integer i=0; i<size; i++) {
	System.out.println(destinationStrings.get(i)+"     "+pathFromDestination.get(i)+ "     "+costFromDestination.get(i));
	}
//	
	
		 
	}
}
