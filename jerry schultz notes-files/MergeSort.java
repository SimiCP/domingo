public class MergeSort
{
  public static void main(String[] args)
  {
    String[] a = {"platypus", "duck", "badger", "alligator",
                  "zebra", "aardvark", "echidna", "cat",
                  "dog", "-", "-", "-", "-" };
    int n = 9;
    String[] temp = new String[ n ];

    System.out.print("initial array: " );
    show(a,n);
    System.out.print("\n");

    mergeSort( a, 0, n-1, temp );

    System.out.print("sorted array: " );
    show(a,n);
    System.out.print("\n");
  }

  public static void show( String[] a, int n )
  {
    for( int k=0; k<n; k++ )
      System.out.print( a[k] + " " );
  }

  private static void mergeSort( String[] a, int first, int last, String[] temp )
  {
    if( first==last  )
    {
      return;
    }
    else
    {
      int mid = (first+last)/2;
     
      mergeSort( a, first, mid, temp );
      mergeSort( a, mid+1, last, temp );

      merge( a, first, mid, last, temp );

    }
  }

  private static void merge( String[] a, int first, int mid, int last, String[] temp )
  {
    int top1 = first;
    int top2 = mid+1;

    int next = first;

    while( top1<=mid || top2<=last )
    {// copy next smallest item down to temp

      if( top2>last || ( top1<=mid && a[top1].compareTo( a[top2] ) < 0 )  )
      {// a[top1] beats a[top2] or empty
        temp[next] = a[top1];
        top1++;
        next++;
      }
      else
      {// a[top1] doesn't beat a[top2]
        temp[next] = a[top2];
        top2++;
        next++;
      }
     
    }

    // copy back from temp to a:
    for( int k=first; k<=last; k++ )
      a[k] = temp[k];

  }// merge

}
