import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.io.*;

public class Game extends Basic
{
  private static Random randy = new Random(1);

  public static void main(String[] args)
  {
    // example: hard-coded location and size of window:
    Game a = new Game("Exciting Block Game!!!", 0, 0, 440, 470);

  }

  // instance variables for the application:
  //------------------------------------------------------------------
  private Sack1 blocks;
  private Block player;

  private int status;

  //------------------------------------------------------------------

  public Game( String title, int ulx, int uly, int pw, int ph )
  {
    super(title,ulx,uly,pw,ph);

    // code to initialize instance variables before animation begins:
    //------------------------------------------------------------------

    blocks = new Sack1();

    player = new Block( 12, 12, "player" );
    blocks.add( player );

    // add some random blocks:
    buildStuff( 6, "food" );
    buildStuff( 20, "wall" );
    buildStuff( 5, "monster" );

    status = 0;

    // code to finish setting up entire window:
    //------------------------------------------------------------------
  
    setBackgroundColor( Color.orange );

    // code to set up camera(s)
    //------------------------------------------------------------------
  
    cameras.add( new Camera( 20, 50, 400, 400,
                         0, 25, 0,
                         new Color( 255, 128, 255 ) ) );

    //------------------------------------------------------------------
    // start up the animation:
    super.start();
  }


  private void buildStuff( int number, String kind )
  {
    int x, y;

    for( int num=1; num<=number; num++ )
    {
      x = randy.nextInt(25);
      y = randy.nextInt(25);

      // make sure this key doesn't hit existing block:
      if( ! blocks.find( new Key( x, y ) ) )
      {
        blocks.add( new Block( x, y, kind ) );
      }
      else
      {
        // System.out.println("got overlap");
        num--;
      }
    }
  }

  public void step()
  {
    if( status == 0 )
    {// normal play

      // code to update the world and display the world:
      //------------------------------------------------------------------

      // let all the monsters move randomly:
      
      blocks.initForTraverse();
      while( blocks.hasNext() )
      {
        Block b = blocks.next();
        if( b.move( blocks ) == 1 )
          status = 1;
      }

    
      //-----------------------------------------------------------
      Camera cam = cameras.get(0);

      cam.activate();

      blocks.initForTraverse();
      while( blocks.hasNext() )
      {
        Block b = blocks.next();

        b.draw( cam );
      }

      //------------------------------------------------------------------
    }// normal play

    else if( status == 1 )
    {
      Camera cam = cameras.get(0);
      cam.activate();
      cam.setColor( Color.black );
      cam.drawHorizCenteredText( "You lose!", 12.5, 12 );
    }

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

    if( code == KeyEvent.VK_LEFT )
    {
      status = player.move( -1, 0, blocks );
    }
    else if( code == KeyEvent.VK_RIGHT )
    {
      status = player.move( 1, 0, blocks );
    }
    else if( code == KeyEvent.VK_UP )
    {
      status = player.move( 0, 1, blocks );
    }
    else if( code == KeyEvent.VK_DOWN )
    {
      status = player.move( 0, -1, blocks );
    }

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
