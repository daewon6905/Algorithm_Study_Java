package 프로그래머스.네트워크;

import java.util.ArrayList;
import java.util.List;

public class 네트워크 {
    int count = 0;
    public int solution(int n, int[][] computers) {
        List<List<Integer>> graph = new ArrayList<>();
        boolean[]visited = new boolean[n];
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && computers[i][j] == 1){
                    graph.get(i).add(j);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(i, visited, graph);
                count++;
            }
        }
        return count;
    }
    public void dfs(int node, boolean[]visited, List<List<Integer>>graph){
        visited[node] = true;
        for(int nxt : graph.get(node)){
            if(!visited[nxt]){
                visited[nxt] = true;
                dfs(nxt, visited, graph);
            }
        }
    }
}
