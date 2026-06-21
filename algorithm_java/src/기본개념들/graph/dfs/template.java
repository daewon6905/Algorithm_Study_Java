package 기본개념들.graph.dfs;

import java.util.List;

//재귀호출 사용 dfs 템플릿
public class template {

    void solution(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        dfs(0,graph,visited);
    }

    void dfs(int cur, List<List<Integer>> graph, boolean[] visited) {
        visited[cur] = true;

        for (int next : graph.get(cur)) {
            if (!visited[next]) {
                dfs(next,graph,visited);
            }
        }
    }
}
