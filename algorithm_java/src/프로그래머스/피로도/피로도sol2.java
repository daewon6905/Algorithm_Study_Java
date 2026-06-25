package 프로그래머스.피로도;

import java.util.ArrayList;
import java.util.List;

public class 피로도sol2 {
    int maxDungeons = 0;
    int n;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        List<List<Integer>> P = new ArrayList<>();
        boolean[]visited = new boolean[n];
        permute(n, new ArrayList<>(), P, visited);

        for(List<Integer>route : P){
            int curMax = 0;
            int cur = k;
            for(int index : route){
                int needed = dungeons[index][0];
                int use = dungeons[index][1];
                if(cur >= needed){
                    cur -= use;
                    curMax++;
                }else{
                    break;
                }
            }
            maxDungeons = Math.max(maxDungeons,curMax);
        }
        return maxDungeons;
    }

    void permute(int n, List<Integer>tmp, List<List<Integer>>P, boolean[]visited){
        if(tmp.size() == n){
            P.add(new ArrayList<>(tmp));
            return;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]){
                visited[i] = true;
                tmp.add(i);
                permute(n,tmp,P,visited);
                visited[i] = false;
                tmp.remove(tmp.size()-1);
            }
        }
    }
}
