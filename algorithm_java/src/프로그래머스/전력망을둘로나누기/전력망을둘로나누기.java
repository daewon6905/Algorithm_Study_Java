package 프로그래머스.전력망을둘로나누기;

import java.util.ArrayList;
import java.util.List;

public class 전력망을둘로나누기 {
    public int solution(int n, int[][] wires) {
        List<List<Integer>>wire = new ArrayList<>();
        List<List<Integer>>disconnect = new ArrayList<>();
        int answer = Integer.MAX_VALUE;

        for(int i=0;i<=n;i++){
            wire.add(new ArrayList<>());
            disconnect.add(new ArrayList<>());
        }
        for(int[]w : wires){
            wire.get(w[0]).add(w[1]);
            wire.get(w[1]).add(w[0]);
            disconnect.get(w[0]).add(w[1]);
        }
        for(int i=1;i<=n;i++){
            for(int remove : disconnect.get(i)){
                boolean[]visited = new boolean[n+1];
                wire.get(i).remove(Integer.valueOf(remove));
                wire.get(remove).remove(Integer.valueOf(i));
                int nodeN = dfs(remove, wire, visited);
                int c = n - nodeN;
                answer = Math.min(answer, Math.abs(c-nodeN));
                wire.get(i).add(remove);
                wire.get(remove).add(i);
            }
        }
        return answer;
    }
    int dfs(int node, List<List<Integer>>wire, boolean[]visited){
        visited[node] = true;
        int count = 1;
        for(int nxt : wire.get(node)){
            if(!visited[nxt]){
                count += dfs(nxt, wire, visited);
            }
        }
        return count;
    }
}
