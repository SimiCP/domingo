/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package adrills;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 *
 * @author jgillham
 */
public class GradeLoopQuestions {
    static public void main( String[] args ) {
        try {
            test_outputCount101();
            System.out.println( "test_outputCount101 successful!" );
        }
        catch ( Exception e ) {
            e.printStackTrace();
        }
    }
        
    static public void test_outputCount101() throws Exception {
        PrintStream sysDefault = System.out;
        try {
            {
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                System.setOut( new PrintStream( result ) );
                
                LoopQuestions.outputCount101( 1 );
                String actual = result.toString("UTF8");

                if ( !actual.equals( "1\r\n" ) &&
                        !actual.equals( "1\n" ) ) {
                    throw new Exception( "Bad answer: yours was \"" + 
                        actual + "\"" );
                }
            }
            {
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                System.setOut( new PrintStream( result ) );
                
                LoopQuestions.outputCount101( 5 );
                String actual = result.toString("UTF8");

                if ( !actual.equals( "1\r\n2\r\n3\r\n4\r\n5\r\n" ) &&
                        !actual.equals( "1\n2\n3\n4\n5\n" ) ) {
                    throw new Exception( "Bad answer: yours was \"" + 
                        actual + "\"" );
                }
            }
            {
                ByteArrayOutputStream result = new ByteArrayOutputStream();
                System.setOut( new PrintStream( result ) );
                
                LoopQuestions.outputCount101( 7 );
                String actual = result.toString("UTF8");

                if ( !actual.equals( "1\r\n2\r\n3\r\n4\r\n5\r\n6\r\n7\r\n" ) &&
                        !actual.equals( "1\n2\n3\n4\n5\n6\n7\n" ) ) {
                    throw new Exception( "Bad answer: yours was \"" + 
                        actual + "\"" );
                }
            }
            
        }
        finally {
            System.setOut( sysDefault );
        }
    }    
}
