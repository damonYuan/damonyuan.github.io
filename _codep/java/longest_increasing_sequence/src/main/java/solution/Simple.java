package solution;

import java.lang.*;
import java.util.*;

class Simple {
    public static int lengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int[] max = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            max[i]=1;
            for(int j=0; j<i;j++){
                if(nums[i]>nums[j]){
                    max[i]=Math.max(max[i], max[j]+1);
                }
            }
        }
        int result = 0;
        for(int i=0; i<max.length; i++){
            if(max[i]>result)
                result = max[i];
        }
        return result;
    }

    public static int shorterLengthOfLIS(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int[] max = new int[nums.length];
        Arrays.fill(max, 1);
        int result = 1;
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    max[i]= Math.max(max[i], max[j]+1);
                }
            }
            result = Math.max(max[i], result);
        }
        return result;
    }
}