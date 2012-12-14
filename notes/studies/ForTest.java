public class ForTest
{
	public static void main( String[] args)
	{
	//method
	int[] randomNumbers = new int[6];
	//for loop to put numbers in the array
	for( int i=0; i<randomNumbers.length; i++)
	{ // (int) is a cast // the i is only used between the curly braces
	  // the variable only lives in the curly braces so you can use the [i] again
	randomNumbers[i] = (int) (Math.random()*55 ); // Math.random gives you numbers from 0 .99// double scale by multiplying
	} // end for
	
	//for loop to print the numbers
	for( int i=0; i<randomNumbers.length; i++)
	{
	System.out.println( randomNumbers[i] );
	} // end for
	
} // end main

} // end main