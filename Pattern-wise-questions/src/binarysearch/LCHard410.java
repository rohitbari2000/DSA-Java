package binarysearch;
//https://leetcode.com/problems/split-array-largest-sum/description/
public class LCHard410 {
    public static void main(String[] args) {
        int[] nums = {7,2,5,10,8};
        System.out.println(splitArray(nums, 2));
    }

    static int splitArray(int[] nums, int k){
        int start = 0;
        int end = 0;

        for(int num : nums){
            start = Math.max(start, num);
            end += num;
        }

        // Binary search
        while(start < end){
            int mid = start + (end - start) / 2;

            //calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;

            for(int num : nums){
                if(sum + num > mid){
                    //you cannot add this in the existing subArray, create a new one
                    //say you created a new subArray, then the sum of it would be equal to this integer
                    sum = num;
                    pieces++;
                }else
                    sum += num;
            }
            if(pieces > k)
                start = mid + 1;
            else
                end = mid;
        }
        return start; //here start == end
    }
}
