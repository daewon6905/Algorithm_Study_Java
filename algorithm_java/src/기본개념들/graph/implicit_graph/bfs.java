package 기본개념들.graph.implicit_graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class bfs {
    int[]dr = new int[]{1,0,-1,0};
    int[]dc = new int[]{0,1,0,-1};
    void solution(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][]visited= new boolean[n][m];
        bfs(0, 0, visited, grid);
    }

    void bfs(int sr, int sc, boolean[][]visited, int[][]grid){
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                /*암시적 그래프가 다른점은 큐에서 값을 꺼내면 노드가 나오는게 아니라,
                  예를 들어 그리드 값이 0이면 벽, 1이면 길 이런식으로 조건 만족을 직접 확인해서
                  다음 노드를 결정해야함.
                 */
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                        if(grid[nr][nc] == 1){
                            if(!visited[nr][nc]) {
                                queue.offer(new int[]{nr, nc});
                                visited[nr][nc] = true;
                            }
                        }
                    }
                }
            }
        }
    }
