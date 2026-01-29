package String.LCEasy;

import java.util.Arrays;

//https://leetcode.com/problems/reverse-string/
public class ReverseString {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        System.out.println(Arrays.toString(reverseCharArray(s)));
    }

    private static char[] reverseCharArray(char[] s) {
        int leftIndex = 0;
        int rightIndex = s.length - 1;
        char temp = '\s';
        while(leftIndex < rightIndex) {
            temp = s[leftIndex];
            s[leftIndex] = s[rightIndex];
            s[rightIndex] = temp;
            leftIndex++;
            rightIndex--;
        }
        return s;
    }
}
