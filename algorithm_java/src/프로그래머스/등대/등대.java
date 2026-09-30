package 프로그래머스.등대;

import java.util.ArrayList;
import java.util.List;

public class 등대 {
    public int solution(int n, int[][] lighthouse) {
        int[][]dp = new int[n+1][2];
        List<List<Integer>> tree = new ArrayList<>();
        for(int i=0;i<=n;i++){
            tree.add(new ArrayList<>());
        }
        for(int[]lh : lighthouse){
            tree.get(lh[0]).add(lh[1]);
            tree.get(lh[1]).add(lh[0]);
        }
        dfs(tree, dp, 1, 0);
        return Math.min(dp[1][0], dp[1][1]);
    }
    void dfs(List<List<Integer>> tree, int[][]dp, int u, int parent){
        dp[u][1] = 1;
        for(int child : tree.get(u)){
            if(parent == child) continue;
            dfs(tree, dp, child, u);
            dp[u][0] += dp[child][1];
            dp[u][1] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}
