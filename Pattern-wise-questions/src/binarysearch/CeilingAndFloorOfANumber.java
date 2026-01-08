package binarysearch;

public class CeilingAndFloorOfANumber {
    public static void main(String[] args) {
        // find the target element from a sorted array if present, otherwise the element which is the least upper bound of it
        int[] nums = {1,2,3,4,5,6,7,8,9,10,12};
        System.out.println(ceiling(nums, 11));

        // find the target element from a sorted array if present, otherwise the element which is the highest lower bound of it
        System.out.println(floor(nums, 11));

    }

    private static int floor(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            int num = nums[mid];
            if(target < num)
                end = mid - 1;
            else if(target > num)
                start = mid + 1;
            else
                return num;
        }
        return nums[end];
    }

    private static int ceiling(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        if(target > nums[nums.length - 1])
            return -1;

        while(start <= end){
            int mid = start + (end - start) / 2;
            int num = nums[mid];
            if(target < num)
                end = mid - 1;
            else if(target > num)
                start = mid + 1;
            else
                return num;
        }
        return nums[start];
    }
}
