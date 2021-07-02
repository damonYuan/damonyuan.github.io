import java.util.Scanner;
import java.util.ArrayList;

public class LisBinary {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter numbers: ");
        String[] numbers = reader.nextLine().split(",");
        reader.close();
        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.parseInt(numbers[i].trim());
        }
        System.out.println("the length of longest increasing sequence: " + lis(nums).length);
    }

    public static Integer[] lis(Integer[] nums) {
        ArrayList<Integer> dp = new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            int insert = search(dp.toArray(new Integer[dp.size()]), nums[i]);
            if (insert >= dp.size()) {
                dp.add(nums[i]);
            } else {
                dp.set(insert, nums[i]);
            }
        }
        return dp.toArray(new Integer[dp.size()]);
    }

    public static int search(Integer[] arr, Integer key) {
        int min = 0;
        int max = arr.length - 1;
        int mid = 0;
        while (min <= max) {
            mid = min + (max - min) / 2;
            if (key < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}
