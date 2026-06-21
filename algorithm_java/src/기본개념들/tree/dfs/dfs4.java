package 기본개념들.tree.dfs;

import 기본개념들.tree.Node2;

public class dfs4 {
    void solution(Node2 root){
        dfs(root);
    }

    void dfs(Node2 cur) {
        if (cur == null) return;

        for (Node2 child : cur.children) {
            dfs(child);
        }
    }
}
