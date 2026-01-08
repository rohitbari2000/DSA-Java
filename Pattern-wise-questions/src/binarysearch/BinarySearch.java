package binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        System.out.println(binarySearch(nums, 6));
        System.out.println(orderAgnosticBinarySearch(nums, 7));
    }

    static int binarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
//            int mid = (start + end) / 2;
            int mid = start + (end - start) / 2; //so that it does not exceed int max value
            if(nums[mid] == target)
                return mid;
            if(target > nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    static int orderAgnosticBinarySearch(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        // find whether the array is sorted in ascending or descending
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
