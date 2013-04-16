public class EditableList
{
  // mandatory instance variables:
  private DLLNode head, cursor, tail;
  private int n;

  // add new item s before the item the cursor points to
  // and the cursor points to the same item (or off the
  // end if it was off the end before adding)
  public void add( String s )
  {
  }

  // remove the item the cursor points to
  // and make the cursor point to the item
  // after the item that was removed, or
  // the cursor is off the end if removed the
  // last item
  // (if cursor is off the end, do nothing)
  public void remove()
  {
  }

  // move the cursor forward one item,
  // is allowed to point to non-existent "off the end"
  // If already off the end, do nothing
  public void forward()
  {
  }

  // move the cursor backward one item
  // If already on the first item, or off the end of
  // a size 0 list, do nothing
  public void backward()
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

  // returns a reference to the item at an offset of
  // x from the cursor item
  // Note:  cursor does not change
  // (return null if specified item does not exist)
  public String get( int x )
  {
  }

  // return the number of items
  public int size()
  {
  }

}
