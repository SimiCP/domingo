public class array2D
{
	public static void main( String[] args )
	{
	Time[][] myTimes = new Time[9][2]; ///two sets of brackets for array // set dimensions
	// NINE ROWS TWO COLUMNS
	// ROWS FIRST
	System.out.println( "Inputting times into the 2D array" );
	
	// nested for loop to typically use to fill up the array
	// the nested for loop again to print things out
	
	for( int row = 0; row < myTimes.length; row++)
		{
		for( int col = 0; col < myTimes[0].length; col++ )
		{
		myTimes[row][col] = new Time( row, col );
		
		}// end inner for
		}// end outer for
		
	System.out.println( "Printing times into the 2D array" );
	for( int row = 0; row < myTimes.length; row++)
		{
		for( int col = 0; col < myTimes[0].length; col++ )
		{
		System.out.println( myTimes[row][col] + "  ");
		
		}// end inner for
		System.out.println( "\n" );
		}// end outer for
		
	} // end method main
	
} // end class array2D