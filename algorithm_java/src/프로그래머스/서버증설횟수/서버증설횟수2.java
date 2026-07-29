package 프로그래머스.서버증설횟수;

import java.util.ArrayDeque;
import java.util.Queue;

//큐를 활용한 풀이 O(n)
public class 서버증설횟수2 {
    public int solution(int[] players, int m, int k) {
        int count = 0;
        int activeServers = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < players.length; i++) {
            while (!queue.isEmpty() && queue.peek()[0] <= i) {
                activeServers -= queue.poll()[1];
            }
            int neededServer = players[i] / m;
            if (neededServer > activeServers) {
                int add = neededServer - activeServers;
                count += add;
                activeServers += add;
                queue.offer(new int[]{i + k, add});
            }
        }
        return count;
    }
}