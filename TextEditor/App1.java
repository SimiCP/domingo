import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class App1 extends Basic
{
  public static void main(String[] args)
  {
    // example: hard-coded location and size of window:
    App1 a = new App1("Sample Application", 0, 0, 600,400);
    
    // example: use most of the screen
//    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//    App1 a = new App1( "Sample Application", 
//                           0, 0, screenSize.width-5, screenSize.height-80 );
  }

  // instance variables for the application:
  //------------------------------------------------------------------

  private int r, g, b;  // color values
  private int textX, textY; // location of text display

  //------------------------------------------------------------------

  public App1( String title, int ulx, int uly, int pw, int ph )
  {
    super(title,ulx,uly,pw,ph);

    // code to initialize instance variables before animation begins:
    //------------------------------------------------------------------

    r=0; g=0; b=0;

    // code to finish setting up entire window:
    //------------------------------------------------------------------
  
    setBackgroundColor( Color.green );

    // code to set up camera(s)
    //------------------------------------------------------------------
  
    cameras.add( new Camera( pixelWidth/2, pixelHeight/2, pixelWidth/2, pixelHeight/2,
                         0, 100, 0, 100,
                         new Color( 255, 200, 200 ) ) );

    cameras.add( new Camera( 0, 0, pixelWidth/4, pixelHeight/4, 
                         0, 100, 0, 100,
                         new Color( 200, 200, 255 ) ) );

    //------------------------------------------------------------------
    // start up the animation:
    super.start();
  }

  public void step()
  {
    // code to update the world and display the world:
    //------------------------------------------------------------------

    // System.out.println("Doing step " + getStepNumber() );

    drawWorld( cameras.get(0) );
    drawWorld( cameras.get(1) );

    //------------------------------------------------------------------
  }

  private void drawWorld( Camera cam )
  {
    cam.activate();

    cam.setColor( Color.black );
    cam.drawRect( 10, 10, 80, 80 );

    cam.fillRect( 50, 50, 4, 8 );

    cam.setColor( Color.white );
    cam.drawCircle( 75, 75, 10 );
    cam.fillCircle( 25, 25, 10 );

    cam.setColor( Color.blue );
    cam.drawTri( 10, 20, 15, 30, 20, 5 );
    cam.fillTri( 40, 50, 45, 60, 50, 35 );

    cam.setColor( Color.magenta );
    cam.drawLine( 0, 0, 100, 100 );
    cam.drawLine( 0, 100, 100, 0 );

    cam.setColor( Color.orange );
    cam.drawText( "Hey, there!", 0, 50 );
    cam.drawText( "How's it going?", 50, 0 );

    cam.setColor( new Color(r,g,b) );
    cam.drawText( "Hello", textX, textY );
  }

  public void keyTyped( KeyEvent e )
  {
    char key = e.getKeyChar();
    
    // code to change instance variables depending on key:
    //------------------------------------------------------------------
    System.out.println("got key " + key );

    if( key == 'r' )
    { r=255; g=0; b=0; }
    else if( key == 'g' )
    { r=0; g=255; b=0; }
    else if( key == 'b' )
    { r=0; g=0; b=255; }

    //------------------------------------------------------------------
  }

  public void keyPressed( KeyEvent e )
  {
    int code = e.getKeyCode();

    // code to change instance variables depending on which key pressed (code):
    //------------------------------------------------------------------

    if( code == KeyEvent.VK_ESCAPE )
      System.exit(0);

    if( getMouseCamera() == 0 )
    {// shift camera over reality
      if( code == KeyEvent.VK_UP )
        cameras.get(0).shiftRegion( 0, 0.25 );
      else if( code == KeyEvent.VK_DOWN )
        cameras.get(0).shiftRegion( 0, -0.25 );
      else if( code == KeyEvent.VK_F1 )
        cameras.get(0).scaleRegion( 0.9, 0.9 );
      else if( code == KeyEvent.VK_F2 )
        cameras.get(0).scaleRegion( 1/0.9, 1/0.9 );
    }// shift camera over reality

    //------------------------------------------------------------------
  }

  public void mouseMoved(MouseEvent e)
  {
    super.mouseMoved(e);

    // code to respond to mouse motion:
    //------------------------------------------------------------------

    if( getMouseCamera() == 0 )
    {// mouse is in region for camera 0
      textX = (int) getMouseX();  textY = (int) getMouseY();
    }

    //------------------------------------------------------------------
  }

  public void mouseDragged(MouseEvent e)
  {
    super.mouseDragged(e);

    // code to respond to mouse motion with a button pressed:
    //------------------------------------------------------------------

    //------------------------------------------------------------------
  }

  public void mouseClicked(MouseEvent e)
  {
    super.mouseClicked(e);

    // code to respond to mouse click:
    //------------------------------------------------------------------

    //------------------------------------------------------------------
  }

  public void mousePressed(MouseEvent e)
  {
    super.mousePressed(e);

    // code to respond to mouse button pressed:
    //------------------------------------------------------------------

    //------------------------------------------------------------------
  }

  public void mouseReleased(MouseEvent e)
  {
    super.mouseReleased(e);

    // code to respond to mouse button released:
    //------------------------------------------------------------------

    //------------------------------------------------------------------
  }

  public void mouseEntered(MouseEvent e)
  {
    super.mouseEntered(e);

    // code to respond to mouse entering window:
    //------------------------------------------------------------------

    //------------------------------------------------------------------
  }

  public void mouseExited(MouseEvent e)
  {
    super.mouseExited(e);

    // code to respond to mouse exiting window:
    //------------------------------------------------------------------

    //------------------------------------------------------------------
  }

}
