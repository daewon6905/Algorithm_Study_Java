package graph.bfs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;


//기본적 큐를 활용한 BFS 템플릿
public class template {

    void solution(List<List<Integer>>graph) {
        boolean[] visited = new boolean[graph.size()];
        bfs(0, graph, visited);
    }


    void bfs(int start, List<List<Integer>> graph, boolean[] visited) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for (int next : graph.get(cur)) {
                if(!visited[next]){
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
    }
}
