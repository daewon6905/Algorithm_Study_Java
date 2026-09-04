package 프로그래머스.대충만든자판;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 대충만든자판 {
    public int[] solution(String[] keymap, String[] targets) {
        int n = targets.length;
        int[] answer = new int[n];
        List<Map<Character, Integer>> keyMaps = new ArrayList<>();
        for(int i=0;i<keymap.length;i++){
            keyMaps.add(new HashMap<>());
            char[]arr = keymap[i].toCharArray();
            for(int j=0;j<arr.length;j++){
                keyMaps.get(i).putIfAbsent(arr[j], j+1);
            }
        }
        int[]globalMin = new int[26];
        for(char c='A';c<='Z';c++){
            int min = Integer.MAX_VALUE;
            for(Map<Character, Integer> m : keyMaps){
                if(m.containsKey(c)) min = Math.min(min, m.get(c));
            }
            globalMin[c-'A'] = min;
        }
        for(int i=0;i<targets.length;i++){
            for(char c : targets[i].toCharArray()){
                if(globalMin[c-'A'] == Integer.MAX_VALUE){
                    answer[i] = -1;
                    break;
                }
                answer[i] += globalMin[c-'A'];
            }
        }
        return answer;
    }
}
