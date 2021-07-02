import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;

public class LisRecursive {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        System.out.println("Please enter numbers: ");
        String[] numbers = reader.nextLine().split(",");
        reader.close();
        Integer[] nums = new Integer[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            nums[i] = Integer.parseInt(numbers[i].trim());
        }
        System.out.println("the length of longest increasing sequence: " + lengthOfLIS(nums));
    }

    public static int lengthOfLIS(Integer[] nums) {
        return lengthCal(nums, Integer.MIN_VALUE, 0);
    }

    public static int lengthCal(Integer[] nums, Integer prev, int curpos) {
        if (curpos == nums.length) {
            return 0;
        }

        int taken = 0;
        if (nums[curpos] > prev) {
            taken = 1 + lengthCal(nums, nums[curpos], curpos + 1);
        }
        int nottaken = lengthCal(nums, prev, curpos + 1);
        return Math.max(taken, nottaken);
    }
}
