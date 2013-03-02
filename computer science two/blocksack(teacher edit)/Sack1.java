public class Sack1
{
  private static int MAX = 10000;

  // Instance variables:
  private Block[] a;
  private int n;
  
  private int location;
  private int cursor;

  public Sack1()
  {
    a = new Block[ MAX ];
    n = 0;
    location = -1;
    cursor = -1;
  }

// determine whether there is a block in the sack with the given key
// (and gather internal information so that get and remove can be
//  efficiently performed immediately after the find operation, 
//  if desired)
  public boolean find( Key key )
  {
    for( int k=0; k<n; k++ )
    {
      // should use .equals, but want compareTo ready for Ex2
      if( a[k].getKey().compareTo(key) == 0 )
      {
        location = k;
        return true;
      }
    }

    location = -1;
    return false;
  }

  // return a reference to the block that was most recently found
  public Block get()
  {
    return a[location];
  }

  // remove the block that was most recently found
  public void remove()
  {
    a[location] = a[n-1];
    location = -1;
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
    a[n] = b;
    n++;
  }

  // prepare the sack to be traversed
  public void initForTraverse()
  {
    cursor = 0;
  }

  // return whether the sack has a next block in the traversal
  // (returns false if the last block in the traversal has
  //   already been reported)
  public boolean hasNext()
  {
    return cursor < n;
  }

  // return a reference to the next block in the traversal
  public Block next()
  {
/*  really, really awful:
    return a[cursor++];
*/
/*  kind of bad:
    cursor++;
    return a[cursor-1];
*/
    Block temp = a[cursor];
    cursor++;
    return temp;
  }

}
