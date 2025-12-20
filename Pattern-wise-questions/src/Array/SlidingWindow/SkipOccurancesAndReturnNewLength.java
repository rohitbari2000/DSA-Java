package Array.SlidingWindow;

public class SkipOccurancesAndReturnNewLength {
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,4,5,5,6,7,7};
        System.out.println(skipDuplicates(arr, 3));
    }

    private static int skipDuplicates(int[] nums, int val) {
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left++] = nums[right];
            }
        }

        return left;
    }
}
