package 기본개념들.tree.bfs;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

//일방향 인접 리스트
public class bfs1 {

    void solution(List<List<Integer>>tree){
        bfs(0,tree);
    }

    //visited가 필요 없는 이유는 트리 특성상 사이클이 없으며, 일방향이기에 방문한곳을 다시 방문하지 않는것이 보장되기 때문.
    void bfs(int start, List<List<Integer>> tree) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int nxt : tree.get(cur)) {
                queue.offer(nxt);
            }
        }
    }
}
