package leetcode.isGraphBipartite;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class IsGraphBipartite2 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[]mark = new int[n];
        Arrays.fill(mark,-1);

        for(int i=0;i<n;i++){
            if(mark[i] == -1){
                mark[i] = 1;
                if(!bfs(i,mark,graph)){
                    return false;
                }
            }
        }
        return true;
    }
    boolean bfs(int start, int[]mark, int[][]graph){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int nxt : graph[cur]){
                if(mark[nxt] == mark[cur]){
                    return false;
                }
                if(mark[nxt] == -1){
                    mark[nxt] = 1 - mark[cur];
                    queue.offer(nxt);
                }
            }
        }
        return true;
    }
}
