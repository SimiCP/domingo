import java.io.*;
import java.util.*;

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
	public static void report(PrintWriter outFile, String[] names, double[][] data, double pay, 
									  double totalDues, double fedTax, double stateTax, double netPay, int n)
	{
	 header(outFile, names, data);
	 output(outFile, names, data, n);
	 printTotals(outFile, pay, totalDues, fedTax, stateTax, netPay, n);
   }
	
	public static void header(PrintWriter outFile, String[] names, double[][] data)
	{
	outFile.println("Natural Pine Furniture Company Payroll Report");
	outFile.println();
	outFile.println("name " + " " + "net pay" + " " + "gross pay" + " " + "federal tax" + " " 
						 + "state tax" + " " + "dues" + " " + "hours" + " " + "pay rate");
	}
					 
	public static void output(PrintWriter outFile, String[] names, double[][] data, int n)
	{	int j;
		for (j = 0; j < n; j++)
		outFile.println(names[j] + " " + data[j][0] + " " + data[j][1] + " " + data[j][2] + " " 
						    + data[j][3] + " " + data[j][4] + " " + data[j][5] + " " + data[j][6]);
	}

	public static void printTotals(PrintWriter outFile, double pay, double totalDues, double fedTax, 
											 double stateTax, double netPay, int n)
	{										 
	outFile.println("total netpay: " + netPay + "\ntotal gross pay: " + pay + "\ntotal dues: " + totalDues
						 + "\ntotal federal tax: " + fedTax + "\ntotal state tax: " + stateTax);
	}
		
       
//*****************GrossPay
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
	public static double federalTax(double[][] data, int n)
	{ int j = 0;
	  double fedTax = 0;
	  for(j = 0; j < n; j++)
	{ data[j][2] = FED_TAX * data[j][1];
	  fedTax += data[j][2];
	}
	return fedTax;
	}

//***********************state tax
	public static double stateTax(double[][] data, int n)
	{ int i = 0;
	  double stTax = 0;
	  for(i = 0; i < n; i++)
	{ data[i][0] = data[i][1] * STATE_TAX;
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
}
