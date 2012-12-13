import java.io.*;
import java.util.*;
import java.text.DecimalFormat;

public class progEleven
{
       public static final double FED_TAX = .18;
       public static final double STATE_TAX = .045;
       public static final double DUES = 7.85;
       		 
public static void main (String[]Args) throws Exception
   {   String[] names = new String[30];
       double[][] data = new double[30][7];
		 
		 Scanner inFile = new Scanner(new FileReader("prog11"));
		 PrintWriter outFile = new PrintWriter("Payroll");
		 
		 int n = inputData(inFile, names, data);
		 int left = leftover(inFile);
		 double grossP = calcPay(data, n);
		 double totalDues = dues(data, n);
		 double fedTax = fTax(data, n);
		 double stateTax = sTax(data, n);
		 double netPay = nPay(data, n);
		 
		 report(outFile, names, data, grossP, totalDues, fedTax, stateTax, netPay, n);
		 outFile.close();
		 
	} 
		
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
//***************** print details ********************
	public static void report(PrintWriter outFile, String[] names, double[][] data, double grossP, 
									  double totalDues, double fedTax, double stateTax, double netPay, int n)
	{
	 header(outFile, names, data);
	 output(outFile, names, data, n);
	 printTotals(outFile, grossP, totalDues, fedTax, stateTax, netPay, n);
   }
	
	public static void header(PrintWriter outFile, String[] names, double[][] data)
	{
	outFile.println("\t\t\t\t\t\t\t\t\t\t\t\\t\t\tNatural Pine Furniture Company Payroll Report");
	outFile.println();
	outFile.println(" Name                             " +  "Net pay    "  + " Gross pay  "  + "Federaltax"  
						 + "  State tax" +  "      Dues" +  "       Hours" + " " + "     Pay rate");
	}
					 
	public static void output(PrintWriter outFile, String[] names, double[][] data, int n)
	{	int j;
		for (j = 0; j < n; j++)
		outFile.println(rightpad(names[j], 19) + "\t" + leftpad(data[j][0], 20) + "\t " + leftpad(data[j][1], 10) + "\t" + leftpad(data[j][2], 10) + " " 
						    + leftpad(data[j][3], 10) + "\t" + leftpad(data[j][4], 10) + "\t" + leftpad(data[j][5], 10) + "\t" + leftpad(data[j][6], 10));
	}

	public static void printTotals(PrintWriter outFile, double grossP, double totalDues, double fedTax, 
											 double stateTax, double netPay, int n)
	{										 
	outFile.println("total netpay: " + netPay + "\ntotal gross pay: " + grossP + "\ntotal dues: " + totalDues
						 + "\ntotal federal tax: " + fedTax + "\ntotal state tax: " + stateTax);
	}
		
       
//*****************GrossPay
	public static double calcPay(double[][] data, int n)
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
//********************************dues	
	public static double dues(double data[][], int n)
	{ int j = 0;
	  double totalDues = 0;
	  for(j = 0; j < n; j++)
	  { data[j][4] = DUES; 
	  totalDues += data[j][4];
	  }
	  return totalDues;
	}
	
//************************fedTax
	public static double fTax(double[][] data, int n)
	{ int j = 0;
	  double fedTax = 0;
	  for(j = 0; j < n; j++)
	{ data[j][2] = FED_TAX * data[j][1];
	  fedTax += data[j][2];
	}
	return fedTax;
	}

//***********************state tax
	public static double sTax(double[][] data, int n)
	{ int i = 0;
	  double stTax = 0;
	  for(i = 0; i < n; i++)
	{ data[i][3] = data[i][1] * STATE_TAX;
	  stTax += data[i][3];
	} 
	  return stTax;
	}
//**********************netpay
	public static double nPay(double[][] data, int n)
	{ double netPay = 0;
	  int i;
	  for( i = 0; i < n; i++)
	  {data[i][0] = data[i][1] - data[i][2] - data[i][3] - data[i][4];
	  netPay += data[i][0];
	  }
	  return netPay;
	}
//*******************leftover
	public static int leftover(Scanner inFile)
	{ int left = 0;
		while(inFile.hasNext())
	{
	left++;
	inFile.nextLine();
	}
	return left;
	}
	
	 //***********************leftpad1************************************************************************
 
      public static String leftpad(double data, int width)
      {  String s;        
         int m;        
      
         DecimalFormat formatter = new DecimalFormat ("0.00");
      
         s = formatter.format(data);
      
         m = s.length();                   
         for (int i = 0; i < width-m; i++) 
            s = " " + s;       
         return s;                         
      }
		 //***********************leftpad1************************************************************************
 


		  //********************************************************************************************
      public static  String rightpad(String name, int width)
            // returns a String consisting padded on right to a specified width
      { int m;
      // determine the legnth of name
         m = name.length();
         for (int i = 0; i < width-m; i++)
            name  += " " ;          // one space between the ""
         return name;
      }
   
}
