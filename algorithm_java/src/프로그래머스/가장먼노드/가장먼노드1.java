package 프로그래머스.가장먼노드;

import java.util.*;

public class 가장먼노드1 {
    public int solution(int n, int[][] edge) {
        List<List<Integer>>graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]e : edge){
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        int[]dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{1,0});
        dist[1] = 0;
        int max = 0;
        while(!pq.isEmpty()){
            int[]cur = pq.poll();
            int curNode = cur[0];
            int currentDistance = cur[1];
            if(currentDistance > dist[curNode]) continue;

            for(int next : graph.get(curNode)){
                if(dist[next] > currentDistance + 1){
                    dist[next] = currentDistance + 1;
                    max = Math.max(max, currentDistance + 1);
                    pq.offer(new int[]{next, currentDistance + 1});
                }
            }
        }
        int count = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == max) count++;
        }
        return count;
    }
}
