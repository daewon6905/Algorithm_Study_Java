package leetcode.reachableNodesInSubdividedGraph;

import java.util.*;

public class ReachableNodesInSubdividedGraph {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        List<List<int[]>>graph = new ArrayList<>();
        int[]dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]edge : edges){
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]+1});
            graph.get(edge[1]).add(new int[]{edge[0],edge[2]+1});
        }
        Queue<int[]> pq = new PriorityQueue<>((x, y)->x[1]-y[1]);
        pq.offer(new int[]{0,0});
        dist[0] = 0;
        while(!pq.isEmpty()){
            int[]cur = pq.poll();
            int node = cur[0];
            int w = cur[1];
            if(w > dist[node]) continue;
            for(int[]nxt : graph.get(node)){
                int nxtNode = nxt[0];
                int nxtW = w + nxt[1];
                if(dist[nxtNode] > nxtW){
                    pq.offer(new int[]{nxtNode, nxtW});
                    dist[nxtNode] = nxtW;
                }
            }
        }
        int answer = 0;
        for(int i=0;i<n;i++){
            if(maxMoves >= dist[i]) answer++;
        }
        for(int[]edge : edges){
            int u = edge[0];
            int v = edge[1];
            int d = edge[2];
            int remainU = dist[u] > maxMoves ? 0 : maxMoves - dist[u];
            int remainV = dist[v] > maxMoves ? 0 : maxMoves - dist[v];
            answer += Math.min(d , remainU + remainV);
        }
        return answer;
    }
}
