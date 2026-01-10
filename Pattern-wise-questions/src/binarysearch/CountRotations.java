package binarysearch;

public class CountRotations {
    public static void main(String[] args) {
        int[] nums = {2,5,6,7,2,2};
        System.out.println("Array is rotated these many times: " + findRotations(nums));
    }

    static int findRotations(int[] nums){
        int pivot = findPivotWithDuplicates(nums);
        return pivot + 1;
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

    static int findPivotWithDuplicates(int[] nums){
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
                //skip the duplicates after checking for the pivot
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
