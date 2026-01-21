package binarysearch;

public class LCHard1095 {
    public static void main(String[] args) {
        int[] nums = {0,5,3,1};
        System.out.println("First occurrence of target is: " + findAns(nums, 1));
    }

    static int findAns(int[] nums, int target){
        int mountain = mountainArrayAnsFinder(nums);
        int ans = -1;
        int potentialAns = orderAgnosticBinarySearch(nums, target, 0, mountain);
        if(potentialAns != -1)
            return potentialAns;
        else
            return orderAgnosticBinarySearch(nums, target, mountain + 1, nums.length - 1);
    }

    static int mountainArrayAnsFinder(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        while(start != end){
//            int mid = (start + end) / 2;
            int mid = start + (end - start) / 2; //so that it does not exceed int max value
            if(nums[mid + 1] > nums[mid])
                //you are in the ascending part of the array
                //hence increase start index
                start = mid + 1;
            else
                end = mid;
        }
        return start;
    }

    static int orderAgnosticBinarySearch(int[] nums, int target, int start, int end){
        //find whether the array is sorted in ascending or descending
        boolean isAsc = nums[start] < nums[end];

        while(start <= end){
//            int mid = (start + end) / 2;
            int mid = start + (end - start) / 2; //so that it does not exceed int max value
            if(nums[mid] == target)
                return mid;
            if(isAsc){
                if(target < nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
            else{
                if (target > nums[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }
}
