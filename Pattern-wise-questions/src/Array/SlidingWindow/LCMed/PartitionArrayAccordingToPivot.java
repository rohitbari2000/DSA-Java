package Array.SlidingWindow.LCMed;

import java.util.Arrays;

public class PartitionArrayAccordingToPivot {
    public static void main(String[] args) {
        int[] arr = {9,3,7,1,8};
        partition(arr,5);
        System.out.println(Arrays.toString(arr));
    }

    private static void partition(int[] arr, int pivot){
        int left = 0, right = arr.length - 1;

        while(left <= right){
            while(left <= right && arr[left] < pivot){
                left++;
            }
            while(left <= right && arr[right] >= pivot){
                right--;
            }
            if(left <= right){
                swap(arr, left, right);
                left++;
                right--;
            }
        }
    }

    private static void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
