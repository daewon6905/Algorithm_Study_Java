package tree.bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

//N-ary 트리 클래스 구현
class Node2{
    int value;
    List<Node2>children;

    public Node2(int value){
        this.value = value;
        this.children = new ArrayList<>();
    }
}
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
