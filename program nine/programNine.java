// Brunno Putnam
// Program #9, CS 1050, Fall 2012, MW
// Java(JDK 7u9) Platform SE binary, USUS UX31E, windows 7

	import java.io.*;        	              
   import java.text.*;							  
   import java.util.Scanner;					  

   public class programNine				  
   {	
      public static void main (String [] Args) throws Exception	
      { 
         double totalAmount = 0; 	
			int counter = 0;	 
         double counter2 = 0;
			     	
         Scanner inFile = new Scanner(new FileReader ("miles.txt"));
         PrintWriter outFile = new PrintWriter("milesamount.txt");
		
			int n = inFile.nextInt();  								   						
         double[] miles = new double[n];
         double[] amount = new double[n];
			
			double milesTotal = inputMiles(inFile, n, miles);	
			totalAmount = calcAmounts(miles, amount, n);
			counter = count(miles, n);
			counter2 = (int)count2(miles, n);
			
			double averageMiles = average(milesTotal, counter);
			double averageAmount = average(totalAmount, n);
         	
			header(outFile);
         outputDetails(miles, amount, outFile, n);
         output(outFile, totalAmount, milesTotal, counter, 
			averageMiles, averageAmount, counter2, n);
			outFile.close(); 
      
      }													
  //********************************************************** 	
      public static double inputMiles(Scanner inFile, int n, double[]miles)
      { 	double milesTotal = 0; 		  											
         for (int i = 0; i < n; i++)     
      	{ miles[i] = inFile.nextDouble();
				if(miles[i] > 0)
					milesTotal += miles[i];
					
         }
			return milesTotal;
      }
  //***********************************************************
      public static double calcAmounts(double[] miles, double[] amount, int n)
      
      {	double amountTotal = 0;
         for(int i = 0; i < miles.length; i++)
         {
         // if statments are to calculate all mileage values 
			// from input file above zero each value will pass through
			// the if and else if statements and will be calculated into
			// a new (amount) value to correspond to the according mileage
            if (miles[i] > 0)						
            {  // (counter) adds one to variable for each positive mileage 		   
               if(miles[i] < 500)			   
                  amount[i] = 0.15 * miles[i];   
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
            
            }
            else 
					amount[i] = 0;
					amountTotal += amount[i];
				}
				return amountTotal;	
            
            }
   //*******************************************************
		public static double average(double sum, int counter)
		{
			return sum/(double)counter;
		}
	//*******************************************************
	
		public static int count(double miles[], int n)
		{ int counter = 0;
		  for(int i = 0; i < n; i++)
		  	if(miles[i] > 0);
		  		counter++;
		  return counter;
		}
	//********************************************************
		public static double count2(double miles[], int n)
		{ double counter2 = 0;
			for(int i = 0; i < n; i++)
				if(miles[i] >= 0)
				 counter2++;
			return counter2;
		}
	//********************************************************	
      public static void outputDetails(double[] miles, double[] amount,
												   PrintWriter outFile, int n)
      { double counter2 = 0;
         for (int i=0; i < n; i++)
            if (miles[i] <= 0) 					
            outFile.println(leftpad( miles[i], 10 ) + "     *****" );
            else
            outFile.println(leftpad( miles[i], 10 ) + leftpad2(amount[i], 10 ));
      
      }
	//*******************************************************
      public static void header(PrintWriter outFile)
      {	// title 
         outFile.println("           MMA");	
      	// column header 
         outFile.println("     miles    amount");
      }
   //********************************************************
      public static void output(PrintWriter outFile, double totalAmount, 
										  double milesTotal, int counter,
										  double averageMiles, double averageAmount, 
										  double counter2, int n)
      {  
         outFile.println();						
      
         outFile.println("total amount of " 
					          + leftpad2(totalAmount, 0));
			
         outFile.println("number of mileage values procesed is " 		
								 + n);
			
			outFile.println("number of mileage values greater or equal to zero " 
							    + (int)counter2);
								 
			outFile.println("the total of lieage values greater than zero " 
								 + leftpad(milesTotal, 0)); 
								 
			outFile.println("the average number of miles traveled " 
							    + leftpad(averageMiles/n, 0));
								 
			outFile.println("the average reimbursement is " 
							    + leftpad2(averageAmount, 0));
      }
   //**********************************************************
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
   // ***********************************************************
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