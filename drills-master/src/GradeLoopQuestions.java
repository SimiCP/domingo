

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import framework.Grader;
import framework.Grader.IncorrectAnswer;

/**
 *
 * @author Josh Gillham
 * @version 3-18-13
 */
public class GradeLoopQuestions extends Grader {
    static public void main( String[] args ) {
        int score = grade();
        System.out.printf( "You got %d out of %d.\n", score, possiblePoints );
    }
    static public int grade() {
        int result = 0;
        possiblePoints = 0;
        try {
            ++possiblePoints;
            test_outputCount101();
            ++result;
            System.out.println( "test_outputCount101 successful!" );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
        return result;
    }
        
    static public void test_outputCount101() throws IncorrectAnswer {
        PrintStream sysDefault = System.out;
        try {
            int[] inputs = { 0, 1, 5, 7 };
            for ( int input : inputs )
            {
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                System.setOut( new PrintStream( result ) );
                
                CS1.LoopQuestions.outputCount101( input );
                String actual = result.toString();
                StringBuilder expectedWin = new StringBuilder();
                StringBuilder expectedLinux = new StringBuilder();
                for ( int i = 1; i <= input; ++i ) {
                    expectedWin.append( i );
                    expectedLinux.append( i );
                    expectedWin.append( "\r\n" );
                    expectedLinux.append( '\n' );
                }

                if ( !actual.equals( expectedWin.toString() ) &&
                !actual.equals( expectedLinux.toString() ) ) {
                    throw new IncorrectAnswer( String.format( 
                        "Bad answer: for n = %d, the answer should be \"%s\""
                        +
                        " but was \"%s\".",
                        input, expectedLinux.toString(),
                        actual ) );
                }
            }
        }
        finally {
            System.setOut( sysDefault );
        }
    }    
}
