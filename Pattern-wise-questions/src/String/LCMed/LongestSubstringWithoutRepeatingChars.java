package String.LCMed;

import java.util.Arrays;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class LongestSubstringWithoutRepeatingChars {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int[] seenCharsIndexArray = new int[256];
        Arrays.fill(seenCharsIndexArray, -1);

        int leftIndex = 0;
        int rightIndex = 0;
        int maxLength = 0;

        while(rightIndex < s.length()) {
            if(seenCharsIndexArray[s.charAt(rightIndex)] != -1) {
                if(seenCharsIndexArray[s.charAt(rightIndex)] >= leftIndex) {
                    leftIndex = seenCharsIndexArray[s.charAt(rightIndex)] + 1;
                }
            }
            maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
            seenCharsIndexArray[s.charAt(rightIndex)] = rightIndex;
            rightIndex++;
        }

        return maxLength;
    }
}
