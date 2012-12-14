// Brunno Putnam
// Program #11, CS 1050, Fall 2012, MW
// Java(JDK 7u9) Platform SE binary, USUS UX31E, windows 7

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class programEleven
{
       public static final double FED_TAX = .18;
       public static final double STATE_TAX = .045;
       public static final double DUES = 7.85;
       		 
public static void main (String[]Args) throws Exception
   {   String[] names = new String[30];
       double[][] data = new double[30][7];
		 
		 Scanner inFile = new Scanner(new FileReader("data.txt"));
		 PrintWriter outFile = new PrintWriter("payroll.txt");
		 
		 int n = inputData(inFile, names, data);
		 int left = leftover(inFile);
		 double pay = calculatePay(data, n);
		 double totalDues = dues(data, n);
		 double fedTax = federalTax(data, n);
		 double stateTax = stateTax(data, n);
		 double netPay = nPay(data, n);
		 
		 report(outFile, names, data, pay, totalDues, fedTax, stateTax, netPay, n);
		 selectionSort(names, data, n);
		 report(outFile, names, data, pay, totalDues, fedTax, stateTax, netPay, n);
		 selectionSort2(names, data, n);
		 report(outFile, names, data, pay, totalDues, fedTax, stateTax, netPay, n);

		 outFile.close();	 
	} 
//*******************
//input data
       public static int inputData(Scanner inFile, String[] names, double[][] data)
       {   StringTokenizer st;
           String line;
           int i = 0;
           int m;
           
           while(i < names.length && inFile.hasNext())
           
           { line = inFile.nextLine();
             st = new StringTokenizer(line);
             m = st.countTokens();
				 names[i] = "";
             
             for(int j = 0; j < m-2; j++)
				 names[i] = names[i] + " " + st.nextToken();
             data[i][5] = Double.parseDouble(st.nextToken());
             data[i][6] = Double.parseDouble(st.nextToken());
             i++;
           }
             return i;
       }
//***************** 
//print details 
	public static void report(PrintWriter outFile, String[] names, double[][] data, double pay, 
									  double totalDues, double fedTax, double stateTax, double netPay, int n)
	{
	 header(outFile, names, data);
	 output(outFile, names, data, n);
	 printTotals(outFile, pay, totalDues, fedTax, stateTax, netPay, n);
   }
	
	public static void header(PrintWriter outFile, String[] names, double[][] data)
	{
	outFile.println("\t\t\t\t\t\t\t\t\t\t\t\t\tNatural Pine Furniture Company Payroll Report");
	outFile.println();
	outFile.println(" Name                             " +  "Net pay    "  + " Gross pay  "  + 
	                "Federaltax"  + "  State tax" +  "      Dues" +  "      Hours" + " " +
						  "     Pay rate");	
	}
					 
	public static void output(PrintWriter outFile, String[] names, double[][] data, int n)
	{	int j;
		for (j = 0; j < n; j++)
		outFile.println(rightpad(names[j], 20) + " " + leftpad(data[j][0], 19) + "\t" 
									    + leftpad(data[j][1], 10) + "\t " + leftpad(data[j][2], 10) + "\t" 
						    			 + leftpad(data[j][3], 10) + "\t" + leftpad(data[j][4], 10) + " " 
										 + leftpad(data[j][5], 10) + "\t" + leftpad(data[j][6], 10));
	}

	public static void printTotals(PrintWriter outFile, double pay, double totalDues, double fedTax, 
											 double stateTax, double netPay, int n)
	{										 
	outFile.println("total netpay: " + leftpad(netPay, 0) + "\n total gross pay: " + leftpad(pay, 0) 
						 + "\n total dues: " + leftpad(totalDues, 0) + "\n total federal tax: " + leftpad(fedTax, 0) 
						 + "\n total state tax: " + leftpad(stateTax, 0));
	}
		
       
//********************
//grosspay
	public static double calculatePay(double[][] data, int n)
	{
	double totalGross = 0;
	int i;
	for(i = 0; i < n; i++)
		{
		if (data[i][5] <= 40) 
		data[i][1] = data[i][6] * data[i][5];
		else if (data[i][5] <= 50.0)
		data[i][1] = data [i][6] *  (40 + data[i][5] - 40) * 1.5 * data[i][6];
		else
		data[i][1] = data [i][6] * 40 + 10 * 1.5 * data[i][6] + (data[i][5] - 50.0) * data[i][6] * 2;
		totalGross += data[i][1];
		}
	 return totalGross;
	}
//************************
//dues	
	public static double dues(double data[][], int n)
	{ int j = 0;
	  double totalDues = 0;
	  for(j = 0; j < n; j++)
	  { data[j][4] = DUES; 
	  totalDues += data[j][4];
	  }
	  return totalDues;
	}
	
//************************
//federaltax
	public static double federalTax(double[][] data, int n)
	{ int j = 0;
	  double fedTax = 0;
	  for(j = 0; j < n; j++)
	{ data[j][2] = FED_TAX * data[j][1];
	  fedTax += data[j][2];
	}
	return fedTax;
	}

//***********************
//state tax
	public static double stateTax(double[][] data, int n)
	{ int i = 0;
	  double stTax = 0;
	  for(i = 0; i < n; i++)
	{ data[i][3] = data[i][1] * STATE_TAX;
	  stTax += data[i][3];
	} 
	  return stTax;
	}
//**********************
//netpay
	public static double nPay(double[][] data, int n)
	{ double netPay = 0;
	  int i;
	  for( i = 0; i < n; i++)
	  {data[i][0] = data[i][1] - data[i][2] - data[i][3] - data[i][4];
	  netPay += data[i][0];
	  }
	  return netPay;
	}
//**********************
//leftover
	public static int leftover(Scanner inFile)
	{ int left = 0;
		while(inFile.hasNext())
	{
	left++;
	inFile.nextLine();
	}
	return left;
	}
//**********************
//decimal format	
   public static String leftpad(double data, int width)
   { String s;        
     int m;        
      
     DecimalFormat formats = new DecimalFormat ("0.00");
      
     s = formats.format(data);
      
     m = s.length();                   
     for (int i = 0; i < width-m; i++) 
     s = " " + s;       
     return s;                         
   }
//***********************
//decimal format
   public static  String rightpad(String name, int width)
   { int m;
         m = name.length();
         for (int i = 0; i < width-m; i++)
            name  += " " ;
				return name;      
   }
//**********************
//selection sort
	public static void selectionSort(String[]names, double[][]data, int n)
	{
		for(int i = 0; i < n - 1; ++i)
		{
			int min = i;
			for( int l = i + 1; l < n; ++l)
		   { 
		  		if(names[min].compareTo(names[l]) > 0)
				{
					min = l;
				}
			}
		   if(min != i)
		   {
				String temp = names[i];
		  	 	names[i] = names[min];
			 	names[min] = temp;
		  		for( int d = 0; d < data[min].length; d++)
		   	{
					double temp2 = data[i][d];
		  			data[i][d] = data[min][d];
					data[min][d] = temp2;
		   	}
			} 
		}
	}
//***********
//selection sort two
public static void selectionSort2(String[]names, double[][]data, int n)
	{
		for(int i = 0; i < n - 1; i++)
		{
			int min = i;
			for( int l = i + 1; l < n; ++l)
		   { 
		  		if(data[min][1] > data[l][1])
				{
					min = l;
				}
			}
		   if(min != i)
		   {
				String temp = names[i];
				names[i] = names[min];
				names[min] = temp;
		  		for( int d = 0; d < data[min].length; d++)
		   	{
					double temp2 = data[i][d];
		  			data[i][d] = data[min][d];
					data[min][d] = temp2;
		   	}

		 }
	}
	}
}

