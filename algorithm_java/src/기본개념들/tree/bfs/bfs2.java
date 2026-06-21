package 기본개념들.tree.bfs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;
//양방향 인접리스트
public class bfs2 {
    void solution(List<List<Integer>> tree) {
        boolean[] visited = new boolean[tree.size()];
        bfs(0,tree,visited);
    }

    //양방향 인접리스트는 visited가 필요.
    void bfs(int start, List<List<Integer>>tree, boolean[]visited){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : tree.get(cur)) {
                if(!visited[nxt]){
                    queue.offer(nxt);
                    visited[nxt] = true;
                }
            }
        }
    }
}
