package String.LCMed;
//https://leetcode.com/problems/palindromic-substrings/description/
public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int oddSubstrings = getSubstringCount(s, i, i);
            int evenSubstrings = getSubstringCount(s, i, i+1);
            ans += oddSubstrings + evenSubstrings;
        }
        return ans;
    }

    private static int getSubstringCount(String s, int left, int right) {
        int count = 0;
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
