package String.LCMed;

//https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
public class MaxNumOfVowelsInSubstring {
    public static void main(String[] args) {
        String s = "aeiou";
        System.out.println(maxVowels(s, 2));
    }

    public static int maxVowels(String s, int k) {
        int leftIndex = 0;
        int count = 0;
        int maxCount = 0;
        for (int rightIndex = 0; rightIndex < s.length(); rightIndex++) {
            if(rightIndex - leftIndex + 1 > k) {
                if(isVowel(s.charAt(leftIndex)))
                    count--;
                leftIndex++;
            }
            if(isVowel(s.charAt(rightIndex))) {
                count++;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }

    public static boolean isVowel(char c) {
        return "aeiou".indexOf(c) != -1;
    }
}
