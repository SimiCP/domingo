import java.awt.Color;

public class Disk
{
  private static int diskNumber = 0;

  // instance variables:
  private double x, y, r;
  private int id;

  public Disk( double xIn, double yIn, double rIn )
  {
    diskNumber++;
    id = diskNumber;

    x=xIn; y=yIn; r=rIn; 
  }
  
  public void draw( Camera cam )
  {
    cam.setColor( Color.green );
    cam.fillCircle( x, y, r );
    cam.setColor( Color.black );
    cam.drawText( ""+id, x-r, y-3 );
  }

  public String toString()
  {
    return x + " " + y + " " + r;
  }

}
