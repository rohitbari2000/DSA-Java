package Array.SlidingWindow.LCMed;

public class LCMedObtainMaximumPoints {
    public static void main(String[] args) {
        int[] cardPoints = {1,2,3,4,5,6,1};
        System.out.println(maxScore(cardPoints, 3));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int leftIndex = k-1;
        int rightIndex = cardPoints.length - 1;
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = 0;

        if(cardPoints.length == 0 || cardPoints.length < k)
            return 0;

        for (int i = 0; i <= k - 1; i++) {
            leftSum += cardPoints[i];
        }
        maxSum = leftSum;

        for (; leftIndex >= 0; leftIndex--) {
            leftSum -= cardPoints[leftIndex];
            rightSum += cardPoints[rightIndex--];
            maxSum = Math.max(maxSum, leftSum + rightSum);
        }
        return maxSum;
    }
}
