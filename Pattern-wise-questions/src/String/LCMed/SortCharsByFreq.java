package String.LCMed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/sort-characters-by-frequency/description/
public class SortCharsByFreq {
    public static void main(String[] args) {
        String s = "cccaaa";
        System.out.println(frequencySortFaster(s));
    }

    // O(nlogn)
    public static String frequencySort(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> freqMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            freqMap.put(s.charAt(i), freqMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        ArrayList<Map.Entry<Character, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        entries.sort((a,b) -> b.getValue() - a.getValue());
        for (int i = 0; i < entries.size(); i++) {
            for (int j = 0; j < entries.get(i).getValue(); j++) {
                sb.append(entries.get(i).getKey());
            }
        }
        return sb.toString();
    }

    // O(n)  VVVVVVVVV IMP
    public static String frequencySortFaster(String s) {
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        List<Character>[] buckets = new List[s.length() + 1];
        for(char ch : freqMap.keySet()){
            Integer currentInt = freqMap.get(ch);
            if(buckets[currentInt] == null)
                buckets[currentInt] = new ArrayList<>();
            buckets[currentInt].add(ch);
        }

        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null){
                for (char ch : buckets[i]){
                    for (int j = 0; j < i; j++) {
                        sb.append(ch);
                    }
                }
            }
        }

        return sb.toString();
    }
}
