package 기본개념들.tree.dfs;

import java.util.List;

//양방향, visited 필요
public class dfs2 {
    void solution(List<List<Integer>> tree) {
        boolean[] visited = new boolean[tree.size()];
        dfs(0, tree,visited);
    }

    void dfs(int cur, List<List<Integer>> tree,boolean[]visited) {
        visited[cur] = true;
        for (int child : tree.get(cur)){
            if(!visited[child]){
                dfs(child, tree, visited);
            }
        }

    }
}
