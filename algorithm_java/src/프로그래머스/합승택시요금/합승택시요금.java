package 프로그래머스.합승택시요금;

import java.util.*;

public class 합승택시요금 {
    int n;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        this.n = n;
        List<List<int[]>>graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]fare : fares){
            graph.get(fare[0]).add(new int[]{fare[1],fare[2]});
            graph.get(fare[1]).add(new int[]{fare[0],fare[2]});
        }
        int[]distS = dikjstra(s,graph);
        int[]distA = dikjstra(a,graph);
        int[]distB = dikjstra(b,graph);
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            answer = Math.min(answer,distS[i]+distA[i]+distB[i]);
        }
        return answer;
    }

    public int[]dikjstra(int start,List<List<int[]>>graph){
        int[]dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Queue<int[]>pq = new PriorityQueue<>((x,y)->x[1]-y[1]);
        dist[start] = 0;
        pq.offer(new int[]{start,0});
        while(!pq.isEmpty()){
            int[]cur = pq.poll();
            int curNode = cur[0];
            int w = cur[1];
            if(dist[curNode] < w) continue;
            for(int[]nxt : graph.get(curNode)){
                int nxtNode = nxt[0];
                int nxtW = w + nxt[1];
                if(nxtW < dist[nxtNode]){
                    dist[nxtNode] = nxtW;
                    pq.offer(new int[]{nxtNode, nxtW});
                }
            }
        }
        return dist;
    }
}
