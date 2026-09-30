package 공부하다알게된알고리즘.TreeDP;

import java.util.ArrayList;
import java.util.List;


//기본 템플릿 코드
public class TreeDP {
    static List<List<Integer>> tree;
    static int[][] dp;

    public static void main(String[] args) {
        int n = 8; // 노드 개수
        tree = new ArrayList<>();
        dp = new int[n + 1][2];

        for (int i = 0; i <= n; i++) tree.add(new ArrayList<>());

        // 간선 연결 예시 (양방향)
        // addEdge(1, 2); ...

        // 1번 노드를 임의의 루트로 설정하고 DFS 탐색 (부모 노드는 0)
        dfs(1, 0);

        // 결과 계산 (1번 루트 노드의 켜짐/꺼짐 상태 중 최솟값)
        int result = Math.min(dp[1][0], dp[1][1]);
    }

    static void dfs(int u, int parent) {
        // 기본값 설정 (u를 선택할 때 자기 자신 포함 1)
        dp[u][1] = 1;

        for (int child : tree.get(u)) {
            if (child == parent) continue; // 부모 노드로 역방향 탐색 방지

            dfs(child, u); // 1. 자식 노드 DP 먼저 계산 (Bottom-Up)

            // 2. 점화식을 통한 부모 노드 DP 갱신
            dp[u][0] += dp[child][1];
            dp[u][1] += Math.min(dp[child][0], dp[child][1]);
        }
    }
}
