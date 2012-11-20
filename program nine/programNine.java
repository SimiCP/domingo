import java.io.*;        	              
import java.text.*;							  
import java.util.Scanner;					  

public class programNine				  
{	
	public static void main (String [] Args) throws Exception	
	{ 
		double totalAmount = 0; 	// holds the total amount in variable (totalAmount)
		double totalMiles = 0;		// holds the total miles in variable  (totalMiles)
		int counter = 0;	 // (counter) holds the number of positive values processed
				
		// reads file
		Scanner inFile = new Scanner(new FileReader ("miles.txt"));
		// creates a new file where the output informtion will be printed on
		PrintWriter outFile = new PrintWriter("milesamount.txt");
		// call for the header method, prints the header in the output
		header( outFile );
		
	   int n = inFile.nextInt();  // declares n and processes the values from miles.txt,
											// n is the amount of values processed
											
		double[] miles = new double[n];	
		double[] amount = new double[n];													
		
  		{public class getSides(FileReader, miles)
		double[] miles = new double[n];	
		double miles[i] = inFile.nextDouble();
	}						  											
      for (int i = 0; i < n; i++)      // number of values to process (n)
      {  
			amount = 0;
			double miles[i] = inFile.nextDouble();
			double amount[i];
			  
			// if statments are to calculate all mileage values from input file above zero
			// each value will pass through the if and else if statements and will be 
			// calculated into a new (amount) value to correspond to the according mileage
        	if (miles[i] > 0)						
        	{  // (counter) adds one to variable for each positive mileage from input file
			   ++counter; 			   
          	if(miles[i] < 500)			   
              amount[i] = 0.15 * miles;   
            else if (miles[i] < 1000)     
              amount[i] = 75 + 0.12 *(miles[i] - 500);
            else if (miles[i] < 1500)
              amount[i] = 135 + 0.10 *(miles[i] - 1000);
            else if (miles[i] < 2000)
              amount[i] = 185 + 0.08 *(miles[i] - 1500);
            else if (miles[i] < 3000)
              amount[i] = 225 + 0.06 *(miles[i] - 2000); 
            else 
              amount[i]  = 285 + 0.05 *(miles[i] - 3000);
				  
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