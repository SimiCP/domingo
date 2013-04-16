
public class questionOne {

    private static int a[] = {17, 4, 21, 9, 40, 16};
    private static int n = 6;

    public static void main(String[] Args) {
        int[] newArray = getEveryOtherOne();
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }
    }

    public static int[] getEveryOtherOne() {
        int[] temp = new int[n / 2];

        for (int i = 0; i < n; i += 2) {
            temp[i / 2] = a[i];
        }
        return temp;
    }
}