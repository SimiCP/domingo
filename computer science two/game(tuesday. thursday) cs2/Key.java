public class Key
{
  public int x, y;

  public Key( int xIn, int yIn )
  {
    x=xIn;  y=yIn;
  }

  public boolean equals( Key other )
  {
    return x==other.x && y==other.y;
  }

  public int compareTo( Key other )
  {
    if( x < other.x )
      return -1;
    else if( other.x < x )
      return 1;
    else
    {// x == other.x
      if( y < other.y )
        return -1;
      else if( other.y < y )
        return 1;
      else
        return 0;
    }
  }

}
