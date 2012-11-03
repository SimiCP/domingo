// This program calculates reimbursements for the annual summer meeting
// for the Mathematical Association of America, the organization reimburses 
// each official state delegate according to the round trip mileage. The
// mileage data is stored in miles.txt (one value per line), each positive  
// value will be calculated to a new amount equal to a currency value.
// The program will create an output file milesamount.txt with the calculated
// reimbursements for each mileage value processed, the output is displayed
// on the outfile with a header containing the title and two columns (miles) 
// and (amount) similar to a table format, each column is adjusted to align
// vertically by decimal points, the numbers are to align with the header.
// If the processed mileage value is 0 or negative, the program will write 
// "*****" to the (amount) column aligned with the processed mileage value in the
// the (miles) column. After the table it will print three lines, the first line 
// with the total of reimbursement values, the second contains the number of 
// mileage values processed, and the third contains the number of mileage values
// greater or equal to zero. 
// Methods used:                 //header() and output() inside main method
//  header() - prints the heading for the table on the output file
//	 output() - outputs summary information on the output file
//  leftpad() - adjusts the processed values to be aligned by one decimal point
//	 leftpad2() - adjusts the processed values to be aligned by two decimal points
// Brunno Putnam
// Program #7, CS 1050, Fall 2012, MW
// Java(JDK 7u9) Platform SE binary, USUS UX31E, windows 7


import java.io.*;        	              
import java.text.*;							  
import java.util.Scanner;					  

public class programSeven 					  
{	// main method
	public static void main (String [] Args) throws Exception	
	{ 
    	double miles;   	 // holds the miles value from input file
   	double amount;		 // holds the amount value calculated from mileage
				
		// reads file
		Scanner inFile = new Scanner(new FileReader ("miles.txt"));
		// creates a new file where the output informtion will be printed on
		PrintWriter outFile = new PrintWriter("milesamount.txt");
		// call for the header method, prints the header in the output
		header( outFile );
		
		double totalAmount = 0; 	// declares and sets the variable totalAmount to zero
		double totalMiles = 0;		// declares and sets the variable totalMiles to zero
	   int n = inFile.nextInt();  // declares n and processes the values from the input file,
											// n is the amount of values processed
											
		int counter = 0;				// declares and sets the variable (counter) to zero
											// (counter) holds the number of positive values processed
											
      for (int i = 0; i < n; i++)      // number of values to process (n)
      {    	
			amount = 0;  
			// sets the variable (miles) to acquire the next value from input data file							
       	miles = inFile.nextDouble();
			
			// if statments are to calculate all mileage values from input file above zero
			// each value will pass through the if and else if statements and will be 
			// calculated into a new (amount) value to correspond to the according mileage
        	if (miles > 0)						
        	{  // (counter) adds one to variable for each positive mileage from input file
			   ++counter; 			   
          	if(miles < 500)			   
              amount = 0.15 * miles;   
            else if (miles < 1000)     
              amount = 75 + 0.12 *(miles - 500);
            else if (miles < 1500)
              amount = 135 + 0.10 *(miles - 1000);
            else if (miles < 2000)
              amount = 185 + 0.08 *(miles - 1500);
            else if (miles < 3000)
              amount = 225 + 0.06 *(miles - 2000); 
            else 
              amount  = 285 + 0.05 *(miles - 3000);
				  
				// increases the totalMiles by the positive miles values found in the file
				totalMiles += miles;							 
				  
				// sets the proper spacing on the outfile, leftpad and leftpad2 miles
				// align miles and amount values by one or two decimal points
				outFile.println(leftpad( miles, 10 ) + leftpad2( amount, 10 )); 
		  }
        else 
        { 	
		  		if (miles == 0) 					
					counter++;		// adds one more to count for a value equal to zero
				amount = 0; 						
				// print the mileage values with a special decimal notation
            outFile.println(leftpad( miles, 10 ) + "     *****" );
		  }
		  totalAmount += amount;				// total amounts
	   }
		// write file footer
		output( outFile, totalAmount, counter, n);
	}
//********************************************************************************************
	// method header will print the header format to the output file(outFile)
   public static void header(PrintWriter outFile)
   {	// title 
    	outFile.println("           MMA");	
			// column header 
    	outFile.println("     miles    amount");
	}
//********************************************************************************************
	// print footer
	// this method outputs the total reimbursment amount (totalAmount)
	// outputs the number of mileage values processed (n)
   // outputs the number of values >= 0 (counter)
	public static void output(PrintWriter outFile, double totalAmount, int counter, int n)
   {  // line break before footer
		outFile.println();						
		// the total of amounts using special formatting from static method leftpad2
		outFile.println("total amount of " + leftpad2( totalAmount, 0));
		// the count of entries to be read from the input file
		outFile.println("number of mileage values procesed is " + n);
		// prints the count of entries without negatives miles
		outFile.println("number of mileage values is " + counter);
		// writes output then closes the file
		outFile.close(); 
  }
//*********************************************************************************************
  // decimal format for amount
  public static String leftpad2(double amount, int width)
  {	
  		String s;         // string that is returned
   	int m;            // lenght of string (s)
  
   	NumberFormat money = NumberFormat.getCurrencyInstance();
  		// convert miles to a string with two decimal places
   	s = money.format(amount);
  		// determine the lenght of string (s)
   	m = s.length();
  		// pad s by spaces on the left so that the resulting lenght of s is width
   	for(int i = 0; i < width-m; i++)
  		{
			s = " " + s;   // one space between the " "
  		}
  		return s;
  }
// ********************************************************************************************
  // decimal format for miles
  public static String leftpad(double miles, int width)
  {	
		String s;         // string that is returned
  		int m;            // lenght of string (s)
  
  		DecimalFormat fmt = new DecimalFormat("0.0");
  		// convert miles to a string with one decimal place
  		s = fmt.format(miles);
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