package topologicalsort;

import java.util.*;


//위상 정렬 예시. 코테에 자주 나오는 주제는 x
public class TopoLogicalSortEx {

    public int[] topoLogicalSort(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[n];
        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
            indegree[to]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        int[] order = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                visited[i] = true;
                order[count] = i;
                count++;
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (graph.containsKey(cur)) {
                for (int next : graph.get(cur)) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        queue.offer(next);
                        visited[next] = true;
                        order[count] = next;
                        count++;
                    }
                }
            }
        }
        return order;
    }
    public static void main(String[] args) {
        TopoLogicalSortEx sorter = new TopoLogicalSortEx();
        // 노드 개수: 5개 (0번 ~ 4번)
        int n = 5;

        // 간선 정보: [출발, 도착]
        // 0 -> 1, 0 -> 2, 1 -> 3, 2 -> 3, 3 -> 4
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 3},
                {3, 4}
        };
        System.out.println("--- 위상 정렬 테스트 시작 ---");
        int[] result = sorter.topoLogicalSort(n, edges);

        if (result.length == 0) {
            System.out.println("그래프에 사이클이 존재하여 정렬할 수 없습니다.");
        } else {
            System.out.print("정렬 결과: ");
            for (int node : result) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }
}
