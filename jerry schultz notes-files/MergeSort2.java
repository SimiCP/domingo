import java.util.Random;

public class MergeSort2
{
  private static Random randy = new Random( 1 );

  public static void main(String[] args)
  {
    Integer[] a;
    Integer[] temp;
    Integer[] copy;
    double total;

    for( int testSize=1; testSize<=Math.pow(2,20)+1; testSize *= 2 )
    {
      System.out.println("Doing some tests of mergesort of size " + testSize );


      total = 0;

      for( int testNum=1; testNum<=100; testNum++ )
      {
        // generate random a:
        a = new Integer[testSize];
        temp = new Integer[testSize];
        copy = new Integer[testSize];

        for( int j=0; j<testSize; j++ )
        {
          a[j] = randy.nextInt( 100000 );
          copy[j] = a[j];
        }

        //System.out.println("sorting " );
        //show( a, a.length );

        long start = System.nanoTime();
        mergeSort( a, 0, testSize-1, temp );
        long stop = System.nanoTime();
        total += (stop-start);

        // check( a, copy );

      }// do 100 test cases
     
      System.out.println("100 cases took average of " + (total/100) );

    }// do testSize 1 through 100

  }// check

  private static void check( Integer[] a, Integer[] copy )
  {
    // is a sorted?
    for( int k=0; k<a.length-1; k++ )
      if( a[k] > a[k+1] )
      {
        System.out.println("failure!");
        System.out.println("allegedly sorted list: ");
        show( a, a.length );
        System.out.println("original list: ");
        show( copy, copy.length );
        System.exit(1);
      }

    // is a a permuted version of copy?
    for( int k=0; k<copy.length; k++ )
    {
      // search for copy[k] in a:
      boolean found = false;
      for( int j=0; j<a.length; j++ )
      {
        if( copy[k] == a[j] )
          found = true;
      }

      if( ! found )
      {
        System.out.println("you have brought great shame to your class!");
        System.out.println("allegedly sorted list: ");
        show( a, a.length );
        System.out.println("original list: ");
        show( copy, copy.length );
        System.exit(1);
      }
 
    }

  }

  public static void show( Integer[] a, int n )
  {
    for( int k=0; k<n; k++ )
      System.out.print( a[k] + " " );
    System.out.println();
  }

  public static void mergeSort( Integer[] a, int first, int last, Integer[] temp )
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
  public static void merge( Integer[] a, int first1, int last1,
                                        int first2, int last2,
                            Integer[] temp )
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
 
  public static void selSort( Integer[] a, int n )
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
      Integer temp = a[champLoc];
      a[champLoc] = a[start];
      a[start] = temp;

    }
  }

}
