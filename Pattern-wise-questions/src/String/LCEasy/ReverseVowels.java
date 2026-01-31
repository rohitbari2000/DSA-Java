package String.LCEasy;

//https://leetcode.com/problems/reverse-vowels-of-a-string/description/
public class ReverseVowels {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(reverseVowels(s));
    }

    private static String reverseVowels(String s) {
        char[] word = s.toCharArray();

        int leftIndex = 0, rightIndex = s.length() - 1;
        char temp = '\s';
        while(leftIndex < rightIndex) {
            while(leftIndex < rightIndex && !isVowel(s.charAt(leftIndex)))
                leftIndex++;

            while(leftIndex < rightIndex && !isVowel(s.charAt(rightIndex)))
                rightIndex--;

            temp = word[leftIndex];
            word[leftIndex] = word[rightIndex];
            word[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
        return new String(word);
    }

    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }
}
