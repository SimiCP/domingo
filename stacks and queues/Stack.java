// 

public class Stack
{
	private String[] Stack;
	private int final top = 0;
	int n;

public Stack( int size)
{
	Stack = new Stack(size);
	n = 1;
}

// O of 1
publc int size()
{
	return n;
}


//add to the stack O of n
public static void push( String s)
{
	for( int i = 1; i <= n; i++)
	{
		Stack[i] = Stack[i-1]
	}
	Stack[top] = s;
	n++;
}

//item at the top
public static void peek()
{
	return 	Stack[top];
}

// remove // pop //  0 of 1
public static void pop();
{	
	for (int i = 0; i < n; i++)
	{
		Stack[i] = Stack[i+1]
	}
	n--;
}

public static void reverse( ) {
	String[] nw = String[n];
	rev( Stack, 0 );
}
public static void rev( int i ) {
	int oppositeEnd = n - 1 - i;
	if ( oppositeEnd > i ) {
		String temp = Stack[ oppositeEnd ];
		Stack[ oppositeEnd ] = Stack[ i ];
		rev( i + 1 );
	}
}
}
}