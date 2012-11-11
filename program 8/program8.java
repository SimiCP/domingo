import java.io.*;        	              
import java.text.*;							  
import java.util.Scanner;
import java.util.StringTokenizer;					  

public class program8 					  
{
	public static void main (String [] Args) throws Exception	
	{
	   
		String name;
		int counter; 
		int value;
		String line;
		double total;
		int counter2;
		
		counter = 0;
		total = 0;
		counter2 = 0;
		
		// reads file
		Scanner inFile = new Scanner(new FileReader ("data.txt"));
		// creates a new file where the output informtion will be printed on
		PrintWriter outFile = new PrintWriter("gradereport.txt");
		// call for the header method, prints the header in the output
		header( outFile );
		
		StringTokenizer st;
		
		while( inFile.hasNext())
		{ line = inFile.nextLine();
		  st = new StringTokenizer( line );
		  value = Integer.parseInt(st.nextToken());
		  name = st.nextToken();
		  while( st.hasMoreTokens())
		  { name = name + " " + st.nextToken();
        }
		  if (value >= 90)
		  	outFile.println(rightpad(name, 17 ) + leftpad(value, 10) + "     OUTSTANDING");
	
		  else if (value >= 70) 
		  { outFile.println(rightpad(name, 17 ) + leftpad(value, 10) + "     Satisfactory");
			 counter2++;
			 total += value;
		  }
			
		  else
		  	outFile.println(rightpad(name, 17) + leftpad(value, 10) + "     FAILING");
	
		  } // write file for output
		  output( outFile, counter2, counter, total);
	   }
//********************************************************************************************
	// method header will print the header format to the output file(outFile)
   public static void header(PrintWriter outFile)
   {	// title 
    	outFile.println("             Grade Report");
		outFile.println();	
			// column header 
    	outFile.println("     Name             Value     Message");
	}
//********************************************************************************************
	// print footer
	public static void output(PrintWriter outFile, int counter2, int counter, double total)
   {  // line break before footer
		outFile.println();						
		// the total of amounts using special formatting from static method leftpad2
		outFile.println("total of " + leftpad(total, 0));
		// the count of entries to be read from the input file
		outFile.println("number of grade values procesed is " + counter);
		outFile.println("number of Satisfactory grades processed is " + counter2);

		outFile.close(); 
  }
  
  
  //rightpad for name to a specified width
  //leftpad for the value to a spcified width .0

  // after the table print in the output file
  // total number of data lines processsed
  
  // forloop?
  // number and real average of the values between 70 and 89 one decimal
  // 
   public static String rightpad(String name, int width)
   {	
		String s;         // string that is returned
  		int m;            // lenght of string (s)
		
  		s = name;
  		// determine the lenght of string (s)
  		m = s.length();
  		// pad s by spaces on the left so that the resulting lenght of s is width
  		for (int i = 0; i < width - m; i++)
  		{
  			s = s + " ";   // one space between the " " right
  		}
  		return s;
  }
  
   public static String leftpad(double value, int width)
   {	
		String s;         // string that is returned
  		int m;            // lenght of string (s)
  
  		DecimalFormat fmt = new DecimalFormat("0");
  		// convert miles to a string with one decimal place
  		s = fmt.format(value);
  		// determine the lenght of string (s)
  		m = s.length();
  		// pad s by spaces on the left so that the resulting lenght of s is width
  		for (int i = 0; i < width - m; i++)
  		{
  			s = " " + s;   // one space between the " "
  		}
  		return s;
  }
}