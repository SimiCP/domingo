// This program reads from a file and writes to a file. It will process 
// data lines until the end of file. The data in the input file will be read
// and processed in one pass thru the file. The output is to one file. 
// Each line in the input data file will contain an interger followed by a name
// a string is used to store the line. The created output file 'gradereport.txt'
// will consist of a table with a header, the columns of the report will contain
// the name, grade(value), and a message. The message is OUTSTANDING if the value is
// 90 or more, Satisfactory if the value is between 70 and 89 inclusive and FAILING
// otherwise. After the table the program will print a line with the number of data
// lines processed, and a message with the number and the real average of the values
// between 70 and 89 inclusive.
// Methods used:
// 	header()  -- prints the heading for the table on the output file
//		output()  -- outputs summary information to the output file
// 	leftpad() -- adjusts the processed values to the left with special format
// 	rightpad()-- adjusts the processed values to the right
// Brunno Putnam
// Program #8, CS 1050, Fall 2012, MW
// Java(JDK 7u9) Platform SE binary, USUS UX31E, windows 7

import java.io.*;        	              
import java.text.*;							  
import java.util.Scanner;
import java.util.StringTokenizer;					  

public class program8 					  
{
	public static void main (String [] Args) throws Exception	
	{	String name;		// holds the names with a string
		int counter; 		// holds the number of lines processed
		int value;			// holds the grade values
		String line;		// holds the line of data file in string
		double total;		// holds the total of grade values 
		int counter2;		// holds the number of Satisfactory values
		
		counter = 0;      // sets the value of (counter) to zero
		total = 0; 			// sets the value of (total) to zero
		counter2 = 0;		// sets the value of (counter2) to zero
		
		// reads input data file
		Scanner inFile = new Scanner(new FileReader ("data.txt"));
		// creates a new file where the output information will be printed on
		PrintWriter outFile = new PrintWriter("gradereport.txt");
		// call for the header method, prints the header to the output
		header( outFile );
		// StringTokenizer is used to break the strings into tokens
		StringTokenizer st;
		
		while( inFile.hasNext())  	 // returns true if the in data file has more elements
		{ line = inFile.nextLine(); // if line found moves to the next line of the data file
		  counter++;					 // counter for the number of lines processed
		  st = new StringTokenizer( line );	// breaks the string(line) into tokens
		  value = Integer.parseInt(st.nextToken()); // sets value to obtain next (int) token
		  name = st.nextToken(); // sets name to obtain the next word (name) token
		  
		  // will keep reading the tokens inside the string lines of the input file
		  // sets string name to the equivalent data name in the input file
		  // while reads the file for the next word token linked to input name
		  while( st.hasMoreTokens()) 
		  { name = name + " " + st.nextToken(); 
        }
		  // if grade(value) greater or equal to 90 prints message "OUTSTANDING" 
		  // with the name padded to the right(rightpad), with the value padded
		  // to the left(leftpad) static methods followed by spaces and then a message
		  if (value >= 90) 
		  	outFile.println(rightpad(name, 17 ) + leftpad(value, 10) + "     OUTSTANDING");
		  // prints the message "Satisfactory" on the output file line with names and scores
		  // less or equal to 70 padded by rightpad, leftpad with spaces followed by a message
		  else if (value >= 70) 
		  { outFile.println(rightpad(name, 17 ) + leftpad(value, 10) + "     Satisfactory");
			 counter2++;  // counter for the total of Satisfactory values processed
			 total += value; //totals all Satisfactory values(grades)
		  }
		  // prints the message "FAILING" if scores below or equal to 69 also padded 
		  else
		  	outFile.println(rightpad(name, 17) + leftpad(value, 10) + "     FAILING");
	
		  } // write file for output report
		  output( outFile, counter2, counter, total);
	   }
//*****************************************************************************************
	// method header will print the header format to the output file(outFile)
   public static void header(PrintWriter outFile)
   {	// title 
    	outFile.println("             Grade Report");
		outFile.println();	
		// column header 
    	outFile.println("     Name             Value     Message");
	}
//*****************************************************************************************
	// print footer method (summary)
	public static void output(PrintWriter outFile, int counter2, int counter, double total)
   {  // line break before footer 
		outFile.println(); 
		outFile.println("Number of data lines procesed is " + counter);						
		// print line to outfile with the total of Satisfactory values, with 
		// their average formatted by 1 decimal place on the same line
		DecimalFormat fmt = new DecimalFormat("0.0");
		if(counter2 > 0) 
			outFile.println("Total of Satisfactory grades is " + counter2 +
							    " with the real average of " + fmt.format( total/counter2)); 
		outFile.close();  // closes the output file
  }
   public static String rightpad(String name, int width)
   {	String s;         // string that is returned
  		int m;            // lenght of string (s)
		
  		s = name;
  		// determine the lenght of string (s)
  		m = s.length();
  		for (int i = 0; i < width - m; i++)
  		{
  			s = s + " ";   // one space between the " " aligned to the  right
  		}
  		return s;
  }
   public static String leftpad(double value, int width)
   {	String s;         // string that is returned
  		int m;            // lenght of string (s)
  
  		DecimalFormat fmt = new DecimalFormat("0");
  		// convert miles to a string with one decimal place
  		s = fmt.format(value);
  		// determine the lenght of string (s)
  		m = s.length();
  		for (int i = 0; i < width - m; i++)
  		{
  			s = " " + s;   // one space between the " " aligned to the left
  		}
  		return s;
  }
}