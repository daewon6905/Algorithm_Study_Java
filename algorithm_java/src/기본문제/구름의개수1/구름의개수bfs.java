package 기본문제.구름의개수1;

import java.util.ArrayDeque;
import java.util.Queue;

public class 구름의개수bfs {
    int[]dr = new int[]{0,1,-1,0};
    int[]dc = new int[]{1,0,0,-1};
    int m;
    int n;
    public int solution(int[][]sky){
        n = sky.length;
        m = sky[0].length;
        boolean[][]visited = new boolean[n][m];
        int answer =0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sky[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, sky, visited);
                    answer++;
                }
            }
        }
        return answer;
    }

    void bfs(int sr, int sc, int[][] sky, boolean[][] visited) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (!visited[nr][nc] && sky[nr][nc] == 1) {
                        queue.offer(new int[]{nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
    }
}
