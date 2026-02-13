package String.LCMed;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsInString {
    public static void main(String[] args) {
        String s = "abab", p = "ab";
        System.out.println(findAnagrams(s, p));
    }

    public static List<Integer> findAnagrams(String s, String p) {
        if(s.length() < p.length())
            return new ArrayList<>();

        char[] pCharArray = p.toCharArray();
        Arrays.sort(pCharArray);
        ArrayList<Integer> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < p.length(); i++) {
            sb.append(s.charAt(i));
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            char[] sbCharArray = sb.toString().toCharArray();
            Arrays.sort(sbCharArray);
            String subString = new String(sbCharArray);
            if (subString.equals(new String(pCharArray))) {
                ans.add(i);
            }
            sb.append(s.charAt(i + p.length()));
            sb.deleteCharAt(0);
        }
        char[] sbCharArray = sb.toString().toCharArray();
        Arrays.sort(sbCharArray);
        String subString = new String(sbCharArray);
        if (subString.equals(new String(pCharArray))) {
            ans.add(s.length() - p.length());
        }
        return ans;
    }

    // Much Better
    public List<Integer> findAnagramsLeetcodeDiscussions(String s, String p) {
        List<Integer> res=new ArrayList<>();
        char[] st=p.toCharArray();
        Arrays.sort(st);
        for(int i=0;i<=s.length()-p.length();i++){
            char [] temp=s.substring(i,i+p.length()).toCharArray();

            Arrays.sort(temp);

            if(Arrays.equals(temp,st)){
                res.add(i);
            }
        }
        return res;
    }
}
