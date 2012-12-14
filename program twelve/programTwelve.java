// Brunno Putnam
// Program #12, CS 1050, Fall 2012, MW
// Java(JDK 7u9) Platform SE binary, USUS UX31E, windows 7

import java.io.*;
import java.util.*;

public class programTwelve
{
	public static void main(String[]Args) throws Exception
	{ 	 Scanner inFile = new Scanner(new FileReader("data.txt"));
		 PrintWriter outFile = new PrintWriter(System.out);
		 inFile.useDelimiter( "\n" );
		 ArrayList <student> result = processFile(inFile);
		 inFile = new Scanner(new FileReader("data.txt"));
		 output(inFile, outFile, result); 
	}
	
	public static ArrayList <student> processFile(Scanner inFile, PrintWriter outFile) 
	{	 
		 ArrayList <student> report = new ArrayList <student>();
		 student data = new student();
		 StringTokenizer st;
		 StringTokenizer st2;  
		 String students;
		 String name;
		 String line;
		 int grade = 0;
		 int m;

		 
		 while(inFile.hasNext())
		 {
			 line = inFile.nextLine();
			 outFile.println(line);
			 st = new StringTokenizer(line, "#");
			 
			 name = st.nextToken(); 
			 students = st.nextToken();
			 st2 = new StringTokenizer(students);
			 s = new student();
			 
	
			 while(st2.hasMoreTokens())
			 {
				credit = Integer.parseInt(st2.nextToken());
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
				 default : w = 0;
				} // End of switch
				sum += w * credit; 
			   divide += gradeLetter;
				System.out.println(data.gpa);
				System.out.println(data.hrspassed);
			} // end of while
		} // End of first while
		return report;
	} // End of the method
		public static void output(Scanner inFile, PrintWriter outFile, ArrayList <student> result) 
			{	outFile.println("NAME,          GPA,         HOURS EARNED");
				outFile.println(); 
				while(inFile.hasNext())
					outFile.println(inFile.next()); 	 
				Iterator<student> i = result.iterator();
				student data = i.next();
				outFile.println(i.next());
				outFile.println("number of students" + result.size());
				outFile.println("the average GPA");
				outFile.println("total of hours passed" + data.hrspassed);
	}
} // End of the class