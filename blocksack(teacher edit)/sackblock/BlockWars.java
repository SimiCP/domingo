import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.io.*;

public class BlockWars extends Basic
{
  private   

  public static void main(String[] args)
  {
    // example: hard-coded location and size of window:
    BlockWars a = new BlockWars("BLOCK WARS !!", 0, 0, 440, 470);

  }

  // instance variables for the application:
  //------------------------------------------------------------------
    private Sack1 sack;
    private Block player;
  //------------------------------------------------------------------

  public BlockWars( String title, int ulx, int uly, int pw, int ph )
  {
    super(title,ulx,uly,pw,ph);

    // code to initialize instance variables before animation begins:
    //------------------------------------------------------------------
    sack = new sack1();
    player = new Block( 12, 12, "player" );
    sack.add( player );
    
    // generate some random blocks;
    makeBlocks( "wall", 500 );
    makeBlocks( "food", 30 );
    makeBlocks( "monster", 20 );
    
    //generate some random blocks;
    Random randy = new Random(1);
    
    // code to finish setting up entire window:
    //------------------------------------------------------------------
  
    setBackgroundColor( new Color( Color.black ) );

    // code to set up camera(s)
    //------------------------------------------------------------------
  
    cameras.add( new Camera( 20, 50, 400, 400,
                         0, 25, 0,
                         Color.white) );

    //------------------------------------------------------------------
    // start up the animation:
    super.start();
  }
  
  private void makeBlocks( String k, int num )
  {
      for( int j=1; j<=num; j++ )
      { 
          int x=randy.nextInt(25);
          int y=randy.nextInt(25);
          
          if( ! sack.find( new Key(x, y) ) )
          {
              sack.add( new Block( x, y, k) );
          }
          else
          j--;
          System.out.println("overlap");
        }
  public void step()
  {
    // code to update the world and display the world:
    //------------------------------------------------------------------

    //-----------------------------------------------------------
    Camera cam = cameras.get(0);

    cam.activate();
    
    sack.initForTraverse();
    while( sack.hasNext() )
    {
        Block b = sack.next();
        b.draw( cam );
    }
    //------------------------------------------------------------------
  }

  public void keyTyped( KeyEvent e )
  {
    char key = e.getKeyChar();
    
    // code to change instance variables depending on key:
    //------------------------------------------------------------------

    //------------------------------------------------------------------
  }

  public void keyPressed( KeyEvent e )
  {
    int code = e.getKeyCode();

    // code to change instance variables depending on which key pressed (code):
    //------------------------------------------------------------------

    //------------------------------------------------------------------
  }

  public void mouseMoved(MouseEvent e)
  {
    super.mouseMoved(e);

    // code to respond to mouse motion:
    //------------------------------------------------------------------

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
