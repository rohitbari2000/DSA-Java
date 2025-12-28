package Array.SlidingWindow.LCMed;
//https://leetcode.com/problems/count-number-of-nice-subarrays/

public class CountNumberOfNiceSubArrays {
    public static void main(String[] args) {
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        System.out.println(countNiceSubArrays(nums, 2) - countNiceSubArrays(nums, 1));
    }

    public static int countNiceSubArrays(int[] nums, int k){
        int leftIndex = 0;
        int rightIndex = 0;
        int count = 0;
        int sum = 0;
        if(k < 0)
            return 0;

        while(rightIndex < nums.length){
            sum += (nums[rightIndex] % 2);
            while(sum > k && leftIndex <= rightIndex){
                sum -= (nums[leftIndex] % 2);
                leftIndex++;
            }
            count += (rightIndex - leftIndex + 1);
            rightIndex++;
        }
        return count;
    }
}
