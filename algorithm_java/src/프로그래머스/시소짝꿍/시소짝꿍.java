package 프로그래머스.시소짝꿍;

import java.util.HashMap;
import java.util.Map;

public class 시소짝꿍 {
    public long solution(int[] weights) {
        long answer = 0;

        Map<Integer, Integer> map = new HashMap<>();
        for(int w : weights){
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        for(int key : map.keySet()){
            long count = 0;
            long current = map.get(key);
            count += current * (current - 1) / 2;

            if(map.containsKey(key*2)){
                count += (long) map.get(key * 2) * current;
            }
            if(key%2==0){
                int target = key*3/2;
                if(map.containsKey(target)){
                    count += (long) map.get(target) * current;
                }
            }
            if(key%3==0){
                int target = key*4/3;
                if(map.containsKey(target)){
                    count += (long) map.get(target) * current;
                }
            }
            answer += count;
        }
        return answer;
    }
    // 스택 오버플로우 주의 시발시발t시발t시발t시발t시발t시발t시발t시발t시발t시발t시발t시발t시발t시발t시발t시발t시발t시발t
    // public int sum(int n){
    //     if(n == 0) return 0;
    //     if(n == 1) return 1;
    //     return n + sum(n-1);
    // }
}
