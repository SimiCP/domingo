
public class OurList<E> {

    static public void main(String[] args) {
        {
            System.out.println("removeAllButFirst");
            OurList instance = new OurList(6);
            instance.add(new Integer(3));
            instance.add(new Integer(1));
            instance.add(new Integer(7));
            instance.add(new Integer(5));
            instance.add(new Integer(6));
            System.out.println("Before: " + instance.toString());
            OurList.removeAllButFirst(instance);
            System.out.println("After: " + instance.toString());
        }
        {
            System.out.println("removeAllButLast");
            OurList instance = new OurList(6);
            instance.add(new Integer(3));
            instance.add(new Integer(1));
            instance.add(new Integer(7));
            instance.add(new Integer(5));
            instance.add(new Integer(6));
            System.out.println("Before: " + instance.toString());
            OurList.removeAllButLast(instance);
            System.out.println("After: " + instance.toString());
        }

    }
    // instance variables:
    private E[] items;  // the array that holds the items in the list
    private int n;  // the current number of items in the list

    // constructors:
    // construct an empty list with space in the array for 
    // initCapacity items
    public OurList(int initCapacity) {
        items = (E[]) new Object[initCapacity];
        n = 0;
    }

    // instance methods:
    // append the item s to the end of the list
    public void add(E s) {
        makeMoreSpaceIfNecessary();

        items[ n] = s;
        n++;
    }

    // insert the item s into the list at index,
    // shift the others
    public void add(int index, E s) {
        if (index < 0) {
            System.out.println("illegal index---smaller than 0");
            System.exit(1);
        } else if (index > n) {
            System.out.println("illegal index---greater than the size");
            System.exit(1);
        } else {
            makeMoreSpaceIfNecessary();

            // shift everybody from the target location upward
            for (int k = n - 1; k >= index; k--) {
                items[ k + 1] = items[ k];
            }

            items[ index] = s;

            n++;

        }

    }

    // double the space and restore the instance variables
    private void makeMoreSpaceIfNecessary() {
        if (n == items.length) {
            // make a new, bigger array
            E[] temp = (E[]) new Object[items.length * 2];

            // copy the existing items to new array
            for (int k = 0; k < n; k++) {
                temp[ k] = items[ k];
            }

            // make items point to the new array
            items = temp;
        }

    }

    // return the item in the given position
    public E get(int index) {
        if (index < 0 || index >= n) {
            return null;
        } else {
            return items[ index];
        }
    }

    // remove the first item in the list
    public void removeFirst() {
        for (int k = 1; k < n; k++) {
            items[ k - 1] = items[ k];
        }

        n--;
    }

    // replace the item in given position by the given item
    public void set(int index, E s) {
        if (index < 0 || index >= n) {
            System.out.println("no such item to replace");
            System.exit(1);
        } else {
            items[ index] = s;
        }
    }

    public int size() {
        return n;
    }

    void removeLast() // remove the item stored at position n-1
    {
        n--;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < this.size(); ++i) {
            result += this.items[i] + ",";
        }
        return result;
    }

    static public void removeAllButLast(OurList list) {
        final int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            list.removeFirst();
        }
    }

    static public void removeAllButFirst(OurList list) {
        if ( list.n >= 1 ) {
            list.n--;
            removeAllButFirst( list );
        }
    }
    // #4 and #6:  add your main, and 
    // #4:  static method removeAllButLast:
    // (changed from somewhat incorrect instance method on test)
    //                  You'll have stuff like:   list.size(), ...
    // Error to say things like:
    //    list.items or list.n
    // #6:  static method removeAllButFirst
}
