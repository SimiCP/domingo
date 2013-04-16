
// use a singly linked list with the item head points to the bottom of the stack

public class Stack3
{

	private Node top;
	private Node current;
	int n;

public Stack3( int size)
{
	Stack = new Stack(size);
	n = 0;
}

// O of 1
publc int size()
{
	return n;
}


//add to the stack O of n
public static void push( String s)
{
	if( head == null )
    {
      head = new Node( s );
      top = head; 
    }
    else
    {
      current = top;
      current.next = new Node(s);
      top = current.next;
    }

    n++;
}

//item at the top
public static void peek()
{
	return Stack[top]; 	
}

// remove // pop //  0 of 1
public static void pop();
{	
	n--;
	top--;
}

public static size();
{
	return n;
}
}