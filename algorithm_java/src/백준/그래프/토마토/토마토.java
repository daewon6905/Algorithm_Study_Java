package 백준.그래프.토마토;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 토마토 {
    static int[][] graph;
    static int[]dr = new int[]{0,1,0,-1};
    static int[]dc = new int[]{1,0,-1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[m][n];
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if(cur == 1){
                    queue.offer(new int[]{i,j});
                }
                graph[i][j] = cur;
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    if (graph[nr][nc] == 0) {
                        graph[nr][nc] = graph[r][c] + 1;
                        queue.offer(new int[]{nr, nc});
                    }
                }
            }
        }
        int days = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                days = Math.max(days, graph[i][j]);
            }
        }
        System.out.println(days-1);
    }
}
