public class SList
{
   // instance variables:
   private String[] items; // the array that holds the items in the list
   private int n; // the current number of items in the list
  
   // constructors:
   
   // construct an empty list with space in the array for 
   
   // initial capacity
   
   //list (implemented using array
   
   public SList( int initCapacity )
   { 
        items = new String[ initCapacity ];
        n = 0;
    }
    
    // instance methods:
    // append the iteam s to the end of the list
    // the array is full, make more space, copy current items to it
    public void append( String s )
    {
        if( n == items.length  )
            makeMoreSpace(  );
            
            items[ n ] = s;
            n++
        
        else
        {
            items[ n ] = s;
            n++;
    }
    // insert the iteam s into the list at index,
    // shift the others
    public void insert( int index, String s )
    {   
        if( index < 0 )
        {
            System.out.println("illegal index --- saller than 0");
            System.exit(1);
        }
        else if( index > n )
        {
            System.out.println("illegal index --- saller than the size");
            System.exit(1);
        }
        // shift everybody from the target location upward
        for( int k = n - 1; k >= index ; k--)
        {
            items[ k + 1 ] = iteams[ k ];
        }
        items[ index] = s;
        n++;
    
    //double the space and restore the instane variables
    private void makeMoreSpace( )
    {
        // makes new, bigger array
        String[] temp = new String[ items.length*2 ];
        // copy the existing items to the new array
        for( int k = 0; k < n ; k++ )
        {
            temp[ k ] = items[ k ];
        }
        // make items point to the new array
        items = temp;
        
    }
    
    // remove all items (capacity stays the same)
    public void clear()
    {
    }
    
    // return the item in the given position
    public String get( int index )
    {
    }
    
    // remove the item in a given position
    public void remove( int index )
    {
    }
    
    // replace the item in a given position by the given item
    public void replace( int index, String S)
    {
    }
    
    // return the size of arraylist
    public int size()
    {
    }
    
    
}
