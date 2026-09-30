package 프로그래머스.등대;

import java.util.ArrayList;
import java.util.List;

public class 등대2 {
    int answer = 0;
    public int solution(int n, int[][] lighthouse) {
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<=n;i++){
            tree.add(new ArrayList<>());
        }
        for(int[]lh : lighthouse){
            tree.get(lh[0]).add(lh[1]);
            tree.get(lh[1]).add(lh[0]);
        }
        dfs(tree, 1, 0);
        return answer;
    }
    boolean dfs(List<List<Integer>> tree, int u, int parent){
        boolean turnOn = false;

        for(int child : tree.get(u)){
            if(parent == child) continue;
            boolean childOn = dfs(tree, child, u);
            if(!childOn){
                turnOn = true;
            }
        }
        //켜야함
        if(turnOn){
            answer++;
            return true;
        }
        return false;
    }
}
