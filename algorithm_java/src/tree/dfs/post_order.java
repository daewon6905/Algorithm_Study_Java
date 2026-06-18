package tree.dfs;

import java.util.List;

//후위순회
public class post_order {
    void solution(List<List<Integer>> tree) {
        dfs(0, tree);
    }

    void dfs(int cur, List<List<Integer>> tree) {
        for (int child : tree.get(cur)){
            dfs(child,tree);
        }
        System.out.println(cur); //방문 처리

    }
}
