public class HeapSort
{
  public static void main(String[] args)
  {
    String[] a = {"platypus", "duck", "badger", "alligator",
                  "zebra", "aardvark", "echidna", "cat",
                  "dog", "fish", "-", "-", "-", "-" };
    int n = 10;

    System.out.print("initial array: " );
    show(a,n);
    System.out.print("\n");

    heapSort( a, n );

    System.out.print("sorted array: " );
    show(a,n);
    System.out.print("\n");
  }

  public static void show( String[] a, int n )
  {
    for( int k=0; k<n; k++ )
      System.out.print( a[k] + " " );
  }

  public static void heapSort( String[] a, int n )
  {
    // add the items in a back into a as a heap
    heapify( a, n );

    // remove each successive root item to the sorted list and let
    // replacement fall
    sortHeap( a, n );
  }

  // given n items in a, add them all into the heap
  // that is also stored in a
  private static void heapify( String[] a, int n)
  {
    // note:  starting wall at 1 instead of 0 by Monson theorem
    for( int wall=1; wall<n; wall++ )
    {// add a[wall] into the heap formed by a[0]..a[wall-1]:

      // k tracks the current index of the guy being added
      int k = wall;

      int p = (k-1)/2;

      while( k>0 && a[k].compareTo( a[p] ) > 0 )
      {// swap a[k] with its parent and update k
        // swap
        String temp = a[k];
        a[k] = a[p];
        a[p] = temp;

        // update k:
        k=p;
        p=(k-1)/2;
      }

    }

  }

  // transforms the heap in a[0]..a[n-1] into a sorted list
  private static void sortHeap( String[] a, int n )
  {
    for( int end=n-1; end>=1; end-- )
    {// move current root to end spot and let replacement drop
      // swap a[0] and a[end]:
      String temp = a[end];
      a[end] = a[0];
      a[0] = temp;
      
      // now a[0] holds smallish guy, let it drop:
      drop( a, end, 0 );

    }

  }

  // given index k that is a bad root of a heap, let that
  // bad root item drop
  private static void drop( String[] a, int end, int k )
  {
    int left = 2*k+1, right = 2*k+2;

    if( right < end )
    {// bad root has two children )
      // find larger of the two children
      int winner;
      if( a[left].compareTo( a[right] ) < 0 )
        winner = right;
      else
        winner = left;

      // see if root beats the bigger of the children:
      if( a[k].compareTo( a[winner] ) > 0 )
      {
        // done
      }
      else
      {
        String temp = a[k];
        a[k] = a[winner];
        a[winner]=temp;
        
        drop( a, end, winner );
        
      }
    }
    else if( right == end )
    {// bad root has only left child
    }
    else
    {// bad root has no children
      // heap below root is just the root, so not bad after all!
    }
    
  }

}
