package String.LCEasy;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/ransom-note/
public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        System.out.println(canConstructFaster(ransomNote, magazine));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        Map<Character, Integer> freqMap = new HashMap<>(magazine.length());

        for (int i = 0; i < magazine.length(); i++) {
            char currentChar = magazine.charAt(i);
            freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            char currentChar = ransomNote.charAt(i);
            if (!freqMap.containsKey(currentChar))
                return false;
            freqMap.put(currentChar, freqMap.get(currentChar) - 1);
            if(freqMap.get(currentChar) <= 0)
                freqMap.remove(currentChar);
        }
        return true;
    }

    // faster and better solution :
    public static boolean canConstructFaster(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length())
            return false;

        int[] freqArr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            int currentChar = magazine.charAt(i) - 'a';
            freqArr[currentChar]++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int currentChar = ransomNote.charAt(i) - 'a';
            freqArr[currentChar]--;
            if (freqArr[currentChar] <= 0)
                return false;
        }
        return true;
    }
}
