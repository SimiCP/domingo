import java.util.ArrayList;

public class Sack23
{
  private Node23 root;  // reference to the root node
  private int n;    // number of items

  
  public Sack23()
  {
    n = 0;
    root = null;
  }

  public void add( String s )
  {
    if( root == null )
    {
      root = new Node23( s );
    }
    else
    {
      add( s, root );
    }    
  }

  private void add( String s, Node23 current )
  {
    if( current.data2 == null )
    {// current node is a 2-node
      if( current.left==null )
      {// at a leaf with only 1 data item, add a second one
        if( current.data1.compareTo(s) <= 0 )
          current.data2 = s;
        else
        {
          current.data2 = current.data1;
          current.data1 = s;
        }
      }
      else
      {// search on for a leaf
        if( current.data1.compareTo(s) <= 0 )
          add( s, current.right );
        else
          add( s, current.left );
      }
    }// current node is a 2-node
    else
    {// current node is a 3-node
      if( current.left==null )
      {// at a leaf with 2 data items
        if( current.data1.compareTo(s) <= 0 )
          current.data2 = s;
        else
        {
          current.data2 = current.data1;
          current.data1 = s;
        }
      }
      else
      {// search on for a leaf
        if( current.data1.compareTo(s) <= 0 )
          add( s, current.right );
        else
          add( s, current.left );

   .... oh, rats, this is too painful!

      }

    }// current node is a 3-node
  }

  public int size()
  {
    return n;
  }

  public boolean find( String key )
  {
    return find( root, null, false, key );    
  }

  // given start pointing to the root of a tree to be searched,
  //       previous pointing to the parent node of start,...
  //  (start or parent may be null)
  private boolean find( Node start, Node previous, boolean wentLeft,
                           String key )
  {
    if( start == null )
    {
      return false;
    }
    else
    {
      if( start.data.compareTo( key ) == 0 )
      {// found it!
        parent = previous;
        left = wentLeft;
        return true;
      }
      else if( start.data.compareTo( key ) > 0 )
      {// if it's here, it's in the left subtree
        return find( start.left, start, true, key );
      }
      else
      {// if it's here, it's in the right subtree
        return find( start.right, start, false, key );
      }
    }

  }

  public String get()
  {
    if( parent != null )
    {
      if( left )
      {
        return parent.left.data;
      }
      else
      {
        return parent.right.data;
      }
    }
    else
    {
      return root.data;
    }
  }

  public void remove()
  {
    // This is Exercise 4!  Oh no!
  }

  public void initForTraverse()
  {
    // do pre-order traversal of the tree into travList:
    travList = new ArrayList<String>();
    current = 0;
    preorderTraverse( root );
  }

  // add to travList all the items in the subtree rooted at start
  private void preorderTraverse( Node start )
  {
    if( start == null )
    {
      // nobody to add
    }
    else
    {
      travList.add( start.data );
      preorderTraverse( start.left );
      preorderTraverse( start.right );
    }
  }

  public boolean hasNext()
  {
    return current < travList.size();
  }

  public String next()
  {
    String temp = travList.get(current);
    current++;
    return temp;
  }

// -------------------- instance methods but not part of Sack ADT

  public void display( double x, double y, Camera cam, double spread,
                         double levelHeight )
  {
    int h = height( root );
    // System.out.println( "height is " + h );

    display( x, y, root, cam, Math.pow(2,h-1)*spread, levelHeight );
    
  }

  private void display( double x, double y, 
                        Node node, Camera cam, 
                        double width, double levelHeight )
  {
    if( node != null )
    {
      cam.drawCenteredText( node.data, x, y );

      double smidge1 = 0.75, smidge2 = 2.5;

      if( node.left != null )
        cam.drawLine( x, y-smidge1, x-width, y - levelHeight + smidge2 );

      if( node.right != null )
        cam.drawLine( x, y-smidge1, x+width, y - levelHeight + smidge2 );

      display( x - width, y - levelHeight, node.left, cam, 
                                           width/2, levelHeight );   
      display( x + width, y - levelHeight, node.right, cam, 
                                           width/2, levelHeight );   
    }
   
  }

  // find height of tree (number of levels in longest branch)
  // rooted at the given node
  public int height( Node node )
  {
    if( node == null )
      return 0;
    else if( node.left == null && node.right == null )
      return 1;
    else
    {
      int lh, rh;
      lh = height( node.left );
      rh = height( node.right );
      int h = 1 + (int) Math.max( lh, rh );
      return h;
    }
  }

  public static void main(String[] args)
  {
    Sack23 sack = new Sack23();
    sack.add( "pickles" );
    sack.add( "aardvark" );
    sack.add( "penguin" );
    sack.add( "armadillo" );
    sack.add( "porcupine" );
    sack.add( "yeti" );
    sack.add( "dog" );
    sack.add( "TeddyRoosevelt" );
    sack.add( "clownfish" );

    sack.initForTraverse();
    while( sack.hasNext() )
    {
      String w = sack.next();
      System.out.print( w + " " );
    }
    System.out.println();

    System.out.println("find bear:" + sack.find("bear") );

    System.out.println("find Teddy: " + sack.find("TeddyRoosevelt") );
    System.out.println("get gives: " + sack.get() );
    System.out.println("find pickles: " + sack.find("pickles") );
    System.out.println("get gives: " + sack.get() );
    System.out.println("find penguin: " + sack.find("penguin") );
    System.out.println("get gives: " + sack.get() );
    System.out.println("find yeti: " + sack.find("yeti") );
    System.out.println("get gives: " + sack.get() );
    System.out.println("find aardvark: " + sack.find("aardvark") );
    System.out.println("get gives: " + sack.get() );
    System.out.println("find dog: " + sack.find("dog") );
    System.out.println("get gives: " + sack.get() );

  }

}
