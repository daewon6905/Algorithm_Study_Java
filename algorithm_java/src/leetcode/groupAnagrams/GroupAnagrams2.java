package leetcode.groupAnagrams;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams2 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();

        for(String s : strs){
            StringBuilder sb = new StringBuilder();
            char[]c = s.toCharArray();
            int[]count  = new int[26];
            for(char ch : c){
                count[ch-'a'] += 1;
            }
            for(int i=0;i<26;i++){
                sb.append("%").append(count[i]);
            }
            map.computeIfAbsent(sb.toString(),x->new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
