package Array.SlidingWindow.LCMed;
//https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
public class LongestContiguousSubarray {
    public static void main(String[] args) {
        int[] nums = {4,2,2,2,4,4,2,2};
        System.out.println(longestSubarray(nums, 0));
    }

    public static int longestSubarray(int[] nums, int limit) {
        int start = 0;
        int end = 1;
        int maxLength = Integer.MIN_VALUE;

        while(end < nums.length){
            if(Math.abs(nums[end] - nums[start]) <= limit){
                end++;
                maxLength = Math.max(maxLength, end - start);
            } else {
                while(Math.abs(nums[end] - nums[start]) > limit) {
                    start++;
                }
            }
        }
        return maxLength;
    }
}
