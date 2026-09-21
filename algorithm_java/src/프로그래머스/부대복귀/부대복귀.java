package 프로그래머스.부대복귀;

import java.util.*;

public class 부대복귀 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[]answer = new int[sources.length];
        Arrays.fill(answer, Integer.MAX_VALUE);
        List<List<Integer>>graph = new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]road : roads){
            graph.get(road[0]).add(road[1]);
            graph.get(road[1]).add(road[0]);
        }
        for(int i=0;i<sources.length;i++){
            int start = sources[i];
            if(start == destination){
                answer[i] = 0;
                continue;
            }
            boolean[]visited = new boolean[n+1];
            Queue<int[]> queue = new ArrayDeque<>();
            visited[start] = true;
            queue.offer(new int[]{start, 0});
            while(!queue.isEmpty()){
                int[]cur = queue.poll();
                int curNode = cur[0];
                int dist = cur[1];
                if(curNode == destination){
                    answer[i] = dist;
                    break;
                }
                for(int nxt : graph.get(curNode)){
                    if(!visited[nxt]){
                        visited[nxt] = true;
                        queue.offer(new int[]{nxt, dist+1});
                    }
                }
            }
            if(answer[i] == Integer.MAX_VALUE) answer[i] = -1;
        }
        return answer;
    }
}
