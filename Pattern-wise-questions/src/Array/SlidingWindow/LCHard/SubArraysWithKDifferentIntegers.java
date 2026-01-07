package Array.SlidingWindow.LCHard;
//https://leetcode.com/problems/subarrays-with-k-different-integers/description
import java.util.HashMap;

public class SubArraysWithKDifferentIntegers {
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,4};
        System.out.println(subarraysWithKDistinct(nums, 3) - subarraysWithKDistinct(nums, 2));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int leftIndex = 0;
        int rightIndex = 0;
        int count = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>(nums.length);
        if(k < 0)
            return 0;

        while(rightIndex < nums.length){
            if(!freqMap.containsKey(nums[rightIndex]))
                freqMap.put(nums[rightIndex], 1);
            else
                freqMap.put(nums[rightIndex], freqMap.get(nums[rightIndex]) + 1);

            while(freqMap.size() > k){
                freqMap.put(nums[leftIndex], freqMap.get(nums[leftIndex]) - 1);
                if(freqMap.get(nums[leftIndex]) == 0)
                    freqMap.remove(nums[leftIndex]);
                leftIndex++;
            }
            count += (rightIndex - leftIndex + 1);
            rightIndex++;
        }
        return count;
    }
}
