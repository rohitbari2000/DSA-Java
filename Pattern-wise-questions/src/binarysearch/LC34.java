package binarysearch;

public class LC34 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,4,4,4,4,4,4,5,6,7};
        int[] ans =  firstAndLastOccurance(nums, 4);
        System.out.println("First and last occurrences of target are : " + ans[0] + "," + ans[1]);
    }

    private static int[] firstAndLastOccurance(int[] nums, int target){
        int[] ans = {-1, -1};

        int start = binarySearch(nums, target, true);
        int end = binarySearch(nums, target, false);

        ans[0] = start;
        ans[1] = end;
        return ans;
    }

    private static int binarySearch(int[] nums, int target, boolean findLeftIndex){
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while(start <= end){
//            int mid = (start + end) / 2;
            int mid = start + (end - start) / 2; //so that it does not exceed int max value
            if(target > nums[mid])
                start = mid + 1;
            else if(target < nums[mid])
                end = mid - 1;
            else{
                ans = mid;
                if(findLeftIndex)
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return ans;
    }
}
