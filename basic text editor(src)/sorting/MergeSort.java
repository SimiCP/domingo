public class MergeSort
{
  public static void main(String[] args)
  {
    String[] a = {"platypus", "duck", "badger", "alligator",
                  "zebra", "aardvark", "echidna", "cat",
                  "dog", "fish", "-", "-", "-", "-" };
    String[] temp = new String[ a.length ];

    int n = 10;

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

  public static void mergeSort( String[] a, int first, int last, String[] temp )
  {
    if( first == last )
    {
      return;
    }
    else
    {// have two subproblems to solve, combine:

      int mid = (first+last)/2;

      mergeSort( a, first, mid, temp );
      mergeSort( a, mid+1, last, temp );

      merge( a, first, mid, mid+1, last, temp );
    }
  }

  // note:  last1 must be first2-1  for this to make sense
  public static void merge( String[] a, int first1, int last1,
                                        int first2, int last2,
                            String[] temp )
  {
    int top1=first1, top2=first2;

    int fd = first1;

    while( top1<=last1 || top2<=last2 )
    {// put the smaller item facedown

      if( ( top1<=last1 && top2<=last2 && a[top1].compareTo(a[top2]) <= 0 ) ||
          ( last2<top2 )
         
        )
      {
        temp[ fd ] = a[top1];
        top1++;
        fd++;        
      }
      else if( ( top2<=last2 && top1<=last1 && a[top2].compareTo(a[top1])<=0 ) ||
               ( last1<top1 )
             )
      {
        temp[ fd ] = a[top2];
        top2++;
        fd++;
      }
      else
      {
        System.out.println("Jerry was hopelessly wrong");
        System.exit(1);        
      }
    }

    // copy temp range back into a:
    for( int k=first1; k<=last2; k++ )
      a[k]=temp[k];

  }
 
  public static void selSort( String[] a, int n )
  {
    for( int start=0; start<n; start++ )
    {
      // find location of the smallest in unsorted range:
      int champLoc = start;
      for( int k=start+1; k<n; k++ )
      {
        if( a[k].compareTo( a[champLoc] ) < 0 )
        {
          champLoc = k;
        }
      }
      
      // swap a[champLoc] with a[start]:
      String temp = a[champLoc];
      a[champLoc] = a[start];
      a[start] = temp;

    }
  }

}
