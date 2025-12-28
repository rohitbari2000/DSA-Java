package Array.SlidingWindow.LCMed;
//https://leetcode.com/problems/binary-subarrays-with-sum/description
public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        System.out.println(numSubarraysWithSum(nums, 2) - numSubarraysWithSum(nums, 1));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        int leftIndex = 0;
        int rightIndex = 0;
        int countOfLessThanGoal = 0;
        int sum = 0;

        while(rightIndex < nums.length){
            sum += nums[rightIndex];
            while(sum > goal && leftIndex <= rightIndex){
                sum -= nums[leftIndex];
                leftIndex++;
            }
            countOfLessThanGoal += (rightIndex - leftIndex + 1);
            rightIndex++;
        }
        return countOfLessThanGoal;
    }
}
