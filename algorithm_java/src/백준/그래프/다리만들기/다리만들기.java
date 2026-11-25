package 백준.그래프.다리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 다리만들기 {
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{1, 0, -1, 0};
    static int[][] sea;
    static int size;
    static int mark = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        StringTokenizer st;
        List<List<int[]>> islands = new ArrayList<>();
        boolean[][] visited = new boolean[size][size];
        sea = new int[size][size];
        for (int i = 0; i < size; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                sea[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (sea[r][c] == 1 && !visited[r][c]) {
                    List<int[]> coords = new ArrayList<>();
                    mark++;
                    dfs(r,c,visited,coords);
                    islands.add(coords);
                }
            }
        }
        int shortestBridge = Integer.MAX_VALUE;

        for (int i = 0; i < islands.size(); i++) {
            List<int[]> island = islands.get(i);
            Queue<int[]> queue = new ArrayDeque<>();
            visited = new boolean[size][size];
            for (int[] land : island) {
                int sr = land[0];
                int sc = land[1];
                queue.offer(new int[]{sr,sc,0});
            }
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                int d = cur[2];
                if(sea[r][c] > i+1){
                    shortestBridge = Math.min(shortestBridge, d);
                    break;
                }

                for (int j = 0; j < 4; j++) {
                    int nr = r + dr[j];
                    int nc = c + dc[j];
                    if (nr >= 0 && nr < size && nc >= 0 && nc < size) {
                        if (!visited[nr][nc] && sea[nr][nc] != i+1){
                            visited[nr][nc] = true;
                            queue.offer(new int[]{nr, nc, d + 1});
                        }
                    }
                }
            }
        }
        System.out.println(shortestBridge-1);
    }

    static void dfs(int r, int c, boolean[][]visited, List<int[]>coords) {
        visited[r][c] = true;
        sea[r][c] = mark;
        coords.add(new int[]{r, c});
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < size && nc >= 0 && nc < size) {
                if (!visited[nr][nc] && sea[nr][nc] == 1){
                    dfs(nr,nc,visited,coords);
                }
            }
        }
    }
}
