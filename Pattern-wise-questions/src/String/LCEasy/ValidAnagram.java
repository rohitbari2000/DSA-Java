package String.LCEasy;

import java.util.Arrays;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "rat", t = "car";
        System.out.println(isValidAnagram(s, t));
    }

    private static boolean isValidAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        char[] firstCharArray = s.toCharArray();
        char[] secondCharArray = t.toCharArray();
        Arrays.sort(firstCharArray);
        Arrays.sort(secondCharArray);

        for (int iterator = 0; iterator < s.length(); iterator++) {
            if(firstCharArray[iterator] != secondCharArray[iterator]){
                return false;
            }
        }
        return true;
    }
}
