package leetcode.minimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        int min = Integer.MAX_VALUE;
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer>window = new HashMap<>();
        for(char c : t.toCharArray()){
            tmap.put(c, tmap.getOrDefault(c,0)+1);
        }
        int left = 0;
        int right = 0;
        int n = s.length();
        int formed = 0;
        int start = 0;
        int required = tmap.size();

        while(right < n){
            char cur = s.charAt(right);
            window.put(cur,window.getOrDefault(cur,0)+1);
            if(tmap.containsKey(cur) && window.get(cur).intValue()
                    == tmap.get(cur).intValue()){
                formed++;
            }
            while(left<=right && formed == required){
                if(min > right-left+1){
                    min = right-left+1;
                    start = left;
                }
                char leftChar = s.charAt(left);
                window.put(leftChar,window.get(leftChar)-1);
                if(tmap.containsKey(leftChar) && tmap.get(leftChar).intValue()
                        > window.get(leftChar).intValue()){
                    formed--;
                }
                left++;
            }
            right++;
        }
        return min == Integer.MAX_VALUE ? "" : s.substring(start,start+min);
    }
}
