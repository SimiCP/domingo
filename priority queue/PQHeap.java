public class PQHeap<E extends Comparable<E>>
{
  public static final int MAX = 10000;

  private E[] items;  // space to hold the items---ignore capacity issues
  private int n;      // the number of items

  public PQHeap()
  {
    items = (E[]) (new Comparable[MAX]);
    n = 0;
  }

  public static void main(String[] args)
  {
    PQHeap<Fish> pq = new PQHeap<Fish>();

    
  }

}
