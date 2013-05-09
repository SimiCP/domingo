import java.util.Scanner;
import java.io.*;

public class Matrix
{
  private static int MAX = 100;

  private double[][] data;
  private int nr, nc;     // the number of rows and columns in use

  public Matrix( int nrIn, int ncIn )
  {
    nr = nrIn;
    nc = ncIn;

    data = new double[ MAX ][ MAX ];
  }

  public Matrix( String fileName )
  {
    data = new double[MAX][MAX];

    try{
      Scanner input = new Scanner( new File( fileName ) );

      nr = input.nextInt();
      nc = input.nextInt();

      for( int r=0; r<nr; r++ )
      {
        for( int c=0; c<nc; c++ )
        {
          data[r][c] = input.nextDouble();
        }
      }
    }
    catch(Exception e)
    {
      System.out.println("could not load matrix file named " + fileName );
      System.out.println( e );
      System.exit(1);
    }

  }

  public void display(String label)
  {
    System.out.println(label);
    for( int r=0; r<nr; r++ )
    {
      for( int c=0; c<nc; c++ )
      {
        System.out.printf("%12.7f ", data[r][c] );
      }
      System.out.println();
    }
    System.out.println();

  }

  public Matrix multiply( Matrix other )
  {
    Matrix result = new Matrix( this.nr, other.nc );

    for( int r=0; r<result.nr; r++ )
    {
      for( int c=0; c<result.nc; c++ )
      {// fill result.data[r][c] with product of row r of this and
       //  column c of other:
        for( int k=0; k<this.nc; k++ )
        {
          result.data[r][c] += this.data[r][k]*other.data[k][c];
        }
      }
    }

    return result;

  }

  // compute row and column totals (and the grand total)
  // and stick them in the array
  public void computeTotals()
  {
    for( int r=0; r<nr; r++ )
    {
      data[r][nc] = 0;

      for( int c=0; c<nc; c++ )
      {
        data[r][nc] += data[r][c];
      }

    }

    nc++;

    for( int c=0; c<=nc; c++ )
    {
      data[nr][c] = 0;

      for( int r=0; r<nr; r++ )
      {
        data[nr][c] += data[r][c];
      }
    }

    nr++;

  }

  public static void main(String[] args)
  {
    Matrix a = new Matrix( "m1" );
    a.display("m1:");
    Matrix b = new Matrix( "m2" );
    b.display("m2:");

    Matrix c = a.multiply(b);
    c.display("m1*m2:");

    c.computeTotals();
    c.display("m1*m2 with totals:");

  }


}
