public class Debug3
{
  public static void main(String[] args)
  {
    Sack3 sack = new Sack3();

    // add some carefully planned blocks
    sack.add( new Block( 12, 12, "player" ) );
    sack.add( new Block( 9, 6, "food" ) );

    System.out.print("sack after adding: " );
    show( sack );

    sack.find( new Key( 12, 12 ) );
    sack.remove();
    System.out.print("sack after remove: " );
    show( sack );
  }

  public static void show( Sack3 sack )
  {
    sack.initForTraverse();
    while( sack.hasNext() )
    {
      System.out.print( sack.next() + " " );
    }
    System.out.println();
  }

}
