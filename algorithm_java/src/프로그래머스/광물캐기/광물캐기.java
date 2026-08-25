package 프로그래머스.광물캐기;

import java.util.HashMap;
import java.util.Map;

public class 광물캐기 {
    Map<Integer,int[]> pickaxe;
    int answer = Integer.MAX_VALUE;
    public int solution(int[] picks, String[] minerals) {
        pickaxe = new HashMap<>();
        pickaxe.put(0, new int[]{1,1,1});
        pickaxe.put(1, new int[]{5,1,1});
        pickaxe.put(2, new int[]{25,5,1});
        dfs(0, picks, minerals, 0);

        return answer;
    }
    public void dfs(int index, int[]picks, String[] minerals, int fatigue){
        if((picks[0] == 0 && picks[1] == 0 && picks[2] == 0) || index > minerals.length - 1){
            answer = Math.min(answer, fatigue);
            return;
        }
        for(int i=0;i<3;i++){
            if(picks[i] == 0) continue;
            picks[i]--;
            int nextIndex = index;
            int cost = 0;
            while(nextIndex < minerals.length && nextIndex < index + 5){
                int mIdx = getIndex(minerals[nextIndex++]);
                cost += pickaxe.get(i)[mIdx];
            }
            dfs(nextIndex, picks, minerals, fatigue + cost);
            picks[i]++;
        }
    }

    public int getIndex(String mineral){
        switch(mineral){
            case "diamond" : return 0;
            case "iron" : return 1;
            case "stone" : return 2;
        }
        return -1;
    }
}
