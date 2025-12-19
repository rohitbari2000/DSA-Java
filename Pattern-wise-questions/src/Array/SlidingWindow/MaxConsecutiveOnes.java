package Array.SlidingWindow;
//https://leetcode.com/problems/max-consecutive-ones/

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    private static int findMaxConsecutiveOnes(int[] nums){
        int maxLength = 0;
        int leftIndex = 0;
        int rightIndex = 0;

        while(rightIndex < nums.length){
            if(nums[rightIndex] == 1)
                maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
            else
                leftIndex = rightIndex + 1;
            rightIndex++;
        }
        return maxLength;
    }

    private static int iterative(int[] nums){
        int maxLength = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1){
                count++;
                maxLength = Math.max(maxLength, count);
            } else {
                count = 0;
            }
        }
        return maxLength;
    }
}
