/*  this little application takes a command line argument of a unix file
and produces the same file with .dos appended to the file name
and with character # 13's appended to the end of
each line so that it is a Windows file (so notepad works)

To turn a unix file named Sample.java to Windows, do

   jcr ToDOS Sample.java

and it will produce   Sample.java.dos
  (then manually copy it back to Sample.java)
*/

import java.io.*;

public class ToDOS
{
  public static void main(String[] args) throws Exception
  {
    BufferedReader input = new BufferedReader( new FileReader( args[0] ) );
    PrintWriter output = new PrintWriter( new FileWriter( args[0] + ".dos" ));

    int x;

    do{
      x = input.read();
      if( x != -1 )
      {
        if( x == 10 )
         output.print( (char) 13 );
        output.print( (char) x );
      }
    }while( x != -1 );

    input.close();
    output.close();
  }
}
