import java.math.BigInteger;

public class Fib
{
  private static BigInteger TWO = new BigInteger( "2" );
  public static void main(String[] args)
  {
    BigInteger n = new BigInteger( args[0] );

    System.out.println( fib2( n ) );
    
    int k=0;
    while( chart[k] != null )
    {
      System.out.println( k + ": " + chart[k] );
      k++;
    }
    
  }

  // a terrible, terrible method!
  public static BigInteger fib( BigInteger n )
  {
    if( n.compareTo(BigInteger.ZERO) == 0 )
      return BigInteger.ONE;
    else if( n.compareTo(BigInteger.ONE) == 0 )
      return BigInteger.ONE;
    else
    {
      BigInteger a = fib(n.subtract(BigInteger.ONE));
      BigInteger b = fib(n.subtract(TWO));
      return a.add(b);
    }
  }

  private static BigInteger[] chart = new BigInteger[10000];

  public static BigInteger fib2( BigInteger n )
  {
    if( chart[ toInt( n ) ] != null )
    {
      return chart[ toInt(n) ];
    }

    else
    {// answer to fib2(n) is not already in the chart, so figure it

      if( n.compareTo(BigInteger.ZERO) == 0 )
      {
        chart[0] = BigInteger.ONE;
        return BigInteger.ONE;
      }
      else if( n.compareTo(BigInteger.ONE) == 0 )
      {
        chart[1] = BigInteger.ONE;
        return BigInteger.ONE;
      }
      else
      {// n > 1
        BigInteger a = fib2(n.subtract(BigInteger.ONE));
        BigInteger b = fib2(n.subtract(TWO));
        BigInteger temp = a.add(b);
        chart[ toInt(n) ] = temp;
        return temp;
      }
    }// not in chart

  }// fib2

  public static int toInt( BigInteger x )
  {
    return (int) x.longValue();
  }

}
