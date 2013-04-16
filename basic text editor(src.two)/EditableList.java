public class EditableList
{
  private DLLNode head, tail, cursor;
  private int n;
  
  public EditableList()
  {
     n=0;
     head = new DLLNode(null);
     tail = new DLLNode(null);
     cursor = new DLLNode(null);
     head.next = tail;
     head.prev = null;
     tail.prev = head;
     tail.next = null;
     cursor = tail;
  }
    
   // add s after the cursor node
  // point cursor to the new node
  // (if cursor is off the end do nothing)
  public void addAfter( String s )
  {
    if( cursor == tail )
    {// do nothing!
    }
    else
    {
      DLLNode temp = new DLLNode( s );
      temp.prev = cursor;
      temp.next = cursor.next;
      cursor.next.prev = temp;
      cursor.next = temp;
      cursor = temp;
      n++;
    }
  }

  // add s before the cursor and 
  // put the cursor on the new node
  public void add( String s )
  {

    if( cursor == head )
    {
        System.out.println("hit the head");
    }
    else
    {
      DLLNode temp = new DLLNode( s );
      temp.prev = cursor.prev;
      temp.next = cursor;
      cursor.prev.next = temp;
      cursor.prev = temp;
      cursor = temp;
      n++;
    }
  }

  public void up()
  {
         cursor = cursor.prev;
  }

  // move the cursor one node next,
  // allow it to point to the dummy tail
  public void down()
  {
      if (cursor.next == tail)
      {
        //do nothing
      }
      else
      {
         cursor = cursor.next;
      }
  }

  // return the data item x hops away from cursor node
  // (x can be 0 to get the current item, or positive or negative)
  // or return null if cursor points to unreal node
  public String show( int x )//
  {
    DLLNode temp = new DLLNode( null );
    temp = cursor;
    for ( int i = x ; i > 0 ; i-- )
    {
      if (temp.next == null)
      { 
        return temp.data;
      }
      temp = temp.next;
    }

    for ( int i = x ; i < 0 ; i++ )
    { 
      if (temp.prev == null)
      { 
         return temp.data; 
      }
      temp = temp.prev;
    }
    return temp.data;
  }

  public void replace( int p, String s )
  {
        first();
        p--;
        for (int i = p; i >= 0; i-- )
        {
            down();
        }
          DLLNode temp = new DLLNode( s );
          temp = cursor;
          temp.data = s;   
}

  public void first()
  {
    cursor = head.next;
  }

  public void last()
  {
    cursor = tail.prev;
  }

  public void remove( int p )//
  {
    if( cursor == null )
    {// do nothing!
    }
    else
    {
      first();
      p--;
      for (int i = p; p>0; p--)
      {
          down();
      }
      cursor.prev.next = cursor.next;
      cursor.next.prev = cursor.prev;
      cursor = cursor.next;
      n--;
    }
  }
    public void append( String s )
  {
      last();
      addAfter(s);
  }
  public void insert( int p, String s )
  {
      first();
      p--;
      for ( int i = p ; i > 0 ; i--)
      {
          down();
      }
      add(s);
  }
  public String get( int p )
  {
      first();
      for ( int i = p ; i > 0 ; i--)
      {
          if (cursor.next == null)
          {
              return null;
          }
          down();
      }
      return cursor.data;
  }
  public int size()
  {
    return n;
  }
    public String toString()
  {
    String s = "";
    first();
    DLLNode temp = new DLLNode( s );
        for (int i = 0 ; i < n ; i++)
        {
            temp = cursor;
            s += temp.data.toString() + ",";
            down();
        }
    return s;
  }
}
