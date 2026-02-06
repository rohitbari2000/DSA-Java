package String.LCEasy;

//https://leetcode.com/problems/valid-palindrome-ii/description/
public class ValidPalindrome2 {
    public static void main(String[] args) {
        String s = "abnbca";
        System.out.println(validPalindrome(s));
    }

    public static boolean validPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        int leftIndex = 0;
        int rightIndex = s.length() - 1;
        int exception = 1;
        while(leftIndex <= rightIndex) {
            if(s.charAt(leftIndex) != s.charAt(rightIndex)){
                if(exception <= 0)
                    return false;
                exception--;
                return validSubPalindrome(leftIndex + 1, rightIndex, s) || validSubPalindrome(leftIndex, rightIndex - 1, s);
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }

    private static boolean validSubPalindrome(int leftIndex, int rightIndex, String s) {
        while(leftIndex < rightIndex) {
            if(s.charAt(leftIndex) != s.charAt(rightIndex)){
                return false;
            }
            leftIndex++;
            rightIndex--;
        }
        return true;
    }
}
