package 프로그래머스.미로탈출;

import java.util.*;

public class 미로탈출 {
    int[]dr = new int[]{0,1,0,-1};
    int[]dc = new int[]{1,0,-1,0};
    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        char[][]mapsC = new char[n][m];
        boolean[][][]visited = new boolean[n][m][2];
        Queue<int[]>queue = new ArrayDeque<>();
        for(int i=0;i<n;i++){
            mapsC[i] = maps[i].toCharArray();
            for(int j=0;j<m;j++){
                if(maps[i].charAt(j) == 'S'){
                    visited[i][j][0] = true;
                    queue.offer(new int[]{i,j,0,0});
                }
            }
        }
        while(!queue.isEmpty()){
            int[]cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];
            int pulled = cur[3];
            if(mapsC[r][c] == 'E' && pulled == 1){
                return d;
            }
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m && !visited[nr][nc][pulled]){
                    int nextPulled = mapsC[nr][nc] == 'L' ? 1 : pulled;
                    if(mapsC[nr][nc] != 'X'){
                        visited[nr][nc][nextPulled] = true;
                        queue.offer(new int[]{nr,nc,d+1,nextPulled});
                    }
                }
            }
        }
        return -1;
    }
}
