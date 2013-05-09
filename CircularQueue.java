public class CircularQueue
{
  private static int MAX = 100;

  private String[] items;
  private int front, rear;
  private int n;

  public CircularQueue()
  {
    items = new String[ MAX ];
    n = 0;
    front = 0;
    rear = -1;
  }

  public void add( String s )
  {
    rear = advance( rear );
    items[rear] = s;
    n++;
  }

  // if size is 0, too bad for the foolish app that
  // calls this!
  public String front()
  {
    return items[front];    
  }

  public void remove()
  {
    items[front] = null;
    front = advance( front );
    n--;
  }

  public int size()
  {
    return n;
  }

  private int advance( int x )
  {
    x++;
    if( x == MAX )
      x = 0;
    return x;
  }

  public static void main(String[] args)
  {
    CircularQueue q = new CircularQueue();
    java.util.Random rng = new java.util.Random(1);

    long start = System.nanoTime();
    int count = 0;

    while( q.size() < MAX )
    {
      count++;
      System.out.println("Transaction # " + count );
      q.display();

      if( rng.nextInt(2) == 0 )
      {// add an item
        String item = "Item" + ((System.nanoTime() - start)/1000);
        System.out.println("add " + item );
        q.add( item );
      }
      else
      {// remove an item
        if( q.size() > 0 )
        {// really remove an item
          System.out.println("removed " + q.front() );
          q.remove();
        }
        else
          System.out.println("wanted to remove, but queue was empty");
      }
    }

  }

  private void display()
  {
    System.out.println("n: " + n + " front: " + front + " rear: " + rear );
    for( int k=0; k<MAX; k++ )
      System.out.print( items[k] + " " );
    System.out.println("\n-----------------------");
  }

}
