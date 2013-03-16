import java.util.Random;

public class HeapSort
{
  public static void main(String[] args)
  {
    int[] a = new int[100];
    int n = 9;
    Random rng = new Random(1);
    for( int k=0; k<n; k++ )
      a[k] = rng.nextInt(1000)+1;

    System.out.print("initial array: " );
    show(a,n);
    System.out.print("\n");

    heapSort( a, n );

    System.out.print("sorted array: " );
    show(a,n);
    System.out.print("\n");
  }

  public static void show( int[] a, int n )
  {
    for( int k=0; k<n; k++ )
      System.out.print( a[k] + " " );
  }

  private static void heapSort( int[] a, int n )
  {
    // heapify:
    for( int e=1; e<n; e++ )
      heapify( e, a );

    // sort the heap:
    for( int e=n; e>=1; e-- )
    {
      // swap:
      int temp = a[0];
      a[0] = a[e-1];
      a[e-1] = temp;
 
      drop( 0, a, e-1 );     
    }


  }

  // assuming everything from a[0]..a[e-1] is a heap, let the
  // item in a[e] rise
  private static void heapify( int e, int[] a )
  {
    if( e == 0 )
      return;

    int p = (e-1)/2;  // p is index of the parent of a[e]

    if( a[e] > a[ p ] )
    {
      // swap positions
      int temp = a[e];
      a[e] = a[p];
      a[p] = temp;

      // do recursive call
      heapify( p, a );
    }
  }

  // given index of the root of a bad tree in array a, ending at e,
  // fix it  ("bad" means the left and right sub-trees are good, but 
  // the root item is smaller than one of them, if it has two children)
  private static void drop( int root, int[] a, int e )
  {
    int left = 2*root+1, right = 2*root+2;

    if( left >= e )
    {// root has no children---is not a bad heap after all
    }   
    else if( right == e )
    {// root has just a left child
      // swap root and best and recurse:
      int temp = a[left];
      a[left] = a[root];
      a[root] = temp;
    }
    else
    {// root has two children

      int best;
      if( a[left] >= a[right] )
        best = left;
      else
        best = right;
        
      if( a[root] > a[best] )
      {
        System.out.println("This shouldn't have happened---major confusion!!!!");
        System.exit(1);
      }
      
      // swap root and best and recurse:
      int temp = a[best];
      a[best] = a[root];
      a[root] = temp;

      drop( best, a, e );

    }
  }

}
