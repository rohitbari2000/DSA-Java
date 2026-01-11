package binarysearch;

public class InfiniteArray {
    public static void main(String[] args) {
        // Question : https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
        int[] nums = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        System.out.println(findAns(nums, 10));
    }

    static int findAns(int[] nums, int target){
        //first find the range
        //start with the box of size 2
        int start = 0;
        int end = 1;

        //condition for the target to lie in the range
        while(target > nums[end]){
            int temp = end + 1;
            //double the box value
            // end = previous end + sizeOfBox * 2
            end += (end - start + 1) * 2;
            start = temp;
        }
        return binarySearch(nums, target, start, end);
    }

    static int binarySearch(int[] nums, int target, int start, int end){

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
}
