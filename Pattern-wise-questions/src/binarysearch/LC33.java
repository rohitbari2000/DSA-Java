package binarysearch;

public class LC33 {
    public static void main(String[] args) {
        int[] nums = {2,5,6,7,2,2,2};
        System.out.println("Location of the target in the given array s at index: " + findIndex(nums, 2));
    }

    static int findIndex(int[] nums, int target){
        int start = 0;
        int end = nums.length - 1;
        int pivotIndex = findPivot(nums);

        //if pivot is not found, it means the array is not rotated and just do normal binary search
        if(pivotIndex == -1)
            return binarySearch(nums, target, 0, nums.length - 1);
        else {
        //got the pivot, now compare target with start in order to decide which part of the pivot is to be searched for it
            if(nums[pivotIndex] == target)
                return pivotIndex;
            if(nums[start] <= target){
                return binarySearch(nums, target, 0, pivotIndex - 1);
            }
            else
                return binarySearch(nums, target, pivotIndex + 1, end);
        }
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

    // Not gonna work with duplicate values
    static int findPivot(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        //there can be 4 cases
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && nums[mid] > nums[mid + 1])
                return mid;
            if(mid > start && nums[mid] < nums[mid - 1])
                return mid;
            if(nums[start] <= nums[mid])
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }

    static int findPivotwithDuplicates(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        //there can be 4 cases
        while(start <= end){
            int mid = start + (end - start) / 2;
            if(mid < end && nums[mid] > nums[mid + 1])
                return mid;
            if(mid > start && nums[mid] < nums[mid - 1])
                return mid;

            //if elements at middle, start, end are same then skip the duplicates
            if(nums[mid] == nums[start] && nums[mid] == nums[end]){
                //skip the dupplicates after checking for the pivot
                if(nums[start] > nums[start + 1])
                    return start;
                start++;
                if(nums[end] < nums[end - 1])
                    return end - 1;
                end--;
            }

            //left side is sorted, so pivot would be in the right
            else if(nums[start] < nums[mid] || (nums[start] == nums[mid] &&  nums[mid] > nums[end]))
                start = mid + 1;
            else
                end = mid - 1;
        }
        return -1;
    }
}
