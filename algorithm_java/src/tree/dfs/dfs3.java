package tree.dfs;

import tree.Node;

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
