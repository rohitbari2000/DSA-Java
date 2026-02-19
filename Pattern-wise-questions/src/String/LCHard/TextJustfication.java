package String.LCHard;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/text-justification/description/
public class TextJustfication {
    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        System.out.println(fullJustify(words, 16));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while(i < words.length){
            int j = i, count = 0;
            while(j < words.length && count + words[j].length() + (j-i) <= maxWidth){ // imp
                count += words[j].length();
                j++;
            }
            int gaps = j-i-1;
            int spaces = maxWidth - count;

            StringBuilder line = new StringBuilder();

            if(j == words.length || gaps == 0){
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if(k != j-1)
                        line.append(" ");
                }
                while(line.length() < maxWidth)
                    line.append(" ");
            } else {
                int spaceForEach = spaces / gaps, extra = spaces % gaps;
                for (int k = i; k < j; k++) {
                    line.append(words[k]);
                    if(k != j-1){
                        int addSpaces = spaceForEach + (extra-- > 0 ? 1 : 0);
                        line.append(" ".repeat(addSpaces)); // .repeat() = star method
                    }
                }
            }
            result.add(line.toString());
            i = j;
        }
        return result;
    }

}
