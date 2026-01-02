package Array.SlidingWindow.LCMed;

import java.util.HashMap;

public class LongestSubStringWithAtMostKDistinctChar {
    public static void main(String[] args) {
        String s = "aaabbccd";
        System.out.println(findSubString(s, 2));
    }

    public static int findSubString(String s, int distinctChar){
        int leftIndex = 0;
        int rightIndex = 0;
        int maxLength = 0;
        HashMap<Character, Integer> freqMap = new HashMap<>(distinctChar + 1);

        while(rightIndex < s.length()){
            if(!freqMap.containsKey(s.charAt(rightIndex)))
                freqMap.put(s.charAt(rightIndex), 1);
            else
                freqMap.put(s.charAt(rightIndex), freqMap.get(s.charAt(rightIndex)) + 1);

            if(freqMap.size() > distinctChar) {
                freqMap.put(s.charAt(leftIndex), freqMap.get(s.charAt(leftIndex)) - 1);
                if (freqMap.get(s.charAt(leftIndex)) == 0)
                    freqMap.remove(s.charAt(leftIndex));
                leftIndex++;
            } else
                maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
            rightIndex++;
        }
        return maxLength;
    }
}
