public class HTNode
{
  public static int nextId = 0;

  public int id;
  public Block data;
  public HTNode next;

  public HTNode( Block b )
  {
    nextId++;
    id = nextId;

    data = b;
  }

  public String toString()
  {
    if( next != null )
      return "<" + id + " " + data + " " + next.id + ">";
    else
      return "<" + id + " " + data + " " + "x" + ">";
  }

}
