//QUESTION SIX

import java.util.*;
import java.io.*;

public class Q6
{ public static void main (String[]Args) throws Exception
	{ Scanner inFile = new Scanner (newFile("A:test.dat");
	  PrintWriter outFile = new PrintWriter("A:Report.txt");
	  outFile.println("Report");
	  
	  string line, name, msg;
	  int value, counter = 0, counter2= 0, sum = 0;
	  
	  StringTokenizer st;
	  
	  while(inFile.hasNext());
	  { line = inFile.nextLine();
	  	 st = new StringTokenizer(line);
		 
		 value = Integer.parseInt(st.nextToken());
		 name = st.NextToken();
		 while(st.hasMoreTokens());
		 name = name + "  " + stnextToken;
		 
		 if(value >= 89) msg = "GREAT";
		 	else if(value >= 65) msg = "Okay";
			counter++; sum += value;
			else msg = "Poor";
			
		outFile.println(name + "  " + value "  " + msg);
		counter2++;
	  }
	   
		outFile.println("names processed" + counter);
		outFile.println("values between 65 & 86 inclusive" + counter2);
		if( counter2 > 0)
		outFile.println("with average" + sum/counter);
		outFile.close();
	}
}
		
   
	
//QUESTION FIVE	
double sum = 0;
int counter = 0;
for(int i=0; i<list.length; i++)
if(list[i].num>0)
{System.outprintln(list[i].name + "  " + list[i].num);
counter++;
sum += list[i].num;}
if ( counter > 0 )
{ mean = sum/counter;
  System.out.println(" the average is " + sum/counter");
  else
  System.out.println(" NO VALUES TO AVERAGE ")}

  //QUESTION FOUR
  public static int findLargest( int[] B )
  { int tempL = B[0];
  	for (int i = 1; i = B.length; i++ )
  	if ( B[i] > tempL) 
  		 tempL = B[i];
  		 return tempL;
  }  