// program seven "  "    //    miles / amount / to output
// should look like //      .0  /    .oo / total amount of .xx
// number of mileage values processed is = 10
// 

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
   header( outFile);
	output( outFile, 0.0, 0.0, inFile);
   outFile.close(); // Writes output then closes the file
 }
   public static void header(PrintWriter outFile)
   { 
    outFile.println("MMA");
    outFile.println("\n miles amount");
	}
	public static void output(PrintWriter outFile, double miles, double amount, Scanner inFile)
   {
    outFile.println(leftpad.leftpad(miles, 6) + leftpad2.leftpad2(amount, 10) );
	 
    int n = 10; // This should be replaced with input from the file.
    for (int i = 0; i < n; i++)
    {
       amount = 0;
       miles = inFile.nextDouble();
        if (miles > 0)
        {
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
				  outFile.println( miles + " " + amount );
		  }
             else 
             { amount = 0;
              outFile.println("*****");
				 }
				 
    }
}
}