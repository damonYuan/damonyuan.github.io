import java.lang.*;
import java.io.*;
import java.util.*;

class Solution {
	public int findKthLargest(int[] nums, int k) {
        return pqSolution(nums, k);
    }

    public int sortSolution(int[] nums, int k) {
    	Arrays.sort(nums);
    	return nums[nums.length - k];
    }

    public int pqSolution(int[] nums, int k) {
    	final PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    	for (int num : nums) {
    		pq.offer(num);

    		if (pq.size() > k) {
    			pq.poll(); // remove the (k - 1)th largest num
    		}
    	}
    	return pq.peek();
    }

    public int quickSortSolution(int[] nums, int k) {
    	// quick sort the nums
    	return nums[nums.length - k];
    }
}

public class Main {
	public static int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];

		for (int i = 0; i < parts.length; i++) {
			String part = parts[i].trim();
			output[i] = Integer.parseInt(part);
		}
		return output;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
		String line;
		
		int[] nums = new int[0];
		int k = 0;

		System.out.print("Please enter the array: ");
		while ((line = in.readLine()) != null) {
			if (line.length() > 0) {
			    nums = stringToIntegerArray(line);	
			    break;
			}
		}

		System.out.print("Please enter the k: ");
		while ((line = in.readLine()) != null) {
			if (line.length() > 0) {
		        k = Integer.parseInt(line.trim());	
		        break;
			}
		}
		
		System.out.println("Solution: " + (new Solution()).findKthLargest(nums, k));
	}
}