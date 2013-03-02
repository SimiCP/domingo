public class Sack1
{
  // static variables:
  public final static int MAX = 10000;

  // IV's:
  private Block[] blocks;
  private int n;

  private int location;  // location where the last find operation succeeded
  private int cursor;  // current traversal location

public Sack1()
{
  blocks = new Block[MAX];
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
  location = -1;
  for( int k=0; k<n; k++ )
  {
    if( blocks[k].getKey().equals( key ) )
    {
      location = k;
    }
  }

  return location >= 0;
  
}

// return a reference to the block that was most recently found
// using the internal information about the find operation
public Block get()
{
  return blocks[location];
}

// remove the block that was most recently found
public void remove()
{
  blocks[ location ] = blocks[ n-1 ];
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
  blocks[ n ] = b;
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
  Block temp = blocks[cursor];
  cursor++;
  return temp;
}

}// Sack
