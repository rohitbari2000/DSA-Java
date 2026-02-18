package String.LCHard;

import java.util.Stack;

//https://leetcode.com/problems/basic-calculator/description/
public class BasicCalculator {
    public static void main(String[] args) {
        String s  = "(1+(4+5+2)-3)+(6+8)";
        String s2  = "1 + 1";
        System.out.println(calculate(s));
    }

    public static int calculate(String s){
        Stack<Integer> digitStack = new Stack<Integer>();
        int sign = 1;
        int ans = 0;
        int currNo = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                currNo = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    currNo = currNo * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                currNo *= sign;
                ans += currNo;
                currNo = 0;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                digitStack.push(ans);
                digitStack.push(sign);
                ans = 0;
                sign = 1;
            } else if (c == ')') {
                int prevSign = digitStack.pop();
                ans *= prevSign;
                int prevAns = digitStack.pop();
                ans += prevAns;
            }
        }
        return ans;
    }
}
