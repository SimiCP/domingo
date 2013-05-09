public class SackBST
{
  private Node root;  // reference to the root node
  private int n;    // number of items

  private ArrayList<String> travList;
  private int current;

  public SackBST()
  {
    n = 0;
    root = null;
  }

  public void add( String s )
  {
    if( n == 0 )    // or    root==null
    {// adding first item
      root = new Node( s );
    }
    else
    {// already have at least the root node
      
      Node current = root;
      boolean done = false;

      while( !done )
      {
        if( s.compareTo( current.data ) < 0 )    
        {// s belongs on the left
          if( current.left != null )
            current = current.left;
          else
          {
            current.left = new Node( s );
            done = true;
          }
        }
        else
        {// s belongs on the right
          if( current.right != null )
            current = current.right;
          else
          {
            current.right = new Node( s );
            done = true;
          }
        }
      }
      
    }

    n++;

  }

  public int size()
  {
    return n;
  }

  public boolean find( String key)
  {
  	find( root, key );
	return true;			
  }
  private boolean find(Node start, String key)
  {
  	if(start == null)
	{// set unkown instance variables
		return false;
	}
  else
   {
  	  if(start.data.compareTo( key ) == 0)
	  {// found it!			
	  }
	  else if( start.data.compareTo( key ) == 0 )
	  {// if it's here, it's in the left subtree
	  }
	  else
	  {// if it's here, it's in the right subtree
	  }
	}
	
  public void initForTraverse()
  {
    // do in-order traversal of the tree into travList:
    travList = new ArrayList<String>(); 
    inorderTraverse( root );
  }

  // add all the items to travlist in the subtree rooted at the start
  private void inorderTraverse( Node start)
  {
    if(start == null)
    {
      // nothing to add
    }   
    else
    {
      inorderTraverse( start.left );
      travList.add( start.data );
      inorderTraverse( start.right );

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

  public static void main(String[] args)
  {
    SackBST sack = new SackBST();
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
  }

}
