package PCCP기출문제.기출2번석유시추;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class 석유시추 {
    int[]dr = new int[]{0,0,1,-1};
    int[]dc = new int[]{1,-1,0,0};
    int n;
    int m;
    int[]oilByCol;
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        oilByCol = new int[m];
        boolean[][]visited = new boolean[n][m];
        for(int c=0;c<m;c++){
            for(int r=0;r<n;r++){
                if(land[r][c] == 1 && !visited[r][c]){
                    bfs(r,c,land,visited);
                }
            }
        }
        for(int oilSum : oilByCol){
            answer = Math.max(answer, oilSum);
        }
        return answer;
    }
    public void bfs(int sr,int sc, int[][] land, boolean[][]visited){
        Set<Integer> set = new HashSet<>();
        visited[sr][sc] = true;
        set.add(sc);
        int oilCount = 0;
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{sr,sc});
        while(!queue.isEmpty()){
            int[]cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            oilCount++;
            set.add(c);
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if((nr>=0 && nr<n && nc>=0 && nc<m) && land[nr][nc] == 1){
                    if(!visited[nr][nc]){
                        visited[nr][nc] = true;
                        queue.offer(new int[]{nr,nc});
                    }
                }
            }
        }
        for(int col : set){
            oilByCol[col] += oilCount;
        }
    }
}
