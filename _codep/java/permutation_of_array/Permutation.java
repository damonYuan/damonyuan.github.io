import java.util.ArrayList;
import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Permutation perm = new Permutation("ABC");
        perm.show();
    }

    private char[] mArray;

    public Permutation(String input) {
        int length = input.length();
        mArray = new char[length];
        for (int i = 0; i < length; i++) {
            mArray[i] = input.charAt(i);
        }
    }

    public void show() {
        perm(mArray, 0);
    }

    private void perm(char[] arr, int i) {
        if (i == arr.length) {
            System.out.println(String.valueOf(mArray));
            return;
        }

        for (int j = i; j < arr.length; j++) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            perm(arr, i + 1);
            arr[j] = arr[i];
            arr[i] = tmp;
        }
    }
}
