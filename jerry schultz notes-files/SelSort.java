public class SelSort
{
  public static void main(String[] args)
  {
    int[] a = {7,31,429,8,-3,12,42,0,173,-123,-456,789};
    int n = 9;

    System.out.print("original array: ");
    display(a,n);
    System.out.print("\n");

    selSort( a, n );

    System.out.print("sorted array: ");
    display(a,n);
    System.out.print("\n");

  }

  private static void display( int[] a, int n )
  {
    for(int k=0; k<n; k++ )
      System.out.print( a[k]+ " " );
  }

  private static void selSort( int[] a, int n )
  {
    for( int start=0; start<n-1; start++ )
    {
      
      // find location of the minimum item from a[start]...a[n-1]

      int loc = start; // location of the smallest item
      for( int k=start+1; k<n; k++ )
      {
        if( a[k] < a[loc] )
          loc = k;
      }

      // swap items in positions start and loc:
      int temp = a[loc];
      a[loc] = a[start];
      a[start] = temp; 

    }
  }

}
