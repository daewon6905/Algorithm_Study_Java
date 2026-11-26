package 백준.그래프.유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 유기농배추 {
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[][] land = new int[n][m];
            boolean[][] visited = new boolean[n][m];
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                land[r][c] = 1;
            }
            int count = 0;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if (!visited[r][c] && land[r][c] == 1) {
                        dfs(r, c, land, visited);
                        count++;
                    }
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int r, int c, int[][] land, boolean[][] visited) {
        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < land.length && nc >= 0 && nc < land[0].length) {
                if (!visited[nr][nc] && land[nr][nc] == 1) {
                    dfs(nr, nc, land, visited);
                }
            }
        }
    }
}
