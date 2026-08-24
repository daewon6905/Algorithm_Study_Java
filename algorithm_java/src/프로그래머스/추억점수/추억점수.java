package 프로그래머스.추억점수;

import java.util.HashMap;
import java.util.Map;

public class 추억점수 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int n = photo.length;
        int[] answer = new int[n];
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<name.length;i++){
            map.put(name[i],yearning[i]);
        }
        for(int i=0;i<n;i++){
            int total = 0;
            for(int j=0;j<photo[i].length;j++){
                String currentName = photo[i][j];
                if(map.containsKey(currentName)){
                    total+=map.get(currentName);
                }
            }
            answer[i] = total;
        }
        return answer;
    }
}
