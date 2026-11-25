package 백준.그래프.다리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 다리만들기 {
    static int[] dr = new int[]{0, 1, 0, -1};
    static int[] dc = new int[]{1, 0, -1, 0};
    static int[][] sea;
    static int size;
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
                if (sea[i][j] == 1 && !visited[i][j]) {
                    List<int[]> cords = new ArrayList<>();
                    dfs(i, j, visited, cords);
                }
            }
        }


    }

    static void dfs(int r, int c, boolean[][]visited, List<int[]>cords) {
        visited[r][c] = true;
        cords.add(new int[]{r, c});
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr >= 0 && nr < size && nc >= 0 && nc < size) {
                if (!visited[nr][nc] && sea[nr][nc] == 1){
                    dfs(nr,nc,visited,cords);
                }
            }
        }
    }
}
