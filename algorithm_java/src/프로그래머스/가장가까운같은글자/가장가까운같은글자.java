package 프로그래머스.가장가까운같은글자;

import java.util.HashMap;
import java.util.Map;

public class 가장가까운같은글자 {
    public int[] solution(String s) {
        int n = s.length();
        int[]answer = new int[n];
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c,i);
                answer[i] = -1;
            }else{
                int before = map.get(c);
                map.put(c, i);
                answer[i] = i-before;
            }
        }
        return answer;
    }
}
