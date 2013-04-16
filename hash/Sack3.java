public class Sack3
{
    //static variables:
    public final static int m = 11;

    //instance variables:
    private HTNode[] a;
    private int n;

    // for holding find results:
    private int location; // index in [a] where key was fund
    private HTNode previous;

    // for holding traversal info:
    private int travLoc;
    private HTNode currentLoc;
    private int travCount;


    public Sack3()
    {
        n = 0;
        a = new HTNode[ M ];
        /* don't need, because java does it
        for( int    k=0; k<M; k++)
        a[k] = null;
        */
    }

    private int h(Key key)
    {
        long temp = 7*key.x + 13*key.y + 5;
        if( temp < 0)
            temp = -temp;
        return (int) (temp % M);
    }
    public boolean find(key key)
    {
        int index = h( key );

        if( a[index] == null)
        return false;

        // there is a list stored at index, but does it contain our key?

        HTNode current = a[index];

        if( current.data.equals( key ))
        {// found the desired key in the first node
            location = index;
            previous = null;

        }
        while( current.next != null && !current.next.data.equals( key ) )
            current = current.next;

        if( current != null )
        {
            location = index;
            previous = current;
            return true;
        }
        else
        {
            return false;
        }
    }
    public block get()
    {
        if( previous == null)
        {// we found the desired key in the first node
            return a[location].data;
        }
        else
        {// previous actually points to the node before the target node
            return current.next.data;
        }
    }

    public void remove()
    {
        if( previous == null)
        {// need to remove the first node at a[location]
            a[index] = a[location].next;
        }
        else
        {// need to remove the node after previous
            current.next = current.next.next;
        }

        n--;
    }
    public int size()
    {
        return n;
    }

    public void add( Block b)
    {
        int index = h( b.getKey() );

        if( a[index] == null )
        {// adding the first node in this slot
            a[index] = new HTNode( b );
        }
        else
        {// adding a new node to the linked list in this lot
            HTNode temp = new HTNode( b );
            temp.next = a[index];
            a[index] = temp;
        }
        n++;
    }
    // prepre the sack to be traversed
    public void initForTraverse()
    {   
        travCount = 0;
        if( n == 0)
        {
            return;
        }
        travLoc = 0;
        while( a[travLoc] == null)
        travLoc++;

        travCurrent = a[ travLoc ];
    }
    public boolean hasNext()
    {
        return travCount < n;
    }
    public Block next()
    {
        Block temp = travCurrent.data;
        travCount++;

        // get ready for next call to next();
        travCurrent = travCurrent.next;

        if( travCurrent == null && travCount < n )
        { // reache the end of a linked list, must advance travLoc

            travLoc++;
            while( a[travLoc] == null)
            travLoc++;

            travCurrent = a[travLoc];

        }
        return temp;
    }
} // sack 33333333333333333333333333333
