import java.util.HashMap;
import java.util.Map;

class SlidingWindow {

    public static void main(String[] args) {

        String str1 = "abcabcbb";
        String str2 = "bbbbb";
        String str3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(str3));
    }

    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.isEmpty()) return 0;

        Map<Character, Integer> charMap = new HashMap<>();
        int length = 1;
        int leftPtr = 0;
        for (int rightPtr = 0; rightPtr < s.length(); rightPtr++) {
            char currentChar = s.charAt(rightPtr);
            if (charMap.containsKey(currentChar)) {
                leftPtr = Math.max(leftPtr, charMap.get(currentChar) + 1);
            }
            charMap.put(currentChar, rightPtr);
            length = Math.max(length, rightPtr - leftPtr + 1);
        }

        return length;
    }
}