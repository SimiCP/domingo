import java.util.Arrays;
import framework.Grader;
import framework.Grader.IncorrectAnswer;

/**
 *
 * @author Josh Gillham
 * @version 3-18-13
 */
public class GradeArrayQuestions extends Grader {
    static public void main( String[] args ) {
        int score = grade();
        System.out.printf( "You got %d out of %d.\n", score, possiblePoints );
    }
    static public int grade() {
        int result = 0;
        possiblePoints = 0;
        try {
            ++possiblePoints;
            test_getElement101();
            ++result;
            System.out.println( "test_getElement101 successful!" );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ++possiblePoints;
            test_getElement102();
            ++result;
            System.out.println( "test_getElement102 successful!" );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ++possiblePoints;
            test_getElement103();
            ++result;
            System.out.println( "test_getElement103 successful!" );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        try {
            ++possiblePoints;
            test_changeArray101();
            ++result;
            System.out.println( "test_changeArray101 successful!" );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ++possiblePoints;
            test_changeArray102();
            ++result;
            System.out.println( "test_changeArray102 successful!" );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ++possiblePoints;
            test_combineArrays();
            ++result;
            System.out.println( "test_combineArrays successful!" );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ++possiblePoints;
            test_incrementArrays();
            ++result;
            System.out.println( "test_combineArrays successful!" );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ++possiblePoints;
            test_sumArray();
            ++result;
            System.out.println( "test_sumArray successful!" );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ++possiblePoints;
            test_getArrayMax();
            ++result;
            System.out.println( "test_getArrayMax successful!" );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            ++possiblePoints;
            test_getArrayMin();
            ++result;
            System.out.println( "test_getArrayMin successful!" );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
        
    static public void test_getElement101() throws IncorrectAnswer {
        int[] input1 = { 1, 6, 13, 8, 20 };
        for ( int i = 0; i < input1.length; ++i ) {
            int actual = CS1.ArrayQuestions.getElement101( input1, i );
            int expected = input1[i];
            if ( expected != actual ) {
                throw new IncorrectAnswer( String.format(
                    "Test failed: for array %s and n = %d. The result should " +
                    "be %d but was %d.",
                    Arrays.toString( input1 ), i, expected, actual ) );
            }
        }
        int[] badInput2 = { -1, input1.length };
        for ( int i = 0; i < badInput2.length; ++i ) {
            try {
                CS1.ArrayQuestions.getElement101( input1, badInput2[i] );
                throw new IncorrectAnswer( String.format(
                    "Test failed: for array %s and n = %d. Should have thrown "
                    +
                    "an ArrayIndexOutOfBoundsException.",
                    Arrays.toString( input1 ), badInput2[i] ) );
            }
            catch (ArrayIndexOutOfBoundsException e) {
                // Success.
            }
        }
    }
    static public void test_getElement102() throws IncorrectAnswer {
        int[] input1 = { 1, 6, 13, 8, 20 };
        for ( int i = -1; i < input1.length - 1; ++i ) {
            int actual = CS1.ArrayQuestions.getElement102( input1, i );
            int expected = input1[i + 1];
            if ( expected != actual ) {
                throw new IncorrectAnswer( String.format(
                    "Test failed: for array %s and n = %d. The result should " +
                    "be %d but was %d.",
                    Arrays.toString( input1 ), i, expected, actual ) );
            }
        }
        int[] badInput2 = { -2, input1.length - 1 };
        for ( int i = 0; i < badInput2.length; ++i ) {
            try {
                CS1.ArrayQuestions.getElement102( input1, badInput2[i] );
                throw new IncorrectAnswer( String.format(
                    "Test failed: for array %s and n = %d. Should have thrown "
                    +
                    "an ArrayIndexOutOfBoundsException.",
                    Arrays.toString( input1 ), badInput2[i] ) );
            }
            catch (ArrayIndexOutOfBoundsException e) {
                // Success.
            }
        }
    }
    static public void test_getElement103() throws IncorrectAnswer {
        int[] input1 = { 1, 6, 13, 8, 20 };
        for ( int i = 1; i < input1.length + 1; ++i ) {
            int actual = CS1.ArrayQuestions.getElement103( input1, i );
            int expected = input1[i - 1];
            if ( expected != actual ) {
                throw new IncorrectAnswer( String.format(
                    "Test failed: for array %s and n = %d. The result should " +
                    "be %d but was %d.",
                    Arrays.toString( input1 ), i, expected, actual ) );
            }
        }
        int[] badInput2 = { 0, input1.length + 1 };
        for ( int i = 0; i < badInput2.length; ++i ) {
            try {
                CS1.ArrayQuestions.getElement103( input1, badInput2[i] );
                throw new IncorrectAnswer( String.format(
                    "Test failed: for array %s and n = %d. Should have thrown "
                    +
                    "an ArrayIndexOutOfBoundsException.",
                    Arrays.toString( input1 ), badInput2[i] ) );
            }
            catch (ArrayIndexOutOfBoundsException e) {
                // Success.
            }
        }
    }
    
    static public void test_changeArray101() throws IncorrectAnswer {
        {
            int[] input = { 1, 2 };
            int[] expected = { 2 };
            int[] actual = CS1.ArrayQuestions.changeArray101( input );
            
            if ( expected.length != actual.length ) {
                throw new IncorrectAnswer( String.format( 
                    "Test failed: for the array %s the length should" +
                    " have been %d but was %d.",
                    Arrays.toString( input ), 
                    expected.length, actual.length ) );
            }
            for ( int i = 0; i < actual.length; ++i ) {
                if ( expected[i] != actual[i] ) {
                    throw new IncorrectAnswer( String.format(
                        "Test failed: for the array %s and index %d the result "
                        +
                        "should be %d but was %d.", 
                        Arrays.toString( input ), i, expected[i], actual[i] )
                        );
                }
            }
        }
        {
            int[] input = { 1, 6, 13, 8, 20 };
            int[] expected = { 6, 8 };
            int[] actual = CS1.ArrayQuestions.changeArray101( input );
            
            if ( expected.length != actual.length ) {
                throw new IncorrectAnswer( String.format( 
                    "Test failed: for the array %s the length should" +
                    " have been %d but was %d.",
                    Arrays.toString( input ), 
                    expected.length, actual.length ) );
            }
            for ( int i = 0; i < actual.length; ++i ) {
                if ( expected[i] != actual[i] ) {
                    throw new IncorrectAnswer( String.format(
                        "Test failed: for the array %s and index %d the result "
                        +
                        "should be %d but was %d.", 
                        Arrays.toString( input ), i, expected[i], actual[i] )
                        );
                }
            }
        }
    }
    static public void test_changeArray102() throws IncorrectAnswer {
        {
            int[] input = { 1 };
            int[] expected = { 1 };
            int[] actual = CS1.ArrayQuestions.changeArray102( input );
            
            if ( expected.length != actual.length ) {
                throw new IncorrectAnswer( String.format( 
                    "Test failed: for the array %s the length should" +
                    " have been %d but was %d.",
                    Arrays.toString( input ),
                    expected.length, actual.length ) );
            }
            for ( int i = 0; i < actual.length; ++i ) {
                if ( expected[i] != actual[i] ) {
                    throw new IncorrectAnswer( String.format(
                        "Test failed: for the array %s and index %d the result "
                        +
                        "should be %d but was %d.", 
                        Arrays.toString( input ), i, expected[i], actual[i] )
                        );
                }
            }
        }
        {
            int[] input = { 1, 2 };
            int[] expected = { 1 };
            int[] actual = CS1.ArrayQuestions.changeArray102( input );
            
            if ( expected.length != actual.length ) {
                throw new IncorrectAnswer( String.format( 
                    "Test failed: for the array %s the length should" +
                    " have been %d but was %d.",
                    Arrays.toString( input ),
                    expected.length, actual.length ) );
            }
            for ( int i = 0; i < actual.length; ++i ) {
                if ( expected[i] != actual[i] ) {
                    throw new IncorrectAnswer( String.format(
                        "Test failed: for the array %s and index %d the result "
                        +
                        "should be %d but was %d.", 
                        Arrays.toString( input ), i, expected[i], actual[i] )
                        );
                }
            }
        }
        {
            int[] input = { 1, 6, 13, 8, 20 };
            int[] expected = { 1, 13, 20 };
            int[] actual = CS1.ArrayQuestions.changeArray102( input );
            
            if ( expected.length != actual.length ) {
                throw new IncorrectAnswer( String.format( 
                    "Test failed: for the array %s the length should" +
                    " have been %d but was %d.",
                    Arrays.toString( input ),
                    expected.length, actual.length ) );
            }
            for ( int i = 0; i < actual.length; ++i ) {
                if ( expected[i] != actual[i] ) {
                    throw new IncorrectAnswer( String.format(
                        "Test failed: for the array %s and index %d the result "
                        +
                        "should be %d but was %d.", 
                        Arrays.toString( input ), i, expected[i], actual[i] )
                        );
                }
            }
        }        
    }
    static public void test_combineArrays() throws IncorrectAnswer {
        {
            int[] input1 = { 5, 6, 13 },
                  input2 = { 7, 8, 20 },
                  expected = { 5, 6, 13, 7, 8, 20 },
                  actual = CS1.ArrayQuestions.combineArrays( input1, input2 );
        
            if ( expected.length != actual.length ) {
                throw new IncorrectAnswer( String.format( 
                    "Test failed: for the array %s and %s the length should" +
                    " have been %d but was %d.",
                    Arrays.toString( input1 ), Arrays.toString( input2 ),
                    expected.length, actual.length ) );
            }
            for ( int i = 0; i < actual.length; ++i ) {
                if ( expected[i] != actual[i] ) {
                    throw new IncorrectAnswer( String.format(
                        "Test failed: for the array %s and index %d the result "
                        +
                        "should be %d but was %d.", 
                        Arrays.toString( input1 ), i, 
                        expected[i], actual[i] ) );
                }
            }
        }
        {
            int[] input1 = { 5 },
                  input2 = { 7, 8, 20 },
                  expected = { 5, 7, 8, 20 },
                  actual = CS1.ArrayQuestions.combineArrays( input1, input2 );
        
            if ( expected.length != actual.length ) {
                throw new IncorrectAnswer( String.format( 
                    "Test failed: for the array %s and %s the length should" +
                    " have been %d but was %d.",
                    Arrays.toString( input1 ), Arrays.toString( input2 ),
                    expected.length, actual.length ) );
            }
            for ( int i = 0; i < actual.length; ++i ) {
                if ( expected[i] != actual[i] ) {
                    throw new IncorrectAnswer( String.format(
                        "Test failed: for the array %s and index %d the result "
                        +
                        "should be %d but was %d.", 
                        Arrays.toString( input1 ), i, 
                        expected[i], actual[i] ) );
                }
            }
        }
    }
    static public void test_incrementArrays() throws IncorrectAnswer {
        {
            int[] input1 = { 5 },
                  expected = { 10 },
                  actual = input1;
            CS1.ArrayQuestions.incrementArray( input1, 5 );
        
            for ( int i = 0; i < actual.length; ++i ) {
                if ( expected[i] != actual[i] ) {
                    throw new IncorrectAnswer( String.format(
                        "Test failed: for the array %s and index %d the result "
                        +
                        "should be %d but was %d.", 
                        Arrays.toString( input1 ), i,
                        expected[i], actual[i] ) );
                }
            }
        }
        {
            int[] input1 = { 5, 6, 13 },
                  expected = { 7, 8, 15 },
                  actual = input1;
            CS1.ArrayQuestions.incrementArray( input1, 2 );
        
            for ( int i = 0; i < actual.length; ++i ) {
                if ( expected[i] != actual[i] ) {
                    throw new IncorrectAnswer( String.format(
                        "Test failed: for the array %s and index %d the result "
                        +
                        "should be %d but was %d.", 
                        Arrays.toString( input1 ), i,
                        expected[i], actual[i] ) );
                }
            }
        }
    }
    static public void test_sumArray() throws IncorrectAnswer {
        {
            int[] input1 = { 5 };
            int expected = 5,
                actual = CS1.ArrayQuestions.sumArray( input1 );
        
            if ( expected != actual ) {
                throw new IncorrectAnswer( String.format(
                    "Test failed: for the array %s the result should be %d but"
                    +
                    " was %d.", 
                    Arrays.toString( input1 ), expected, actual ) );
            }
        }
        {
            int[] input1 = { 5, 7, 2, 10, 3, 4 };
            int expected = 31,
                actual = CS1.ArrayQuestions.sumArray( input1 );
        
            if ( expected != actual ) {
                throw new IncorrectAnswer( String.format(
                    "Test failed: for the array %s the result should be %d but"
                    +
                    " was %d.", 
                    Arrays.toString( input1 ), expected, actual ) );
            }
        }
    }
    static public void test_getArrayMax() throws IncorrectAnswer {
        {
            int[] input1 = { 5 };
            int expected = 5,
                actual = CS1.ArrayQuestions.getArrayMax( input1 );
        
            if ( expected != actual ) {
                throw new IncorrectAnswer( String.format(
                    "Test failed: for the array %s the result should be %d but"
                    +
                    " was %d.", 
                    Arrays.toString( input1 ), expected, actual ) );
            }
        }
        {
            int[] input1 = { 5, 7, 3, 10, 2, 1 };
            int expected = 10,
                actual = CS1.ArrayQuestions.getArrayMax( input1 );
        
            if ( expected != actual ) {
                throw new IncorrectAnswer( String.format(
                    "Test failed: for the array %s the result should be %d but"
                    +
                    " was %d.", 
                    Arrays.toString( input1 ), expected, actual ) );
            }
        }
        {
            int[] input1 = { Integer.MIN_VALUE };
            int expected = Integer.MIN_VALUE,
                actual = CS1.ArrayQuestions.getArrayMax( input1 );
        
            if ( expected != actual ) {
                throw new IncorrectAnswer( String.format(
                    "Test failed: for the array %s the result should be %d but"
                    +
                    " was %d.", 
                    Arrays.toString( input1 ), expected, actual ) );
            }
        }
    }
    static public void test_getArrayMin() throws IncorrectAnswer {
        {
            int[] input1 = { 5 };
            int expected = 5,
                actual = CS1.ArrayQuestions.getArrayMin( input1 );
        
            if ( expected != actual ) {
                throw new IncorrectAnswer( String.format(
                    "Test failed: for the array %s the result should be %d but"
                    +
                    " was %d.", 
                    Arrays.toString( input1 ), expected, actual ) );
            }
        }
        {
            int[] input1 = { 5, 7, 2, 10, 3, 4 };
            int expected = 2,
                actual = CS1.ArrayQuestions.getArrayMin( input1 );
        
            if ( expected != actual ) {
                throw new IncorrectAnswer( String.format(
                    "Test failed: for the array %s the result should be %d but"
                    +
                    " was %d.", 
                    Arrays.toString( input1 ), expected, actual ) );
            }
        }
        {
            int[] input1 = { Integer.MAX_VALUE };
            int expected = Integer.MAX_VALUE,
                actual = CS1.ArrayQuestions.getArrayMin( input1 );
        
            if ( expected != actual ) {
                throw new IncorrectAnswer( String.format(
                    "Test failed: for the array %s the result should be %d but"
                    +
                    " was %d.", 
                    Arrays.toString( input1 ), expected, actual ) );
            }
        }
    }
}
