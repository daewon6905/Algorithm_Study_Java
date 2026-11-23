package 백준.미로탐색;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 미로탐색 {
    static int[]dr = new int[]{0,1,0,-1};
    static int[]dc = new int[]{1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = line.charAt(j) - '0';
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            int cd = cur[2];
            if(cr == n-1 && cc == m-1){
                System.out.println(cd);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (!visited[nr][nc] && graph[nr][nc] != 0) {
                        queue.offer(new int[]{nr, nc, cd + 1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }

    }
}
