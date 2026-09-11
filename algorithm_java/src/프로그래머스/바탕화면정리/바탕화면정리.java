package 프로그래머스.바탕화면정리;

import java.util.ArrayDeque;
import java.util.Queue;

public class 바탕화면정리 {
    int[] dr = {0, 1, 1, 1, 0, -1, -1, -1};
    int[] dc = {1, 1, 0, -1, -1, -1, 0, 1};
    int n;
    int m;
    int globalminR = Integer.MAX_VALUE;
    int globalminC = Integer.MAX_VALUE;
    int globalmaxR = -1;
    int globalmaxC = -1;
    //시작점: 네트워크들의 r,c 중에 두값 모두 최솟값 끝점: 네트워크들의 r,c 중에 두값 모두 최대?
    public int[] solution(String[] wallpaper) {
        n = wallpaper.length;
        m = wallpaper[0].length();
        boolean[][]visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visited[i][j] && wallpaper[i].charAt(j) == '#'){
                    bfs(i,j,visited,wallpaper);
                }
            }
        }
        return new int[]{globalminR,globalminC,globalmaxR+1,globalmaxC+1};
    }
    public void bfs(int sr, int sc, boolean[][]visited, String[] wallpaper){
        int minR = sr;
        int minC = sc;
        int maxR = sr;
        int maxC = sc;
        Queue<int[]>queue = new ArrayDeque<>();
        visited[sr][sc] = true;
        queue.offer(new int[]{sr,sc});
        while(!queue.isEmpty()){
            int[]cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            for(int i=0;i<8;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m&&wallpaper[nr].charAt(nc)!='.'){
                    if(!visited[nr][nc]){
                        visited[nr][nc] = true;
                        minR = Math.min(minR, nr);
                        minC = Math.min(minC, nc);
                        maxR = Math.max(maxR, nr);
                        maxC = Math.max(maxC, nc);
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        globalminR = Math.min(minR, globalminR);
        globalminC = Math.min(minC, globalminC);
        globalmaxR = Math.max(maxR, globalmaxR);
        globalmaxC = Math.max(maxC, globalmaxC);
    }
}
