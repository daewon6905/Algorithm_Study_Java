package 프로그래머스.달리기경주;

import java.util.HashMap;
import java.util.Map;

public class 달리기경주 {
    public String[] solution(String[] players, String[] callings) {
        int n = players.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(players[i], i);
        }
        for(String calling : callings){
            int curIdx = map.get(calling);
            String before = players[curIdx-1];
            updateMap(calling, before, map);
            players[curIdx] = before;
            players[curIdx-1] = calling;
        }
        return players;
    }
    public void updateMap(String current, String before, Map<String,Integer>map){
        int currentIdx = map.get(current);
        int beforeIdx = map.get(before);
        map.put(current, beforeIdx);
        map.put(before, currentIdx);
    }
}
