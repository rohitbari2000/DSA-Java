package Array.SlidingWindow.LCHard;
//https://leetcode.com/problems/minimum-window-substring/description

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Minimum window: " + minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        for (char c : t.toCharArray())
            map[c]++;

        char[] chS = s.toCharArray();
        while (end < chS.length) {
            if (map[chS[end++]]-- > 0) {
                count--;
            }
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                if (map[chS[start++]]++ == 0) {
                    count++;
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, minLen);
    }

    // Another approach
    public static String minWindow2(String s, String t){
        if(s.length() == 0 || t.length() == 0 || s.length() < t.length())
            return "";

        Map<Character, Integer> mapT = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = mapT.size();
        int l = 0, r = 0;
        int create = 0;
        int[] ans = {-1, 0, 0};

        Map<Character, Integer> substringMap = new HashMap<>();
        while(r < s.length()){
            char c = s.charAt(r);
            int count = substringMap.getOrDefault(c, 0);
            substringMap.put(c, count + 1);
            if(mapT.containsKey(c) && mapT.get(c).intValue() == substringMap.get(c).intValue()){
                create++;
            }
            while(l < r && required == create){
                c = s.charAt(l);
                if(ans[0] == -1 || ans[0] >= r-l+1){
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                substringMap.put(c, substringMap.get(c) - 1);
                if(mapT.containsKey(c) && mapT.get(c).intValue() < substringMap.get(c).intValue()){
                    create--;
                }
                l++;
            }
            r++;
        }
        if(ans[0] == -1)
            return "";
        return s.substring(ans[1], ans[r] + 1);
    }
}
