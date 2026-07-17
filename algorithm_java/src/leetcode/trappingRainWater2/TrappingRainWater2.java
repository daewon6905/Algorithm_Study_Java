package leetcode.trappingRainWater2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

public class TrappingRainWater2 {
    int[]dr = {-1,0,1,0};
    int[]dc = {0,-1,0,1};
    public int trapRainWater(int[][] heightMap) {
        int n = heightMap.length;
        int m = heightMap[0].length;
        boolean[][]visited = new boolean[n][m];
        int answer = 0;
        Queue<int[]> pq = new PriorityQueue<>((x, y)->x[2]-y[2]);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    visited[i][j] = true;
                    pq.offer(new int[]{i,j,heightMap[i][j]});
                }
            }
        }
        while(!pq.isEmpty()){
            int[]cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int h = cur[2];
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc]){
                    int nh = heightMap[nr][nc];
                    if(h > nh){
                        answer += h - nh;
                        visited[nr][nc] = true;
                        pq.offer(new int[]{nr,nc,h});
                    }else{
                        visited[nr][nc] = true;
                        pq.offer(new int[]{nr,nc,nh});
                    }

                }
            }
        }
        return answer;

    }
}
