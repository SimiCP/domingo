import java.util.ArrayList;

public class ArrayListDriver
{ 
	public static void main( String [] args)
		{
		ArrayList<String> songs = new ArrayList<String>();
		
		songs.add( "Open heart surgery" );
		songs.add( "Nevertheless" );
		songs.add( "Thoughts of you" );
		songs.add( "The devil may care" );
		
		for( int i = 0; i < songs.size(); i++)
			{
			System.out.println( songs.get( i ) );
			}// end for
			
		System.out.println( "meher django & gilka juno");
		for( String s : songs)
			{
			System.out.println( s );
			
			}// end for each
			
		} // end main
	
	
} // end class ArrayListDriver
