package 기본문제.응급차최단거리;

import java.util.ArrayDeque;
import java.util.Queue;

public class 응급차최단거리bfs {
    int n;
    int m;
    int[] dr = {-1, 1,  0, 0, 1,  1, -1, -1};
    int[] dc = { 0, 0, -1, 1, 1, -1,  1, -1};
    public int solution(int[][] city) {
        int shortestDist = -1;
        n = city.length;
        m = city[0].length;
        boolean[][]visited = new boolean[n][m];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0,0,1});
        visited[0][0] = true;

        if(city[0][0] == 1 || city[n-1][m-1] == 1) return -1;

        while(!queue.isEmpty()){
            int[]cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];
            if(r == n-1 && c == m-1){
                shortestDist = d;
                break;
            }
            for(int i=0;i<8;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    if(city[nr][nc] == 0 && !visited[nr][nc]){
                        queue.offer(new int[]{nr,nc,d+1});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return shortestDist;
    }
}
