package 프로그래머스.롤케이크자르기;

import java.util.HashMap;
import java.util.Map;

public class 롤케이크자르기 {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> mapL = new HashMap<>();
        Map<Integer, Integer> mapR = new HashMap<>();
        for(int t : topping){
            mapR.put(t, mapR.getOrDefault(t,0)+1);
        }
        for(int i=0;i<topping.length;i++){
            int current = topping[i];
            int countR = mapR.get(current);
            if(countR-1 == 0){
                mapR.remove(current);
            }else{
                mapR.put(current, countR-1);
            }
            mapL.put(current, mapL.getOrDefault(current,0)+1);
            if(mapR.keySet().size() == mapL.keySet().size()) answer++;
        }
        return answer;
    }
}
