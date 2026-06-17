package tree.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

//이진 트리 클래스 구현
class Node{
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}
public class bfs3 {
    void solution(Node root) {
        bfs(root);
    }

    void bfs(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(root);

        //for문을 돌 필요 없이 노드 클래스의 left right이 존재한다면 넣어주면 됨.
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.left != null) queue.offer(cur.left);
            if(cur.right != null) queue.offer(cur.right);
        }
    }
}
