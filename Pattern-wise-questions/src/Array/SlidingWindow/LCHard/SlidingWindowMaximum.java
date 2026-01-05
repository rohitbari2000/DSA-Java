package Array.SlidingWindow.LCHard;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/sliding-window-maximum/description/
public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        Arrays.toString(maxSlidingWindow(nums, k));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n-k+1];

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            //remove numbers out of range of window
            if(!deque.isEmpty() && deque.peekFirst() <= i-k)
                deque.pollFirst();
            //remove smaller numbers in k range as they are useless
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]){
                deque.pollLast();
            }
            deque.offerLast(i);
            //add the front element in the ans since it is the max one
            if(i >= k-1)
                ans[i-k+1] = nums[deque.peekFirst()];
        }
        return ans;
    }
}
