public class CheckSack3
{
  public static void main(String[] args)
  {
   /*  // unit testing sameChars
    System.out.println( "abc ab: "  + sameChars( "abc", "ab" ) );
    System.out.println( "abc abc: " + sameChars( "abc", "abc" ) );
    System.out.println( "abc cab: " + sameChars( "abc", "cab" ) );
    System.out.println( "ab abc: " + sameChars( "ab", "abc" ) );
    System.exit(0);
   */

    Sack2 sack = new Sack2();

    // add some carefully planned blocks
    sack.add( new Block( 2, 2, "b" ) );
    sack.add( new Block( 3, 3, "c" ) );
    sack.add( new Block( 6, 6, "f" ) );

    showCheck( "bcf", sack, " initial add failed" );

    // add in three places:
    sack.add( new Block( 1, 1, "a" ) );
    sack.add( new Block( 4, 4, "d" ) );
    sack.add( new Block( 7, 7, "g" ) );

    showCheck( "abcdfg", sack, " later add failed" );
    
    // see if can find in various places:
    boolean c1 = sack.find( new Key(0,0) );
    boolean c2 = sack.find( new Key(1,1) );
    boolean c3 = sack.find( new Key(4,4) );
    boolean c4 = sack.find( new Key(5,5) );
    boolean c5 = sack.find( new Key(6,6) );
    boolean c6 = sack.find( new Key(7,7) );
    boolean c7 = sack.find( new Key(8,8) );

    System.out.println( "find 0 0 (false): " + c1 );
    System.out.println( "find 1 1 (true): " + c2 );
    System.out.println( "find 4 4 (true): " + c3 );
    System.out.println( "find 5 5 (false): " + c4 );
    System.out.println( "find 6 6 (true): " + c5 );
    System.out.println( "find 7 7 (true): " + c6 );
    System.out.println( "find 8 8 (false): " + c7 );

    if( c1 || !c2 || !c3 || c4 || !c5 || !c6 || c7 )
      System.out.println("---------------------------> find failed");

    // sanity check get:
    sack.find( new Key(3,3) );
    String kind = sack.get().getKind();
    System.out.println("get 3 3 (c): " + sack.get().getKind() );
    if( ! kind.equals( "c" ) )
      System.out.println("---------------------------> get failed");

    // remove 3 and view:
    sack.find( new Key(1,1) );  sack.remove();
    sack.find( new Key(4,4) );  sack.remove();
    sack.find( new Key(7,7) );  sack.remove();

    showCheck("bcf", sack, " remove failed" );

  }

  private static void showCheck( String label, Sack3 sack, String errMess )
  {
    System.out.print( label + ": " );
    String result = "";
    sack.initForTraverse();
    while( sack.hasNext() )
    {
      String current = sack.next().getKind();
      System.out.print( current + " " );
      result += current;
    }
    System.out.println();
    if( ! sameChars( label, result ) )
      System.out.println("-----------------------------> " + errMess );
  }

  // assuming one and two have unique chars, determine whether
  // they have the same chars, perhaps permuted
  private static boolean sameChars( String one, String two )
  {
    for( int k=0; k<one.length(); k++ )
    {
      char x = one.charAt(k);
      boolean found = false;
      for( int j=0; j<two.length(); j++ )
        if( x == two.charAt(j) )
          found = true;
      if( !found )
        return false;
    }
    
    return one.length() == two.length();

  }
}
