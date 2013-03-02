import java.awt.Color;
import java.util.Random;

public class Block
{
  private static Random randy = new Random(1);

  private int x, y;  // center of block is at (x,y)
  private String kind;  // the kind of block

  private int health;

  public Block( int xIn, int yIn, String k )
  {
    x=xIn;  y=yIn; 
    kind = k;

    health = 12;
  }

  public void draw( Camera cam )
  {
    if( kind.equals( "player" ) )
    {
      cam.setColor( Color.red );
    }
    else if( kind.equals( "monster" ) )
      cam.setColor( Color.black );
    else if( kind.equals( "food" ) )
      cam.setColor( Color.green );
    else if( kind.equals( "wall" ) )
      cam.setColor( Color.gray );
    
    cam.fillRect( x-0.45, y-0.45, 0.9, 0.9 );

    if( kind.equals( "player" ) )
    {
      cam.setColor( Color.white );
      cam.drawCenteredText( "" + health, x, y );
    }
  }

  public Key getKey()
  {
    return new Key( x, y );
  }

  public int move( Sack1 blocks )
  {
    if( kind.equals( "monster" ) )
    {
      int r = randy.nextInt( 4 );
      int newX=x, newY=y;

      if( r==0 )
        newX++;
      else if( r==1 )
        newY++;        
      else if( r==2 )
        newX--;        
      else if( r==3 )
        newY--;        

      boolean canMove = false;
      int status = 0;

      if( blocks.find( new Key(newX,newY)) )
      {
        Block b = blocks.get();
        if( b.kind.equals("player") )
        {
          canMove = true;
          status = 1;
        }
      }
      else
      {
        canMove = true;
      }

      if( canMove )
      {
        blocks.find( new Key(x,y) );
        blocks.remove();
        x = newX;  y = newY;
        blocks.add( this );
      }

      return status;

    }

    return 0;
  
  }

  public int move( int dx, int dy, Sack1 blocks )
  {
    if( ! kind.equals( "player" ) )
    {
      System.out.println("only a player can move!");
      System.exit(1);
    }

    int status = 0;

    int newX = x+dx, newY = y+dy;

    if( blocks.find( new Key(newX,newY) ) )
    {
      Block other = blocks.get(); 

      if( other.kind.equals( "wall" ) )
      {
        health--;
      }
      else if( other.kind.equals( "food" ) )
      {
        blocks.remove();
        health += 5;
        blocks.find( new Key(x,y) );
        blocks.remove();
        x = newX;  y = newY;
        blocks.add( this );
      }
      else if( other.kind.equals( "monster" ) )
      {
        blocks.find( new Key( x, y ) );
        blocks.remove();
        status = 1;
      }
      
    }
    else
    {// space is empty, just move
      blocks.find( new Key(x,y) );
      blocks.remove();
      x = newX;  y = newY;
      blocks.add( this );
    }
    
    return status;
  }

}
