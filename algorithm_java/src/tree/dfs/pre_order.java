package tree.dfs;

import java.util.List;

//전위순회
public class pre_order {
    void solution(List<List<Integer>> tree) {
        dfs(0, tree);
    }

    void dfs(int cur, List<List<Integer>> tree) {
        System.out.println(cur); // 방문처리를 자식을 돌기 전에 함.
        for (int child : tree.get(cur)){
            dfs(child,tree);
        }

    }
}
