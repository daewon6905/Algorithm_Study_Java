package leetcode.isGraphBipartite;

import java.util.Arrays;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[]mark = new int[n];
        Arrays.fill(mark,-1);
        for(int i=0;i<n;i++){
            if(mark[i] == -1){
                mark[i] = 1;
                if(!dfs(i,mark,graph)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean dfs(int start, int[]mark, int[][]graph){

        for(int nxt : graph[start]){
            if(mark[nxt] == -1){
                mark[nxt] = 1 - mark[start];
                if(!dfs(nxt,mark,graph)) return false;
            }
            if(mark[nxt] == mark[start]){
                return false;
            }
        }
        return true;
    }
}
