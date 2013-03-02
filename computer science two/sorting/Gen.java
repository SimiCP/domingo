import java.util.Random;

public class Gen
{
  public static void main(String[] args)
  {
    Random r = new Random();
    for( int k=1; k<=20; k++ )
      System.out.println( r.nextInt( 1000 ) + 1 );
  }
}
