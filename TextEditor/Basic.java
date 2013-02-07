import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import java.util.ArrayList;

public class Basic extends JPanel implements Runnable, KeyListener,
                                             MouseListener, 
                                             MouseMotionListener
{
  protected static int FPS = 50; // desired frames per second

  private int stepNumber;

  // part of the basic framework
  private JFrame frame;
  private boolean inView;
  private Thread theThread;	//to control the animation

  private static int stepLength=30;  // time between steps in milliseconds
  protected int pixelWidth, pixelHeight; // dimensions of window in pixels
  private int ulcX, ulcY;  // location of upper left corner of window on screen

  private Color backgroundColor;  // background color of entire window

  private double mouseX, mouseY;  // maintain correct mouse location
  private int whichCamera;  // maintain which camera's pixel grid region mouse is in

  private Graphics dbg;  
  private Image dbImage = null;

  protected ArrayList<Camera> cameras;

  public Basic( String title, int ulx, int uly, int pw, int ph ) 
  {
    super();  // call JPanel constructor

    ulcX = ulx;  ulcY = uly;
    pixelWidth = pw;  pixelHeight = ph;

    cameras = new ArrayList<Camera>();

    setLayout( new BorderLayout() );
    setOpaque( false );
    setPreferredSize( new Dimension(pixelWidth,pixelHeight) );

    stepNumber = 0;

    // force mouse to be in center of window at start
    mouseX = pixelWidth/2;
    mouseY = pixelHeight/2;

    // build a window to hold this panel:
    frame = new JFrame();
    frame.setTitle( title );

    Container cp = frame.getContentPane();
    cp.setLayout( new BorderLayout() );

    cp.add( this, BorderLayout.CENTER );
    frame.pack();

    frame.setResizable( false );

    addKeyListener(this);
    setFocusable(true);
    requestFocus();
    addMouseListener(this);
    addMouseMotionListener(this);

  }
  
  public void start()
  {
    frame.setVisible(true);
    
    // physically draw the mouse cursor where we want it
    try{ 
      Robot rob = new Robot();
      rob.mouseMove( ulcX+pixelWidth/2, ulcY+pixelHeight/2 );
    }catch(Exception e){}

    inView = true;  //the animation can proceed
  
    if (theThread == null)	
      theThread = new Thread(this);
    theThread.start();
  }
  
  public void stop() 
  {
    inView = false;  //stop the animation
  
    if (theThread != null) 
    {
      theThread = null;
    }
  
  }
  
  public void run()
  {
    while (inView)
    {
      stepNumber++;

      long startTime = System.nanoTime();

      render();  // does the graphics stuff and lets the app update and draw
      paintScreen();  // physically paints image to screen

      long stopTime = System.nanoTime();

      double elapsed = (stopTime-startTime)/1000000.0;  // milliseconds

      int waitTime = 1000/FPS - (int) Math.round( elapsed );
      if( waitTime < 1 )
        waitTime = 1;

      try {
        Thread.sleep(waitTime);
      } 
      catch (InterruptedException ie) 
      {System.err.println("OOPS");}
    }
  }
  
  public void paintComponent(Graphics slate) 
  {
    super.paintComponent(slate);
    if( dbImage != null )
      slate.drawImage(dbImage,0,0,null);
  }
  
  private void render()
  {
    if( dbImage == null )
    {// create the buffer
      dbImage = createImage( pixelWidth, pixelHeight );
      if( dbImage == null )
      {
        System.out.println("dbImage is null???");
        return;
      }
      else
      {// dbg is created, tell Camera
        dbg = dbImage.getGraphics();
        Camera.setGraphicsContext( dbg );
      }
    }

    // clear the background of entire window
    dbg.setColor( backgroundColor );
    dbg.fillRect(0,0,pixelWidth,pixelHeight);

    // give app a chance to update its instance variables
    // and then draw stuff to dbg
    
    step(); 
  }

  // override this method with code to display stuff 
  // and update app instance variables
  public void step()
  {
    System.out.println("Step number: " + getStepNumber() );
  }

  private void paintScreen()
  {
    Graphics gr;
    try{
      gr = this.getGraphics();
      if( gr != null && dbImage != null )
        gr.drawImage(dbImage,0,0,null);
      Toolkit.getDefaultToolkit().sync();  // maybe not needed?
      gr.dispose();
    }
    catch(Exception e)
    {
      System.out.println("graphics context error" + e );
      System.exit(1);
    }
  }

  public int getStepNumber()
  {
    return stepNumber;
  }
  
  // implement KeyListener:
  // ******************************************************************
  public void keyPressed(KeyEvent e){}
  public void keyReleased(KeyEvent e){}
  public void keyTyped(KeyEvent e){}

  // implement MouseListener:
  // ******************************************************************
  public void mouseClicked(MouseEvent e)
  {
    updateMouse(e);
  }
  public void mouseEntered(MouseEvent e)
  {
    updateMouse(e);
  }
  public void mouseExited(MouseEvent e)
  {
    updateMouse(e);
  }
  public void mousePressed(MouseEvent e)
  {
    updateMouse(e);
  }
  public void mouseReleased(MouseEvent e)
  {
    updateMouse(e);
  }
  
  // implement MouseMotionListener:
  // ******************************************************************
  public void mouseDragged(MouseEvent e)
  {
    updateMouse(e);
  }
  public void mouseMoved(MouseEvent e)
  {
    updateMouse(e);
  }

  private void updateMouse( MouseEvent e )
  {
    int ix = e.getX(), iy = e.getY();

    // determine which camera this mouse event hits
    // and compute mouseX, mouseY in that camera's graph paper coords
    
    whichCamera = -1;
    Camera ac=null, temp;

    for( int k=0; k<cameras.size(); k++ )
    {
      temp = cameras.get(k);
      if( temp.hits(ix,iy) )
      {
        ac = temp;
        whichCamera = k;
      }
    }

    if( whichCamera == -1 )
    {
      mouseX=0;  mouseY=0; 
      whichCamera = -1;
    }
    else
    {// mouse event happened in an active camera, update coords for that cam
      mouseX = ac.invMapX( ix );
      mouseY = ac.invMapY( iy );
    }

  }

  // -----------------------------------------------------------------
  // These can be called, but don't override

  protected double getMouseX()
  {
    return mouseX;
  }

  protected double getMouseY()
  {
    return mouseY;
  }

  protected int getMouseCamera()
  {
    return whichCamera;
  }

  // set background color of entire window
  protected void setBackgroundColor( Color color )
  {
    backgroundColor = color;
  }
  
}
