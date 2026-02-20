package Array.SlidingWindow.LCMed;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description
import java.util.Arrays;

public class LongestSubStringWithoutRepeating {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s){
        int[] charIndexArray = new int[256];
        Arrays.fill(charIndexArray, -1);
        int leftIndex = 0;
        int rightIndex = 0;
        int maxLength = 0;

        while(rightIndex < s.length()){
            if(charIndexArray[s.charAt(rightIndex)] != -1){
                if(charIndexArray[s.charAt(rightIndex)] >= leftIndex)
                    leftIndex = charIndexArray[s.charAt(rightIndex)] + 1;
            }
            maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
            charIndexArray[s.charAt(rightIndex)] = rightIndex;
            rightIndex++;
        }
        return maxLength;
    }
}
