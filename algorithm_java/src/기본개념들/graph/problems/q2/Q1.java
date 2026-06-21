package 기본개념들.graph.problems.q2;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Q1 {
    public int solution(int[] coins, int amount) {
        Set<Integer> visited = new HashSet<>();
        if (amount == 0) return 0;
        return bfs(coins, amount, visited);
    }

    int bfs(int[] coins, int amount, Set<Integer> visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{amount, 0});
        visited.add(amount);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int leftover = cur[0];
            int count = cur[1];
            for (int coin : coins) {
                if (leftover - coin == 0) {
                    return count + 1;
                }
                if (leftover - coin > 0 && !visited.contains(leftover - coin)) {
                    queue.offer(new int[]{leftover - coin, count + 1});
                    visited.add(leftover - coin);
                }
            }
        }
        return -1;
    }
}
