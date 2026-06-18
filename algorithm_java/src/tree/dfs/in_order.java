package tree.dfs;

import tree.Node;

//중위순회
public class in_order {
    void solution(Node root){
        dfs(root);
    }

    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left); //왼쪽 노드 dfs 실행
        System.out.println(cur); //방문 처리
        dfs(cur.right); //오른쪽 노드 dfs 실행
    }
}
