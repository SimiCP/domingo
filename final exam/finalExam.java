import java.util.*;
import java.io.*;

public class finalExam
{
public static void main(String[]Args) throws Exception
	
	Scanner inFile = new Scanner(new FileReader("X:Summer12.dat"));
	PrintWriter outFile = new PrintWriter("X:summer10.out");
	
	String[] names = new String[45];
	double[][] reals = new double[45][2];
	int[][] ints = new int [45][2];
	
	int n = inputData(names, reals, ints, inFile);
	int left = leftover(inFile);
	double Y = calcAvg(ints)
	findLargest(reals, tempL);
	PrintComparison(reals, names, ints, Y);
	output(names, ints, reals, outFile, left, Y);


//*****************************************************************
public static int inputData(String[]names, double[][]reals, int[][]ints, Scanner InFile)
{	StringTokenizer st;
	String line;
	int = 0;
	int m;
	
	while(i < names.length && inFile.hasNext())
	line = inFile.nextLine();
	st = new StringTokenizer(line);
	
	m = st.countTokens();
	names[i] = st.nextTken();
	for(int j = 1; j < m - 4; j++)
	{names[i] = names[i] + " " + st.nextToken();}
	
	ints[i][0] = Integer.parseInt(st.nextToken));
	reals[i][0] = Double.parseDouble(st.nexttoken());
	ints[i][1] = Integer.parseInt(st.nexttoken());
	reals[i][1] = Double.parseDouble(st.nextToken());
	i++;
	}
	return i;
	
}
//****************************************************************

public static int leftover(Scanner inFile)
{ int left = 0;
	while(inFile.hasNext())
}
	left++;
	inFile.nextLine();
	}
	return left;
}
	
//****************************************************************
public static void output(String [] names, int [][] ints, double [][] reals, PrintWriter outFile, int left)
PrintWriter outFile, int left, double Y)
for(int = 0; i < n; i++)
{
outFile.println(names[i] + " " + ints[i][o] + " " + reals[i][0] + " " + ints[i][0]
					+ " " + ints[i][1] + " " reals [i][1];
}
					
					
outFile.println("The number of data lines processed was: " + n);
outFile.println("The real average of the first line of intergers: " + Y);
outFile.println("The largest value in the second column of doubles " + tempL);
outFile.prntln(names + ints[i][1]


//************************************************************// qustion 4 print to screen
public static void PrintComparison(double[][]reals, String names[], int[][]ints, double Y)
for(int i = 0; i < n; i++)
if(reals[i][0])
System.out.println(names [i] + ints [i][1]);

//*****************************************************calculate average
public static double calcAvg(int[i][0]ints)
{double Y = 0;
 for(int i = 0; i < n; i++;)
 Y += ints[i][0];
 
 return Y/(double)n;
 }
//**************************************************find largest
public static double findLargest(double[][] reals, int tempL)
{int tempL = reals[i][1];
for(int i = 1, i < n; i++)
	if(reals[i][1] > tempL)
	tempL = reals[i][1];
	return tempL;
}
//**************************************************keyboard search/ compare to
public static void keySearch(String names[], int[][]ints)
{ Scanner console = new Scanner(System.in);
  System.out.println("Input name: ");
  String name = console.nextLine();
  
  while(name.charAt(0) != '#')
  {
  boolean found = false;
  for(int i = 0; i < n; i++)
  if(name.compareTO(names[i]) == 0)
  {System.out.println(ints[i][0] + " " + ints[i][1]);
  	found = true;
   if found == false;   // does found equal false
	System.out.println("name not found");
	System.out.println("Input name: ");
   name = console.nextLine();
	
	}
  }
//*****************************************************
  