package String.LCEasy;

import java.util.LinkedHashMap;
import java.util.Map;

//https://leetcode.com/problems/first-unique-character-in-a-string/description/
public class FirstUniqueChar {
    public static void main(String[] args) {
        String s = "aabb";
        System.out.println(firstUniqChar(s));
    }

    public static int firstUniqChar(String s) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if(freqMap.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }

//    Faster code:
//    public int firstUniqChar(String s) {
//        int n = s.length();
//        int[] arr = new int[26];
//
//        for (int i = 0; i < n; i++) {
//            int ch = s.charAt(i) - 'a';
//            arr[ch]++;
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (arr[s.charAt(i) - 'a'] == 1) {
//                return i;
//            }
//        }
//        return -1;
//    }
}
