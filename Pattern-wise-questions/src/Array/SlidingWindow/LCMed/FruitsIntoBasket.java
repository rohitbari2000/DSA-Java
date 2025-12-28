package Array.SlidingWindow.LCMed;
//https://leetcode.com/problems/fruit-into-baskets/description

import java.util.HashMap;

public class FruitsIntoBasket {
    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println(totalFruit(fruits));
    }

    public static int totalFruit(int[] fruits){
        int leftIndex = 0;
        int rightIndex = 0;
        int maxLength = 0;
        HashMap<Integer, Integer> freqMap = new HashMap<>(3);

        while(rightIndex < fruits.length){
            if(!freqMap.containsKey(fruits[rightIndex]))
                freqMap.put(fruits[rightIndex], 1);
            else
                freqMap.put(fruits[rightIndex], freqMap.get(fruits[rightIndex]) + 1);
            if(freqMap.size() > 2){
                freqMap.put(fruits[leftIndex], freqMap.get(fruits[leftIndex]) - 1);
                if(freqMap.get(fruits[leftIndex]) == 0)
                    freqMap.remove(fruits[leftIndex]);
                leftIndex++;
            }
            else
                maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
            rightIndex++;
        }
        return maxLength;
    }
}
