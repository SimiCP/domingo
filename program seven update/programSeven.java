import java.io.*;
import java.text.*;
import java.util.Scanner;

public class programSeven 
{	
	public static void main (String [] Args) throws Exception
   	{ 
  	    	double miles;
	   	double amount;
	
			Scanner inFile = new Scanner(new FileReader ("C:\\dotjava\\miles.txt")); //may need to change path
			PrintWriter outFile = new PrintWriter("C:\\dotjava\\milesamount.txt");
			header( outFile );
			
			double totalAmount = 0;
			double totalMiles = 0;
		   double n = inFile.nextDouble();
			int counter = 0;
	      for (int i = 0; i < n; i++)
	      {    	
				amount = 0;
	       	miles = inFile.nextDouble();
	        	if (miles > 0)
	        	{  
				   ++counter;
	          	if(miles < 500)
	              amount = 0.15 + miles;
	            else if (miles < 1000)
	              amount = 95 + 0.12 *(miles - 500);
	            else if (miles < 1500)
	              amount = 135 + 0.10 *(miles - 1000);
	            else if (miles < 2000)
	              amount = 185 + 0.08 *(miles - 1500);
	            else if (miles < 3000)
	              amount = 225 + 0.06 *(miles - 2000); 
	            else 
	              amount  = 285 + 0.05 *(miles - 3000);
					totalMiles += miles;
					  outFile.println(leftpad( miles, 10 ) + leftpad2( amount, 10 ));
			  }
	        else 
	        { 	
			  		miles = 0; counter++;	
					amount = 0;
	            outFile.println(leftpad( miles, 10 ) + "     *****" );
			  }
			  totalAmount += amount;
		   }
			
   public static void header(PrintWriter outFile)
   { 
    	outFile.println("           MMA");
    	outFile.println("     miles    amount");
	}
	public static void output(PrintWriter outFile, Scanner inFile)
   {
		double amount;
		outFile.println();
		outFile.println("total amount of " + leftpad2( totalAmount, 0 ));
		outFile.println("number of mleage values procesed is " + n);
		outFile.println("number of mileage values is " + counter);
		output( outFile, inFile);
		outFile.close(); // Writes output then closes the file
	}
}
   public static String leftpad2(double amount, int width)
  {	String s;         // string that is returned
   	int m;            // lenght of string (s)
  
   	NumberFormat money = NumberFormat.getCurrencyInstance();
  
  			// convert miles to a string with one decimal place
   	s = money.format(amount);
  
  			// determine the lenght of string (s)
   	m = s.length();
  
  			// pad s by spaces on the left so that te resulting lenght of s is width
   	for(int i = 0; i < width-m; i++)
  		{s = " " + s;       // one space between the " "
  }
  		return s;
  }
  
  public static String leftpad(double miles, int width)
  {	String s;         // string that is returned
  		int m;            // lenght of string (s)
  
  		DecimalFormat fmt = new DecimalFormat("0.0");
  
  		// convert miles to a string with one decimal place
  		s = fmt.format(miles);
  
  		// determine the lenght of string (s)
  		m = s.length();
  
  		// pad s by spaces on the left so that te resulting lenght of s is width
  		for (int i = 0; i < width - m; i++)
  
  		s = " " + s;       // one space between the " "
  
  		return s;
  }
}