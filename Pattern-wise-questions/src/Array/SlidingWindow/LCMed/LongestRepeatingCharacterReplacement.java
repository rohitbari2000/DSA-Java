package Array.SlidingWindow.LCMed;
//https://leetcode.com/problems/longest-repeating-character-replacement/description

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String s = "AAABBCCD";
        System.out.println(characterReplacement(s, 2));
    }

    public static int characterReplacement(String s, int k){
        int leftIndex = 0;
        int rightIndex = 0;
        int maxLength = 0;
        int windowLength = 0;
        int[] freqArray = new int[26];
        int maxFreq = 0;

        while(rightIndex < s.length()){
            freqArray[s.charAt(rightIndex) - 'A']++;
            maxFreq = Math.max(maxFreq, freqArray[s.charAt(rightIndex) - 'A']);

            windowLength = rightIndex - leftIndex + 1;

            if(windowLength - maxFreq > k) {  //was while at first, can be changed to if to optimize the solution
                freqArray[s.charAt(leftIndex) - 'A']--;
                maxFreq = 0;
//                for(int i = 0; i < 25; i++)  ////can be removed in order to optimise the solution
//                    maxFreq = Math.max(maxFreq, freqArray[i]);
                leftIndex++;
            }
            else if (windowLength - maxFreq <= k)
                maxLength = Math.max(maxLength, rightIndex - leftIndex + 1);
            rightIndex++;
        }
        return maxLength;
    }
}
