package Array.SlidingWindow.LCMed;
//https://leetcode.com/problems/grumpy-bookstore-owner/description/?envType=problem-list-v2&envId=sliding-window

public class GrumpyBookStoreOwner {
    public static void main(String[] args) {
        int[] customers = {4,10,10};
        int[] grumpy = {1,1,0};
        int minutes = 2;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int leftIndex = 0;
        int rightIndex = 0;
        int count = 0;
        int maxCount = 0;
        int zeroCount = 0;

        while(rightIndex < grumpy.length){
            if(grumpy[rightIndex] == 0){
                zeroCount += customers[rightIndex];
            }
            if(rightIndex < minutes) {
                count += (grumpy[rightIndex] == 1) ? customers[rightIndex] : 0;
            }
            else {
                count += (grumpy[rightIndex] == 1 ? customers[rightIndex] : 0)
                        - (grumpy[leftIndex] == 1 ? customers[leftIndex] : 0);
                leftIndex++;
            }
            maxCount = Math.max(count, maxCount);
            rightIndex++;
        }
        return maxCount + zeroCount;
    }
}
