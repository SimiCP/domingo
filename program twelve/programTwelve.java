import java.io.*;
import java.util.*;

public class programTwelve
{
	public static void main(String[]Args) throws Exception
	{ 	 Scanner inFile = new Scanner(new FileReader("data.txt"));
		 PrintWriter outFile = new PrintWriter(System.out);
		 
		 student data = new student();
		 
		 StringTokenizer st;  
		 String students;
		 String line;
		 int m;
		 line = inFile.next();
		 st = new StringTokenizer(line, "#");
		 
		 m = st.countTokens(); 
		 System.out.println(st.countTokens());
		 students = st.nextToken();
		 new StringTokenizer(st.nextToken());
		 
		 while(st.hasMoreTokens())
		 {		
			data.hrspassed += Integer.parseInt(st.nextToken());
			char gradeLetter = st.nextToken().charAt(0);
			switch(gradeLetter)
			{case 'A' : 
			 data.gpa += 4;
			 break;
			 case 'B' :
			 data.gpa += 3;
			 break;
			 case 'C' :
			 data.gpa += 2;
			 break;
			 case 'D' :
			 data.gpa += 1;
			 break;
			 case 'F' :
			 data.gpa += 0;
			 break; 	
			}
			
			
			
		 }
}}
		 
		 
		 
		 
		 

