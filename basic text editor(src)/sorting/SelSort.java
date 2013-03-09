public class SelSort
{
  public static void main(String[] args)
  {
    String[] a = {"platypus", "duck", "badger", "alligator",
                  "zebra", "aardvark", "echidna", "cat",
                  "dog", "-", "-", "-", "-" };
    int n = 9;

    System.out.print("initial array: " );
    show(a,n);
    System.out.print("\n");

    selSort( a, n );

    System.out.print("sorted array: " );
    show(a,n);
    System.out.print("\n");
  }

  public static void show( String[] a, int n )
  {
    for( int k=0; k<n; k++ )
      System.out.print( a[k] + " " );
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
