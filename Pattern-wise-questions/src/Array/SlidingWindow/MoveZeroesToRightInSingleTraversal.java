package Array.SlidingWindow;

import java.util.Arrays;

public class MoveZeroesToRightInSingleTraversal {
    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 0, 3};
        processArray(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void processArray(int[] arr){
        int slow = 0;

        for (int fast = 0; fast < arr.length; fast++) {
            if(arr[fast] != 0){
                int temp = arr[slow];
                arr[slow] = arr[fast];
                arr[fast] = temp;
                slow++;
            }
        }
    }
}
