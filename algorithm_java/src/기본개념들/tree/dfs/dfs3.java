package 기본개념들.tree.dfs;

import 기본개념들.tree.Node;

public class dfs3 {
    void solution(Node root) {
        dfs(root);
    }

    void dfs(Node cur){
//        if(cur != null) return;
//        dfs(cur.left);
//        dfs(cur.right);
        if(cur.left != null) dfs(cur.left);
        if(cur.right != null) dfs(cur.right);
    }
}
