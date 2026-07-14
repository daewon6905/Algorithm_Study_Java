package 프로그래머스.등산코스정하기;

import java.util.*;

public class 등산코스정하기 {
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[]answer = new int[2];
        int[]dist = new int[n+1];
        boolean[]isSummit = new boolean[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        List<List<int[]>>graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int summit : summits){
            isSummit[summit] = true;
        }
        for(int[]path : paths){
            graph.get(path[0]).add(new int[]{path[1],path[2]});
            graph.get(path[1]).add(new int[]{path[0],path[2]});
        }
        Queue<int[]> pq = new PriorityQueue<>((x, y)->Integer.compare(x[1],y[1]));
        for(int gate : gates){
            dist[gate] = 0;
            pq.offer(new int[]{gate,0});
        }
        while(!pq.isEmpty()){
            int[]cur = pq.poll();
            int node = cur[0];
            int intensity = cur[1];
            if(isSummit[node]) continue;
            if(intensity > dist[node]) continue;
            for(int[]nxt : graph.get(node)){
                int nxtNode = nxt[0];
                int w = nxt[1];
                int nxtIntensity = Math.max(dist[node],w);
                if(nxtIntensity < dist[nxtNode]){
                    dist[nxtNode] = nxtIntensity;
                    pq.offer(new int[]{nxtNode,nxtIntensity});
                }
            }
        }
        int minIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits);
        for(int s : summits){
            if(dist[s] < minIntensity){
                minIntensity = dist[s];
                answer[0] = s;
                answer[1] = dist[s];
            }
        }
        return answer;
    }
}
