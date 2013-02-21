import java.awt.Color;

public class Block
{
  private int x, y;  // coordinates of center of the block
  private String kind;  // the kind of block

  public Block( int xIn, int yIn, String k )
  {
    x=xIn;  y=yIn;
    kind=k;
  }

  public Key getKey()
  {
    return new Key( x, y );
  }

  public String getKind()
  {
    return kind;
  }

  public void draw( Camera cam )
  {
    if( kind.equals("wall") )
      cam.setColor( Color.gray );
    else if( kind.equals("player") )
      cam.setColor( Color.blue );
    else if( kind.equals("monster") )
      cam.setColor( Color.red );
    else if( kind.equals("food") )
      cam.setColor( Color.green );

    cam.fillRect( x-0.5, y-0.5, 1, 1 );    
  }

}
