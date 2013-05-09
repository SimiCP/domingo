public class RockPiles
{
  public static int count = 0;

  public static void main(String[] args)
  {
    System.out.println( move(6,7) + "  took " + count + " move calls" );
    System.exit(0);

    java.util.Scanner keys = new java.util.Scanner( System.in );

    int left = 6, right = 7;

    do{
      System.out.println("left pile: " + left + "  right pile: " + right );
      System.out.println("     " + move(left,right) );
      System.out.print("enter your move: ");
      String ans = keys.nextLine();
      if( ans.equals( "l" ) )
        left--;
      else if( ans.equals( "r" ) )
        right--;
      else if( ans.equals( "b" ) )
      {  left--;  right--; }

    }while(true);
      
  }

  // return char for the optimal move given left rocks in left pile
  // and right rocks in the right pile
  //  where moves are 'l', 'r', 'b', 'g' (give up)
  private static char move( int left, int right )
  {
count++;
    if( left==0 && right==0 )
    {
      return 'g';
    }

    if( left > 0 && right > 0 )
    {
      if( move(left-1,right) == 'g' )
      {
        return 'l';
      }
      else if( move(left,right-1) == 'g' )
      {
        return 'r';
      }
      else if( move(left-1,right-1) == 'g' )
      {
        return 'b';
      }
      else
      {
        return 'g';
      }
    }// have at least one rock in each pile

    else if( left == 0 && right > 0 )
    {
      if( move( left, right-1 ) == 'g' )
      {
        return 'r';
      }
      else
        return 'g';
    }

    else if( right == 0 && left > 0 )
    {
      if( move( left-1, right ) == 'g' )
      {
        return 'l';
      }
      else
        return 'g';
    }
 
    else
      return 'x';
  
  }
  
}
