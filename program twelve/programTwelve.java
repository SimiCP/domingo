// Brunno Putnam
// Program #12, CS 1050, Fall 2012, MW
// Java(JDK 7u9) Platform SE binary, USUS UX31E, windows 7

import java.io.*;
import java.util.*;

public class programTwelve
{
	public static void main(String[]Args) throws Exception
	{ 	 
		 Scanner inFile = new Scanner(new FileReader("data.txt"));
		 PrintWriter outFile = new PrintWriter("report.txt");
		 inFile.useDelimiter( "\n" );
		 ArrayList <student> result = processFile(inFile, outFile);
		 inFile = new Scanner(new FileReader("data.txt"));
		 output(inFile, outFile, result); 
	}
	
	public static ArrayList <student> processFile(Scanner inFile, PrintWriter outFile) 
	{	 
		 ArrayList <student> report = new ArrayList <student>();

		 while(inFile.hasNext())
		 {
		 	 
			 double sum = 0;
			 
			 int classes = 0;
			 String line = inFile.nextLine();
			 outFile.println(line);
			 StringTokenizer st = new StringTokenizer(line, "#");
			 
		 	 String name = st.nextToken(); 
			 String students = st.nextToken();
		 	 StringTokenizer st2 = new StringTokenizer(students);
			 student s = new student();
			 
			 s.name = name;
	
			 while(st2.hasMoreTokens())
			 {
			 	int w = 0;
			 	
				int credit = Integer.parseInt(st2.nextToken());
				char gradeLetter = st2.nextToken().charAt(0);
				switch(gradeLetter)
				{
				 case 'A' : 
				 w = 4;
				 break;
				 case 'B' :
				 w = 3;
				 break;
				 case 'C' :
				 w = 2;
				 break;
				 case 'D' :
				 w = 1;
				 break;
				 case 'F' :
				 w = 0;
				 break;
				} // End of switch
				
				switch(gradeLetter)
				{
				 case 'A' :case 'B' :case 'C' :case 'D' :case 'F' :
				 	sum += w * credit;
					++classes;
					s.hrspassed += credit;
				} // End of switch
			} // ends of while
			if ( classes > 0 )
				s.gpa = sum / classes;
			
			report.add( s );
		} // End of first while
		return report;
	} // End of the method
		public static void output(Scanner inFile, PrintWriter outFile, ArrayList <student> result) 
			{	outFile.println();	
				outFile.println("NAME,      \t\t\t         GPA,        \t\t\t       HOURS EARNED");
				outFile.println(); 
				Iterator<student> i = result.iterator();
				int counter = 0;
				double totalgpa = 0;
				int credit = 0;
				System.out.println( i.hasNext() );
				while(i.hasNext())
				{ 	student data = i.next();
					outFile.println(data.name + "\t" + data.gpa + "\t\t\t\t\t\t\t\t\t" + data.hrspassed);
					counter++;
					totalgpa += data.gpa;
					credit += data.hrspassed;
				}
				totalgpa = totalgpa / counter;
				outFile.println("number of students " + result.size());
				outFile.println("the average GPA " + totalgpa );
				outFile.println("total of hours passed " + credit);
				outFile.close();
	}
} // End of the class