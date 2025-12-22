package Array.SlidingWindow;
import java.util.Arrays;

public class LongestSubArrayLength {
    public static void main(String[] args) {
        int[] nums = {2,5,1,10,10};
        System.out.println(longestSubArrayLength(nums, 14));
        System.out.println(longestSubArrayLengthLinear(nums, 14));
    }

    public static int longestSubArrayLength(int[] nums, int upperBound){  // O(2N)
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLength = 0;
        int[] subArrayIndexes = {0,0};
        while(right < nums.length){
            sum += nums[right];
            while(sum > upperBound){
                sum -= nums[left];
                left++;
            }
            if(sum <= upperBound){
                maxLength = Math.max(maxLength, right - left + 1);
                subArrayIndexes[0] = left;
                subArrayIndexes[1] = right;
            }
            right++;
        }
        System.out.println("Range of Longest subArray: " + Arrays.toString(subArrayIndexes));
        return maxLength;
    }

    public static int longestSubArrayLengthLinear(int[] nums, int upperBound){  // O(2N)
        int left = 0;
        int right = 0;
        int sum = 0;
        int maxLength = 0;
        while(right < nums.length){
            sum += nums[right];
            if(sum > upperBound){
                sum -= nums[left];
                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }
        return maxLength;
    }
}
