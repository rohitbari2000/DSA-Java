package String.LCEasy;

//https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isValidPalindrome(s));
    }

    private static boolean isValidPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
//        StringBuilder sb = new StringBuilder();
//        s = s.toLowerCase();
//        for (int i = 0; i < s.length(); i++) {
//            if(Character.isLetterOrDigit(s.charAt(i))){
//                sb.append(s.charAt(i));
//            }
//        }

        int leftIndex = 0;
        int rightIndex = s.length() - 1;
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
