package 백준.그래프.단지번호붙이기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 단지번호붙이기 {
    static StringBuilder sb = new StringBuilder();
    static int[][] graph;
    static int[]dr = new int[]{0,1,0,-1};
    static int[]dc = new int[]{1,0,-1,0};
    static int n;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> answerList = new ArrayList<>();
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }
        boolean[][]visited = new boolean[n][n];
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (!visited[r][c] && graph[r][c] == 1) {
                    dfs(r,c,visited);
                    answerList.add(count);
                    count = 0;
                }
            }
        }
        Collections.sort(answerList);
        sb.append(answerList.size()).append("\n");
        for (int count : answerList) {
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int r, int c, boolean[][] visited) {
        visited[r][c] = true;
        count++;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                if (!visited[nr][nc] && graph[nr][nc] == 1) {
                    dfs(nr,nc,visited);
                }
            }
        }
    }
}
