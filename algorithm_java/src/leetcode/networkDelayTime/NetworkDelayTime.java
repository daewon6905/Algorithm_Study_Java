package leetcode.networkDelayTime;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[]dist = new int[n+1];
        List<List<int[]>>graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]time : times){
            graph.get(time[0]).add(new int[]{time[1],time[2]});
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<int[]> pq = new PriorityQueue<>((x, y)->Integer.compare(x[1],y[1])); // or (x,y) -> x[1]-y[1]
        pq.offer(new int[]{k,0});
        dist[k] = 0;

        while(!pq.isEmpty()){
            int[]cur = pq.poll();
            int index = cur[0];
            int currentDist = cur[1];
            if(currentDist > dist[index]) continue;
            for(int[]nxt : graph.get(index)){
                if(dist[nxt[0]] > currentDist + nxt[1]){
                    dist[nxt[0]] = currentDist + nxt[1];
                    pq.offer(new int[]{nxt[0],currentDist + nxt[1]});
                }
            }
        }
        int max = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE) return -1;
            if(dist[i]>max){
                max = dist[i];
            }
        }
        return max;
    }
}
