package 프로그래머스.미로탈출;

import java.util.*;

public class 미로탈출2 {
    int[]dr = new int[]{0,1,0,-1};
    int[]dc = new int[]{1,0,-1,0};
    int n;
    int m;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        char[][]mapsC = new char[n][m];
        int sr = 0;
        int sc = 0;
        int lr = 0;
        int lc = 0;
        for(int i=0;i<n;i++){
            mapsC[i] = maps[i].toCharArray();
            for(int j=0;j<m;j++){
                if(maps[i].charAt(j) == 'S'){
                    sr = i;
                    sc = j;
                }
                if(maps[i].charAt(j) == 'L'){
                    lr = i;
                    lc = j;
                }
            }
        }
        int leastToLever = bfs(sr,sc,mapsC,'L');
        int leverToExit = bfs(lr,lc,mapsC,'E');

        return (leastToLever == -1 || leverToExit == -1) ? -1 : leastToLever + leverToExit;
    }
    public int bfs(int sr, int sc, char[][]mapsC, char target){
        boolean[][]visited = new boolean[n][m];
        Queue<int[]>queue = new ArrayDeque<>();
        queue.offer(new int[]{sr,sc,0});
        visited[sr][sc] = true;
        while(!queue.isEmpty()){
            int[]cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int d = cur[2];
            if(mapsC[r][c] == target){
                return d;
            }
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m && !visited[nr][nc]){
                    if(mapsC[nr][nc] != 'X'){
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr,nc,d+1});
                    }
                }
            }
        }
        return -1;
    }
}
