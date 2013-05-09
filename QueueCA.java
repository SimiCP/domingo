// queue ADT implemented using a circular array
//  (holds Strings just for convenience)

import java.util.Random;

public class QueueCA
{
  private static int MAX = 1000;  // ignore running out of capacity issues

  private String[] a;  // array to hold the items
  private int n;    // number of items in the queue
  private int front, rear;

  public QueueCA()
  {
    a = new String[ MAX ];
    n = 0;
    rear = -1;
    front = 0;
  }

  public int size()
  {
    return n;
  }

  // if size is 0, too bad for the loser app!
  public String front()
  {
    return a[front];
  }

  // if size is MAX, too bad!
  public void add( String s )
  {
    rear = next(rear);
    a[rear] = s;
    n++;
  }

  // if size is 0, too bad!
  public void remove()
  {
    front = next(front);
    n--;
  }

  private int next( int x )
  {
    x++;
    if( x == MAX )
      x = 0;
    return x;
  }

  public String toString()
  {
    String s = "n = " + n + " front = " + front + " rear = " + rear + ", items: [";
    if( n==0 )
      return s + "]";
    else
    {
      for( int k=0; k<MAX; k++ )
      {
        s += a[k] + " ";
      }
      s += "]";
      return s;
    }
  }

  public static void main(String[] args)
  {
    QueueCA q = new QueueCA();
    
/*
    q.add("a");
    System.out.println( q );
    q.remove();
    System.out.println( q );
    q.add("b");
    System.out.println( q );

    System.exit(0);
*/

    // simulate endless arrivals and services:

    Random rng = new Random(1);
    long start = System.nanoTime();
    int step = 0;

    while( q.size() <= MAX )
    {
      step++;
      System.out.println(step);
//      System.out.println("Step " + step + " queue is " + q );
      if( rng.nextInt(2) == 0 )
      {// customer arrives
        String id = "C" + ( System.nanoTime() - start );       
        System.out.println( id + " arrives" );
        q.add( id );
      }
      else if( q.size() > 0 )
      {// customer gets waited on
        System.out.println("Waited on " + q.front() );
        q.remove();
      }

    }

  }

}
