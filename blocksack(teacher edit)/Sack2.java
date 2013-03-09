//===========================================================================================
// Homework #2 ..sack2
// with Matthew Bird (TTH Class), Brunno Putnam (MW Class)
// 3/8/2013 
// collaborated with Megan and Anthony from (TTH) for researching assignment
//===========================================================================================

public class Sack2
{
	private final static int MAX = 10000;
	private Block[] blocks;
	private int n;
	private int location;
	private int cursor;
 
	public Sack2()
	{
		blocks = new Block[MAX];
		n = 0;
		location = -1;
		cursor = -1;
	}
  
	public boolean find( Key key ) //set location
	{
		location = -1;
		Answer answer = this.binarySearch( 0, n - 1, key );
		if( answer.found )
		{
			location = answer.location;
		}
		return location >= 0;
	}

	public Block get() // return item at location
	{
		return blocks[location];
	}

	public void remove() // remove item at location
	{
		for( int i = location; i < n; i++ )
		{
			blocks[ i ] = blocks [ i + 1 ];
		}
		n--;
	}

	public int size() // return sack size
	{
		return n;
	}

	public void add( Block b ) // add Key to sack
	{   
		Key key =  b.getKey(); //for example, key == "food"
		int last = n - 1;
		Answer answer = this.binarySearch( 0, last, key );
		if( !answer.found )
		{
			for( int i = n -1; i >= answer.location; i-- )
			{
				blocks[ i + 1 ] = blocks[ i ];
			}
		blocks[ answer.location ] = b;
		n++;
		}
	}

	public void initForTraverse() // initialization
	{
			cursor = 0;
	}

	public boolean hasNext() // does the sack have a next item?
	{
		return cursor < n;
	}

	public Block next() // next block in the sack
	{
		Block temp = blocks[cursor];
		cursor++;
		return temp;
	}

	private Answer binarySearch( int first, int last, Key target ) // Binary Search
	{
		if( first == last )
		{
			if( blocks[first].getKey().compareTo( target ) == 0 )
			{
				return new Answer( true, first );
			}
			else if( blocks[first].getKey().compareTo( target ) < 0  )
			{
				return new Answer( false, last+1 );
			}
			else // a[first] > target
			{
				return new Answer( false, first );
			}
		}
		else if( last < first )
		{
			return new Answer( false, first );
		}

		else
		{
			int mid = (first+last)/2;
			if( blocks[mid].getKey().compareTo( target ) == 0 )
			{
				return new Answer( true, mid );
			}
			else if( blocks[mid].getKey().compareTo( target ) < 0 )
			{
				return binarySearch( mid+1, last, target );
			}
			else // a[mid] > target
			{
				return binarySearch( first, mid-1, target );
			}
		}
  }
}