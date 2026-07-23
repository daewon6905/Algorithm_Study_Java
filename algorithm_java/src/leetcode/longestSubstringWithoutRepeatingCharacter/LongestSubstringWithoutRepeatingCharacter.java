package leetcode.longestSubstringWithoutRepeatingCharacter;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacter {
    public int lengthOfLongestSubstring(String s) {
        int answer = 0;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        char[]c = s.toCharArray();
        while(right < n){
            map.put(c[right],map.getOrDefault(c[right],0)+1);
            while(left<=right && map.get(c[right])>1){
                map.put(c[left],map.get(c[left])-1);
                left++;
            }

            answer = Math.max(answer, right-left+1);
            right++;
        }
        return answer;
    }
}
