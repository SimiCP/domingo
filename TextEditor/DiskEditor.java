import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import java.util.*;
import java.io.*;

public class TextEditor extends Basic
{
  public static void main(String[] args)
  {
    // example: hard-coded location and size of window:
    TextEditor a = new TextEditor("Text Editor", 0, 0, 640,480);
    
    // example: use most of the screen
//    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//    DiskEditor a = new DiskEditor( "Sample Application", 
//                           0, 0, screenSize.width-5, screenSize.height-80 );
  }

  // instance variables for the application:
  //------------------------------------------------------------------

  private ArrayList<Disk> disks;
  private String fileName;
  private int current;

  //------------------------------------------------------------------

  public TextEditor( String title, int ulx, int uly, int pw, int ph )
  {
    super(title,ulx,uly,pw,ph);

    // code to initialize instance variables before animation begins:
    //------------------------------------------------------------------

    disks = new ArrayList<Disk>();
	 current = 0; //current to equal n // if no disks current is of the end

    // select and read a data file to recreate the list of disks:
    fileName = FileBrowser.chooseFile( true );

    if( fileName.equals( "" ) )
    {// make an empty list
    }
    else
    {// go ahead and load the disk data:
      try{
        Scanner input = new Scanner( new File( fileName ) );
        
        int number = input.nextInt();

        for( int k=0; k<number; k++ )
        {
          disks.add( new Disk( input.nextDouble(),
                               input.nextDouble(),
                               input.nextDouble() ) );
        }

        input.close();
      }
      catch(Exception e)
      {
        System.out.println("Oops: " + e );
      }
    }

    // code to finish setting up entire window:
    //------------------------------------------------------------------
  
    setBackgroundColor( Color.black );

    // code to set up camera(s)
    //------------------------------------------------------------------
  
    cameras.add( new Camera( 0, 0, 600, 400,
                         0, 62, 0, 45,
								 //color.white
                         new Color( 255, 255, 255 ) ) );

    cameras.add( new Camera( 0, 400, 640, 80,
                         0, 8, 0, 1,
                         new Color( 0, 0, 0 ) ) );

    cameras.add( new Camera( 600, 0, 40, 400,
                         0, 1, 0, 1,
                         new Color( 255, 255, 255 ) ) );
    //------------------------------------------------------------------
    // start up the animation:
    super.start();
  }

  public void step()
  {
    // code to update the world and display the world:
    //------------------------------------------------------------------

    // System.out.println("Doing step " + getStepNumber() );

    Camera cam = cameras.get(0);

    cam.activate();

    // draw the disks:
    for( int k=0; k<disks.size(); k++ )
    {
      disks.get(k).draw( cam );
    }

    cam = cameras.get(1);
    cam.activate();

    cam.setColor( Color.white );
    cam.drawText( fileName, .25, 0.25 );

    cam = cameras.get(2);
    cam.activate();

    //------------------------------------------------------------------
  }

  public void keyTyped( KeyEvent e )
  {
    char key = e.getKeyChar();
    
    // code to change instance variables depending on key:
    //------------------------------------------------------------------
    // System.out.println("got key " + key );

    if( ' '<=key && key<='~' )
    {
      fileName += key;
    }

    //------------------------------------------------------------------
  }

  public void keyPressed( KeyEvent e )
  {
    int code = e.getKeyCode();

    // code to change instance variables depending on which key pressed (code):
    //------------------------------------------------------------------

    if( code == KeyEvent.VK_ESCAPE )
    {
      save();
      System.exit(0);
    }
    else if( code == KeyEvent.VK_BACK_SPACE )
    {
      fileName = fileName.substring( 0, fileName.length()-1 );
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

    if( getMouseCamera() == 0 )
    {
      disks.add( new Disk( getMouseX(), getMouseY(), 5 ) );
    }

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

  private void save()
  {
    try{
      PrintWriter output = new PrintWriter( new File( fileName ) );
      
      output.println( disks.size() );

      for( int k=0; k<disks.size(); k++ )
        output.println( disks.get(k) );

      output.close();
    }
    catch(Exception e)
    {
      System.out.println("Oops: " + e );
    }
   
  }

}
