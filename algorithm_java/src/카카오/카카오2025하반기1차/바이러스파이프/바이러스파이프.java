package 카카오.카카오2025하반기1차.바이러스파이프;
import java.util.*;

public class 바이러스파이프 {
    int maxInfected;
    int k;
    int n;
    List<List<int[]>>tree;
    public int solution(int n, int infection, int[][] edges, int k) {
        maxInfected = 0;
        this.k = k;
        this.n = n;
        tree = new ArrayList<>();
        for(int i=0;i<=n;i++){
            tree.add(new ArrayList<>());
        }
        for(int[]edge : edges){
            tree.get(edge[0]).add(new int[]{edge[1],edge[2]});
            tree.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        for(int i=1;i<=3;i++){
            boolean[]infected = new boolean[n+1];
            infected[infection] = true;
            dfs(i,1,infected);
        }

        return maxInfected;
    }
    public void dfs(int opened, int count, boolean[]currentInfected){
        if(count > k) return;
        boolean[]infected = currentInfected.clone();
        Queue<Integer>queue = new ArrayDeque<>();
        for(int i=1;i<infected.length;i++){
            if(infected[i]) queue.offer(i);
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int[]nxt : tree.get(node)){
                int nxtNode = nxt[0];
                int nxtPt = nxt[1];
                if(nxtPt == opened && !infected[nxtNode]){
                    infected[nxtNode] = true;
                    queue.offer(nxtNode);
                }
            }
        }
        int infectCount = 0;
        for(boolean bool : infected){
            if(bool) infectCount++;
        }
        maxInfected = Math.max(maxInfected, infectCount);
        if(count == k || maxInfected == n) return;
        for(int i=1;i<=3;i++){
            if(i == opened) continue;
            dfs(i, count+1,infected);
        }
    }
}
