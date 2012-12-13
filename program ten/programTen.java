// Brunno Putnam
// Program #10, CS 1050, Fall 2012, MW
// Java(JDK 7u9) Platform SE binary, USUS UX31E, windows 7

import java.io.*;        	              
import java.text.*;							  
import java.util.Scanner;

public class programTen

{ public static void main (String[]Args) throws Exception
    { Scanner inFile = new Scanner(new File("info10.txt"));
        PrintWriter outFile = new PrintWriter("datasort10.txt");
        
        int[]A = new int[15];
        int n = inputData(A, inFile);
        int left = leftover(inFile);
        int[]S = new int [15];
        for(int i = 0; i < 15; i++)
            S[i] = i;
            
        outFile.println("  List");
        outputA(outFile, A, n, left);
        selectionSort(A, S, n);
        outFile.println("value                  original position");
        outputS(outFile, A, S, n);
        outFile.close();
    }
//**************************************************************
    public static int inputData(int[] A, Scanner inFile)
    {
        int i = 0;
        while(i < A.length && inFile.hasNext())
        {
            A[i] = inFile.nextInt();
            i++;
        }
        return i;
    }
//************************************************************
    public static void selectionSort(int[]A, int[]S, int n)
    {
        int i;
		  int temp;
		  int k;
		  int minI;
		  for(k = 0; k < n - 1; k++)
        {
            minI = k;
            for(i = k + 1; i < n; i++)
                {
                if(A[i] < A[minI])
                    minI = i;
                }
                temp = A[minI];
                A[minI] = A[k];
                A[k] = temp;
                temp = S[minI];
                S[minI] = S[k];
                S[k] = temp;
            }
        }
//***************************************************************
    public static void outputA(PrintWriter outFile, int[] A, int n, int left)
    {
        for(int i = 0; i < n; i++)
        outFile.println(A[i]);
        outFile.println("number of values in the array: " + n);
        outFile.println("the number of values that do not fit in array: " + left);
        outFile.println("\f"); 
    }
//****************************************************************
    public static void outputS(PrintWriter outFile, int[]A, int[]S, int n)
    {
        for(int i = 0; i < n; i++)
        outFile.println(A[i] + "                                 " + S[i]);
        outFile.println("Brunno Putnam");
    }
//*****************************************************************
    public static int leftover(Scanner inFile)
    { 
        int left = 0;
        while(inFile.hasNext())
        {
            inFile.nextInt();
            left++;
        }
        return left;
    }
}    