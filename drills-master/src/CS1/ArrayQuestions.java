package CS1;

/*
ANSWERING TRY ONE
*/


/**
 *
 * @author domingo flores
 */
public class ArrayQuestions extends framework.Quiz {
    
    /**
     * Question #A.1)
     * The method returns the nth element of the array.
     * 
     * @param array is the array to look through.
     * @param n is the index of the element to grab
     * 
     * @return the value of the nth element.
     */
    public static int getElement101( int[] array, int n) {
       return array[n];
    }
    
    /**
     * Question #A.2)
     * The method returns the element after the nth element of the array.
     * 
     * @param array is the array to look through.
     * @param n is the index of the element to grab
     * 
     * @return the value of the element after nth element.
     */
    public static int getElement102( int[] array, int n) {
        return array[n+1];
    }
    
    /**
     * Question #A.3)
     * The method returns the element before the nth element of the array.
     * 
     * @param array is the array to look through.
     * @param n is the index of the element to grab
     * 
     * @return the value of the element before nth element.
     */
    public static int getElement103( int[] array, int n) {
        return array[n-1];
    }
    
    /**
     * Question #B.1)
     * The method returns a new array with every other element starting with the
     *  2nd element. For example, for the array { 3, 5, 7 } the return is { 5 }
     *  and for { 6, 7, 2, 3 } the return is { 7, 3 }.
     * 
     * @param array is the array to look through.
     * 
     * @return the new array with the even elements.
     */
    public static int[] changeArray101( int[] array) {
        int[] result = new int [array.length/2];
        for(int i=1; i < array.length; i+=2)
        {
            result[i/2] = array[i];
        }
        {
            return result;
        }
    }
    
    /**
     * Question #B.2)
     * The method returns a new array with every other element starting with the
     *  1st element. For example, for the array { 3, 5, 7 } the return is 
     *  { 3, 7 } and for { 6, 7, 2, 3 } the return is { 6, 2 }. 
     * @param array is the array to look through.
     * 
     * @return the new array with the odd elements.
     */
    public static int[] changeArray102( int[] array) {
        int[] result = new int [ (array.length + 1) /2];
        for(int i=0; i < array.length; i+=2)
        {
            result[i/2] = array[i];
        }
        return result;
        }
    
    /**
     * Question #C.1)
     * The method returns a new array which is the combination of two other 
     *  arrays. For example, if the first array is { 5, 15, 9 } and the second 
     *  array is { 7, 9, 11 }, then the result will be { 5, 15, 9, 7, 9, 11 }. 
     * 
     * @param array is the array to look through.
     * 
     * @return the new combination of arrays.
     */
    public static int[] combineArrays( int[] array1, int[] array2 ) {
        int[] result = new int[array1.length + array2.length];
        for(int i=0; i<array1.length; i++){
            result[i] = array1[i];
        }
        for( int buffer = array1.length, i=0; i< array2.length; i++, buffer++){
            result[buffer] = array2[i];
        } return result;
    } 

    
    
    /**
     * Question #D.1)
     * The method modifies an array by adding a number n to each element in the 
     *  array. For example, if n = 3 and the array is { 2, 1, 5, 7 } then the 
     *  result will be { 5, 4, 8, 10 }.
     * 
     * @param array the array to modify.
     */
    public static void incrementArray( int[] array, int n ) {
        //TODO delete the line below and write your solution.
        throw new UnansweredQuestionException();
    }
    
    /**
     * Question #E.1)
     * The method return the sum of an array. For example, an array of { 14, 2
     *  8, 6, 3 } should return 33.
     * 
     * @param array is the array to look through.
     * 
     * @return the sum of the array.
     */
    public static int sumArray( int[] array ) {
        //TODO delete the line below and write your solution.
        throw new UnansweredQuestionException();
    }
    
    /**
     * Question #F.1)
     * The method return the maximum value of an array. For example, if there is
     *  an array with { 4, 5, 2, 3 }, then the maximum will be 5.
     * 
     * @param array is the array to look through.
     * 
     * @return the maximum value of an array.
     */
    public static int getArrayMax( int[] array ) {
        //TODO delete the line below and write your solution.
        throw new UnansweredQuestionException();
    }
    
    /**
     * Question #F.2)
     * The method returns the minimum value of an array. For example, if there
     *  is an array with { 11, 17, 19, 3, 4 } the result will be 3.
     * 
     * @param array is the array to look through.
     * 
     * @return the minimum value of an array.
     */
    public static int getArrayMin( int[] array ) {
        //TODO delete the line below and write your solution.
        throw new UnansweredQuestionException();
    }
}
