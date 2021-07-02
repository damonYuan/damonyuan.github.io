import java.util.*;
import java.lang.*;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[] {23, 45, 67, 89, 123, 568};
        System.out.println(search(arr, 23));
        System.out.println(search(arr, 67));
    }

    public static int search(int[] arr, int key) {
        int min = 0;
        int max = arr.length - 1;
        int mid = 0;
        while(min <= max) {
            mid = min + (max - min) / 2;
            if (key < arr[mid]) {
                max = mid - 1;
            } else if (key > arr[mid]) {
                min = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
} 
