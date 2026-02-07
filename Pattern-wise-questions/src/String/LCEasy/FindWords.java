package String.LCEasy;

import java.util.Arrays;

//https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/description/
public class FindWords {
    public static void main(String[] args) {
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(words, chars));
    }

    public static int countCharacters(String[] words, String chars) {
        int result = 0;

        int[] freqArray = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            freqArray[chars.charAt(i) - 'a']++;
        }

        for (int i = 0; i < words.length; i++) {
            boolean flag = true;
            int[] duplicateFreqArray = Arrays.copyOf(freqArray, freqArray.length);
            for (int j = 0; j < words[i].length(); j++) {
                int currentChar = words[i].charAt(j) - 'a';
                if(duplicateFreqArray[currentChar]-- <= 0) {
                    flag = false;
                }
            }
            if(flag)
                result += words[i].length();
        }
        return result;
    }

//    Faster code :
//    public int countCharactersFaster(String[] words, String chars) {
//        int[] charFreq = new int[26];
//        for (char c : chars.toCharArray()) {
//            charFreq[c - 'a']++;
//        }
//        int totalLength = 0;
//        for (String word : words) {
//            int[] wordFreq = new int[26];
//            for (char c : word.toCharArray()) {
//                wordFreq[c - 'a']++;
//            }
//            boolean canForm = true;
//            for (int i = 0; i < 26; i++) {
//                if (wordFreq[i] > charFreq[i]) {
//                    canForm = false;
//                    break;
//                }
//            }
//            if (canForm) {
//                totalLength += word.length();
//            }
//        }
//        return totalLength;
//    }
}
