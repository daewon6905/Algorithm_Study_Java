package 프로그래머스.가장먼노드;

import java.util.*;

public class 가장먼노드2 {
    public int solution(int n, int[][] vertex) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : vertex) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph.get(current)) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.offer(next);
                }
            }
        }

        int maxDistance = 0;
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (distance[i] > maxDistance) {
                maxDistance = distance[i];
                answer = 1;
            } else if (distance[i] == maxDistance) {
                answer++;
            }
        }

        return answer;
    }
}
