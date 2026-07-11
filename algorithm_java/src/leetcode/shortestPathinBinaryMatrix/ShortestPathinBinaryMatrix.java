package leetcode.shortestPathinBinaryMatrix;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
    int[]dr = new int[]{0,1,0,-1,1,-1,1,-1};
    int[]dc = new int[]{1,0,-1,0,1,1,-1,-1};
    int n,m;
    public int shortestPathBinaryMatrix(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;
        boolean[][]visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;
        while(!queue.isEmpty()){
            int[]cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];
            if(r == n-1 && c == m-1) return d;
            for(int i=0;i<8;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                int nd = d + 1;

                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    if(!visited[nr][nc] && grid[nr][nc] != 1){
                        queue.offer(new int[]{nr,nc,nd});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return -1;
    }
}
