package leetcode.groupAnagrams;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>>answer = new ArrayList<>();
        String[]sorted = new String[n];
        for(int i=0;i<n;i++){
            char[]c = strs[i].toCharArray();
            Arrays.sort(c);
            sorted[i] = new String(c);
        }
        Map<String, List<String>> map = new HashMap<>();
        for(String s : sorted){
            map.put(s, new ArrayList<>());
        }
        for(String s : strs){
            char[]c = s.toCharArray();
            Arrays.sort(c);
            String s2 = new String(c);
            if(map.containsKey(s2)){
                map.get(s2).add(s);
            }
        }
        for(List<String>list : map.values()){
            answer.add(list);
        }
        return answer;
    }
}
