package String.LCMed;

//https://leetcode.com/problems/permutation-in-string/description/
public class PermutationInString {
    public static void main(String[] args) {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));
    }

    public static boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())
            return false;

        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if(matches(s1Freq, s2Freq)) {
                return true;
            }
            s2Freq[s2.charAt(i) - 'a']--;
            s2Freq[s2.charAt(i + s1.length()) - 'a']++;
        }
        return matches(s1Freq, s2Freq);
    }

    private static boolean matches(int[] s1Freq, int[] s2Freq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != s2Freq[i]) {
                return false;
            }
        }
        return true;
    }
}
