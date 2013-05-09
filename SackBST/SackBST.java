import java.util.ArrayList;

public class SackBST
{
    private Node root;  // reference to the root node
    private int n;    // number of items

    // instance variables to store info from find:
    private Node parent;  // parent of the node where the key was found
    private boolean left; // key was found in the left child of parent?
    // note:  if parent==null after finding a key, the key was found
    //        as root.data

    private ArrayList<String> travList;
    private int current;  // index of current item in the traversal list

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
        Node parent = this.parent;
        if ( parent == null ) {
            parent = root;
        }
        Node victim;
        System.out.println( "this: " + this );
        if ( this.left ) {
            victim = parent.left;
        }
        else {
            victim = parent.right;
        }
        System.out.println( "test2" );
        remove( parent, victim );
    }

    static public void remove( Node parent, Node victim ) {
        // He childless so kill him.
        if ( victim.left == null && victim.right == null ) {
            // Find the victim in parent.
            if ( parent.left == victim ) {
                parent.left = null;
            }
            else {
                parent.right = null;
            }
        }
        // Only right child.
        else if ( victim.left == null && victim.right != null ) {
            // Find the victim in parent.
            if ( parent.left == victim ) {
                parent.left = victim.right;
            }
            else {
                parent.right = victim.right;
            }
        }
        // Only left child.
        else if ( victim.left != null && victim.right == null ) {
            // Find the victim in parent.
            if ( parent.left == victim ) {
                parent.left = victim.left;
            }
            else {
                parent.right = victim.left;
            }
        }
        // Both children.
        else {
            Node heir = getMin( victim.right );
            // Find the victim in parent.
            if ( parent.left == victim ) {
                parent.left = heir;
            }
            else {
                parent.right = heir;
            }
            heir.left = victim.left;
            heir.right = victim.right;
        }
    }

    static public Node getMin( Node parent ) {
        if ( parent == null ) {
            return null;
        }
        else {
            Node min = getMin( parent.left );
            if ( min == null ) {
                return parent;
            }
            return min;
        }
    }

    static public Node getMax( Node parent ) {
        if ( parent == null ) {
            return null;
        }
        else {
            Node max = getMax( parent.right );
            if ( max == null ) {
                return parent;
            }
            return max;
        }
    }

    public void initForTraverse()
    {
        // do pre-order traversal of the tree into travList:
        travList = new ArrayList<String>();
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
      
        

    }

}
