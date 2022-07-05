package 力扣;

import java.util.HashMap;
import java.util.Map;

public class Lc424CharacterReplacement {

    public static void main(String[] args) {
        String s = "ABCDE";
        int k = 1;

        System.out.println(new Lc424CharacterReplacement().characterReplacement(s, k));
    }
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() <= k + 1) return s.length(); // 替换个数不超过 K 个

        // 以 s 的第一个元素来初始化变量
        char maxChar = s.charAt(0);
        int maxLen = 1;
        Map<Character, Integer> countMap = new HashMap<>(); // 出现过的字母和出现次数
        countMap.put(maxChar, 1);
        int left = 0;
        int right = 1;
        while(right < s.length()){
            char rightChar = s.charAt(right);

            // 新出现的 char 还是 maxChar: right 继续向右移动
            if (rightChar == maxChar){
                countMap.put(maxChar, countMap.get(maxChar) + 1);
                right++;
                continue;
            }

            // 新出现的 char 不是 maxChar: 刷新变量
            // 刷新字母出现次数
            if (!countMap.containsKey(rightChar)){
                countMap.put(rightChar, 1);
            } else {
                countMap.put(rightChar,countMap.get(rightChar) + 1);
            }

            // k 还能 hold 得住: 只刷新 maxChar
            if (Math.min(right-left+1-countMap.get(rightChar), right-left+1-countMap.get(maxChar)) <= k){
                if (countMap.get(rightChar) > countMap.get(maxChar)){
                    maxChar = rightChar;
                }
                right++;
            } else {
                // k hold不住了: 刷新 maxChar 和 maxLen 并移动 left 让 k 重新 hold 住
                maxLen = Math.max(maxLen, right-left);

                while (left < right){
                    char leftChar = s.charAt(left);
                    left++;
                    countMap.put(leftChar, countMap.get(leftChar) - 1);
                    maxChar = findMax(countMap);
                    if (right-left+1-countMap.get(maxChar) <= k){
                        right++;
                        break;
                    }
                }
            }
        }

        return Math.max(maxLen, right-left);
    }
    private char findMax(Map<Character, Integer> map){
        char res = ' ';
        int max = 0;
        for (Map.Entry<Character, Integer> entry: map.entrySet()){
            if (entry.getValue() > max){
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    public int characterReplacement1(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        if (s.length() <= k + 1) return s.length();

        int left = 0;
        int right = 0;
        int maxn = 0;
        int[] num = new int[26];
        while (right < s.length()){
            num[s.charAt(right) - 'A']++;
            maxn = Math.max(maxn, num[s.charAt(right)-'A']);
            if (right-left+1-maxn > k){
                num[s.charAt(left)-'A']--;
                left++;
            }
            right++;
        }
        return right-left;
    }
}
