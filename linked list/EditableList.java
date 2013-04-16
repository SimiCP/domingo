public class EditableList
{   // mandatory instance variables:
    private DLLNode head, cursor, tail;
    private int n;
    
    // add new item s before the item the cursor points to
    // and the cursor points t the same item(or off the
    // end if it was off the end before adding)
    public void add( String s )
    {
        
    }
    
    // remove the item the cursor points to
    // and make the cursor point to the item
    // after the item that was removed, or
    // the cursor is off the end if removed the
    // last item
    // (if cursor is off the end, do nothing.
    public void remove()
    {
    }
    
    // move the cursor backward one item
    // If already on the first item, or off the end of
    // a size 0 list, do nothing
    public void backward()
    {
    }
    
    // returns a reference to the item at an offset of
    // x from the the cursor..NOTE: cursor does not change
    // (return null if specified item does not exist)
    public String get( int x )
    {
        
    }
    
    // make the cursor point to the first actual item
    public void home()
    {
    }
    
    // make the cursor point to the off the end
    public void end()
    {
    }
    
} 