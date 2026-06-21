package 기본개념들.tree.bfs;

import 기본개념들.tree.Node2;

import java.util.ArrayDeque;
import java.util.Queue;

public class bfs4 {
    void solution(Node2 root) {
        bfs(root);
    }

    void bfs(Node2 root) {
        Queue<Node2> queue = new ArrayDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node2 cur = queue.poll();
            for (Node2 child : cur.children) {
                queue.offer(child);
            }
        }
    }
}
