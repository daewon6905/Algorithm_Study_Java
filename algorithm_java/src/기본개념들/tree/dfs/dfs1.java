package 기본개념들.tree.dfs;

import java.util.List;

//일방향
public class dfs1 {
    void solution(List<List<Integer>> tree) {
        dfs(0, tree);
    }

    void dfs(int cur, List<List<Integer>> tree) {
        //여기서 재귀 호출 전 후로 어떤 작업을 하냐에 따라 전위, 후위 순회로 나뉨.
        for (int child : tree.get(cur)){
            dfs(child,tree);
        }

    }
}
