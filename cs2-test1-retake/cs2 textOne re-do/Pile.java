
public class Pile {

    private String[] a;
    private int n;

    public Pile() {
        a = new String[10000];
        n = 0;
    }

    public static void main(String[] Args) {
        Pile questionTwo = new Pile();
        questionTwo.add("dead");
        questionTwo.add("one");
        System.out.println(questionTwo.top());

    }

    public int size() {
        return n;
    }

    public String top() {
        return a[0];

    }

    public void add(String s) {
        //shift entire array to the right one space
        for (int i = n; i > 0; i--) {
            a[i] = a[i - 1];

        }
        a[0] = s;
        ++n;
    }
    // return the top item in the pile:
}
