package 백준.토마토;

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
        List<int[]> riped = new ArrayList<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if(line.charAt(j) - '0' == 1){
                    riped.add(new int[]{i,j});
                }
                graph[i][j] = line.charAt(j) - '0';
            }
        }
        Queue<int[]> queue = new ArrayDeque<>();
        for (int[] start : riped) {
            queue.offer(new int[]{start[0],start[1],0});
        }
        int minTime = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int t = cur[2];
            minTime = t;
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (graph[nr][nc] == 0) {
                        queue.offer(new int[]{nr, nc, t + 1});
                        graph[nr][nc] = 1;
                    }
                }
            }
        }
        if(!check(n,m)){
            System.out.println(-1);
        }else {
            System.out.println(minTime);
        }
    }

    static boolean check(int n, int m) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (graph[i][j] == 0) return false;
            }
        }
        return true;
    }
}
