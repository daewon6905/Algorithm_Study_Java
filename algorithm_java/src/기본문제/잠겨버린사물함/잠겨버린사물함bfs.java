package 기본문제.잠겨버린사물함;

import java.util.ArrayDeque;
import java.util.Queue;

public class 잠겨버린사물함bfs {

    public int solution(int[][] lockers) {
        int n = lockers.length;
        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if(!visited[cur]){
                for (int nxt : lockers[cur]) {
                    queue.offer(nxt);
                    visited[nxt] = true;
                }
            }
        }
        int count = 0;
        for (boolean bool : visited) {
            if(!bool) count++;
        }
        return count;
    }
}
