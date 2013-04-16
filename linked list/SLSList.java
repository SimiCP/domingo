/*
  an SLSList is an object that holds a bunch of Strings (for now)
  in some order
*/

public class SLSList
{
  // instance variables:
  private Node head;  // holds reference to first node in the list
  private int n;  // the current number of items in the list

  private Node current;  // use this to keep track of hops

  // constructors:

  public SLSList()
  {
    n=0;
    head = null;
    current = null;
  }

  // instance methods:

  // starting from head, hop ahead number times
  private void hop( int number )
  {
    current = head;
    for( int k=1; k<=number; k++ )
    {
      current = current.next;
    }
  }

  // append the item s to the end of the list
  public void append( String s )
  {
    if( head == null )
    {// adding first node
      head = new Node( s );
    }
    else
    {
      hop( n-1 );   // make current point to the last item
      current.next = new Node(s);
      // could do:  current.next.next = null;  but don't need to
    }

    n++;
    
  }

  // insert the item s into the list at index,
  // shift the others
  public void insert( int index, String s )
  {
    if( ! (0<=index && index<=n) )
    {  System.out.println("using insert incorrectly"); System.exit(1); }
    
    if( index == 0 )
    {// adding a new first node
      Node temp = new Node(s);
      temp.next = head;
      head = temp;
    }
    else
    {
      hop( index-1 );
      Node temp = new Node( s );
      temp.next = current.next;
      current.next = temp;
    }

    n++;
  }

  // return the item in the given position
  public String get( int index )
  {
    hop( index );
    return current.data;
  }

  // remove the item in the given position
  public void remove( int index )
  {
    if( index == 0 )
    {
      head = head.next;
    }
    else
    {
      hop(index-1);
      current.next = current.next.next;
    }

    n--;
    
  }

  // replace the item in given position by the given item
  public void replace( int index, String s )
  {
    hop( index );
    current.data = s;
  }

  public int size()
  {
    return n;  
  }

  public void show( String message )
  {
    /*  baddish---O(n^2):
    for(int k=0; k<n; k++ )
      System.out.print( list.get(k) + " " );
    */

    System.out.print(message + " < ");
    current = head;
    while( current != null )
    {
      System.out.print( current.data + " " );
      current = current.next;
    }
    System.out.println(">");

  }

  public static void main(String[] args)
  {
    SLSList list = new SLSList();

    list.show("empty list:");

    list.insert( 0, "A" );

    list.append( "a" );

    list.append( "b" );
    list.append( "c" );
    list.append( "d" );
    list.append( "e" );

    list.show("list after append a,b,c,d,e:");

    list.insert( 0, "B" );
    list.insert( 2, "X" );
    list.insert( 5, "Y" );
    list.insert( 9, "Z" );

    list.show("after various inserts (BAXabYcdeZ):");

    System.out.println("testing get---see same list externally:");
    for( int k=0; k<list.size(); k++ )
      System.out.print( list.get(k) + " " );
    System.out.println();
    
    list.replace( 5, "-" );

    list.show("after replace (BAXab-cdeZ):");

    list.remove( 0 );
    list.remove( 4 );
    list.remove( list.size()-1 );

    list.show("after removes (AXabcde):");
  }

}
