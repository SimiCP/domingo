public class Sack3
{
  // static variables:
  public final static int M = 11;

  // IV's:
  private HTNode[] a; 
  private int n;

  // for holding find results:
  private int location;  // index in a where key was found
  private HTNode previous;

  // for holding traversal info:
  private int travLoc;
  private HTNode travCurrent;
  private int travCount; 

public Sack3()
{
  n = 0;
  a = new HTNode[ M ];
  /* don't need to do
  for( int k=0; k<M; k++ )
    a[k] = null;
  */
}

  public int h( Key key )
  {
    long temp = (7*key.x * 13*key.y) + 5;
    if( temp < 0 )
      temp = -temp;
    return (int) (temp % M);
  }

// determine whether there is a block in the sack with the given key
// (and gather internal information so that get and remove can be
//  efficiently performed immediately after the find operation, 
//  if desired)
public boolean find( Key key )
{
  int index = h( key );

  System.out.println("call find with key " + key + " got index = " + index );

  if( a[index] == null )
    return false;

  // there is a list stored at index, but does it contain our key?
  
  HTNode current = a[index];
  System.out.println( "node stored at index is " + current + " data is " + current.data.getKey());

  if( current.data.getKey().equals( key ) )
  {// found the desired key in first node
 System.out.println("found key in first node");
    location = index;
    previous = null;
    return true;
  }

  while( current.next != null && !current.next.data.equals( key ) )
    current = current.next;

  if( current.next != null )
  {
    location = index;
    previous = current;
    return true;
  }
  else
  {
    return false;
  }

}

// return a reference to the block that was most recently found
// using the internal information about the find operation
public Block get()
{
// System.out.println("previous = " + previous + " location = " + location );
  if( previous == null )
  {// we found the desired key in the first node
    return a[location].data;
  }
  else
  {// previous actually points to the node before the target node
    return previous.next.data;
  }
}

// remove the block that was most recently found
public void remove()
{
  if( previous == null )
  {// need to remove the first node at a[location]
    a[location] = a[location].next;
  }
  else
  {// need to remove the node after previous
    previous.next = previous.next.next;
  }

  n--;
}

// return the number of blocks in the sack
public int size()
{
  return n;
}

// add the given block to the sack
public void add( Block b )
{
  int index = h( b.getKey() );
  
// System.out.println("add " + b + " to index " + index );
  if( a[index] == null )
  {// adding the first node in this slot
    a[index] = new HTNode( b );
  }
  else
  {// adding a new node to the linked list in this slot
    HTNode temp = new HTNode( b );
    temp.next = a[index];
    a[index] = temp;   
  }

  n++;
}

// prepare the sack to be traversed
public void initForTraverse()
{
  travCount = 0;

  if( n == 0 )
  {
    return;
  }

  travLoc = 0;
  while( a[travLoc] == null )
    travLoc++;

  travCurrent = a[ travLoc ];
 
}

// return whether the sack has a next block in the traversal
// (returns false if the last block in the traversal has
//   already been reported)
public boolean hasNext()
{
  return travCount < n;
}

// return a reference to the next block in the traversal
public Block next()
{
  Block temp = travCurrent.data;
  travCount++;

  // get ready for next call to next():
  travCurrent = travCurrent.next;

  if( travCurrent == null && travCount < n )
  {// reached the end of a linked list, must advance travLoc

    travLoc++;

    while( a[travLoc] == null )
      travLoc++;
  
    travCurrent = a[travLoc];
    
  }

  return temp;
}

}// Sack
