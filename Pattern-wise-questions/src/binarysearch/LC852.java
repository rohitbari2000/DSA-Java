package binarysearch;

public class LC852 {
    public static void main(String[] args) {
        //Question : https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
        int[] nums = {2,4,6,8,7,5,3,1,0};
        System.out.println(mountainArrayAnsFinder(nums));
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

//    static int binarySearch(int[] nums, int target){
//        int start = 0;
//        int end = nums.length - 1;
//        while(start <= end){
////            int mid = (start + end) / 2;
//            int mid = start + (end - start) / 2; //so that it does not exceed int max value
//            if(nums[mid] == target)
//                return mid;
//            if(target > nums[mid])
//                start = mid + 1;
//            else
//                end = mid - 1;
//        }
//        return -1;
//    }
}
