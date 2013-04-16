public class Fish implements Comparable<Fish>
{
  private String kind;
  private int age;

  public Fish( String k, int a )
  {
    kind=k;  age=a;
  }

  public int compareTo( Fish other )
  {
    if( kind.compareTo( other.kind ) != 0 )
      return kind.compareTo( other.kind );
    else
    {
      if( age < other.age )
        return -1;
      else if( age > other.age )
        return 1;
      else
        return 0;
    }
  }

}
