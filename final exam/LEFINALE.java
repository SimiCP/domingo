// FINAL EXAM CS1050 FALL 2012

// MAIN

import java.util.*;
import java.io.*;

public class finalExam
{
	public static void main(String[]Args) throws Exception
	{
		Scanner inFile = new Scanner(new FileReader("X:Summer12.dat"));
		PrintWriter = new PrintWriter("X:Summer10.out");

		String[] names = new String[45];
		double[][] reals = new double[45][2];
		int[][] ints = new int[45][2];

		int n = inputData(names, reals, ints, inFile);
		int left = leftover(inFile);

		output(names ints, reals, outFile, left, Y);

		double Y = calcAvg(ints, n);
		System.out.println("the average is: " + Y/n);

		printComparison(reals, names, ints, Y);
		keySearch(names, ints, reals, outFile, left, n);

		double X = findLargest(reals, n);
		System.out.println("largest: " + X);

		ouFile.close();
		System.out.println("Brunno");
	}

//*************************PRINT COMPARISON

	public static void printComparison(double[][]reals, String[] names[], int[][] ints, double Y, int n)
	{
		for(int i = 0; i < n; i++)
			if(reals[i][0]] >= Y)
				System.out.println(names[i] + " " + ints[i][1];)
	}

//************************FIND LARGEST

	public static double findLargest(double[][] reals, int n)
	{	int tempL = reals[0][1];
		for(int i = 1; i < n; i++)
			if(reals [i][1] > tempL)
				tempL = reals[i][1];
			return tempL;
	}

//***********************INPUT DATA

	public static int inputData(String[]names, double[][]reals, int[][]ints, Scanner inFile)
	{
		StringTokenizer st;
		String line;
		int i = 0;
		int m;

		while(i < names.length && inFile.hasNext()
		{ 	line = inFile.nextLine();
			st = new StringTokenizer(line);

			m = st.countTokens();
			{names[i] = st.nextToken();}

			ints[i][0] = Integer.parseInt(st.nextToken());
			reals[i][0] = Double.parseDouble(st.nextToken());
			ints[i][1] = Integer.parseInt(st.nextToken());
			reals[i][1] = Double. parseDouble(st.nextTOken());
			i++;
		}
			return i;
	}

//***********************LEFTOVER

		{ public static int leftover(Scanner InFile)}
		  {	
		  	int left = 0; 
		  	while(inFile.hasNext())
		  	{
		  	left++;
		  	inFile.nextLine();
		  	}
		  	return left;
		  }

//********************CALCULATE AVERAGE

	public static double calcAvg(int[i][0] ints, int n)
	{ double Y = 0;
		for(int i = 0; i < n; i++)
			Y += ints[i][0];
			return Y/n;
	}

//***********************OUTPUT

	public static void output(String[]names, int[][]ints, double[][]reals, PrintWriter outFile, int left, int n)
	{	
		for(int i = 0; i < n; i++)
		{ 
			outFile.println(names[i] + " " + ints[i][0] + " " + reals[i][0] + " " + ints[i][1] + " " + reals[i][1]); 
		}
			outFile.println("number of data lines processed: " + n);
			outFile.println("number of values not processed: " + left);
		}
//************************KEY SEARCH

	public static void keySearch(String[]names, int[][]ints, int n)
	{
		Scanner console = new Scanner(System.in);
		System.out.println("Input Name: ");
		String name = console.nextLine();

		while(name.charAt(0) != '#')
		{	
			boolean found = false;
			for(int i = 0; i < n; i++)
				if(name.comparedTo(names[i] == 0)
		{
			System.out.println(ints[i][0] + " " + ints[i][1]);
			found = true;
			break;
		}
			if(found == false)
			System.out.println("Input Name: ");
			name = console.nextLine();
		}
	}
}