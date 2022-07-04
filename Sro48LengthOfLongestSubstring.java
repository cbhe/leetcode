import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

public class Sro48LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        Sro48LengthOfLongestSubstring obj = new Sro48LengthOfLongestSubstring();
        System.out.println(obj.lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        Set<Character> contentSet = new HashSet<>();
        int maxLen = 0;

        while (right < s.length()){
            Character curChar = s.charAt(right);
            if (!contentSet.contains(curChar)){
                contentSet.add(curChar);
                right++;
                continue;
            }

            maxLen = Math.max(right-left, maxLen);
            while(contentSet.contains(curChar)){
                contentSet.remove(s.charAt(left));
                left ++;
            }
        }

        maxLen = Math.max(right-left, maxLen);
        return maxLen;
    }
}
