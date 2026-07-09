package 프로그래머스.보물지도;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 보물지도 {
    int[]dr= new int[]{0,1,0,-1};
    int[]dc= new int[]{1,0,-1,0};
    public int solution(int n, int m, int[][] hole) {
        char[][]board = new char[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        for(int[]h : hole){
            board[h[0]-1][h[1]-1] = 'x';
        }
        boolean[][][]visited = new boolean[n][m][2];
        Queue<int[]> queue = new ArrayDeque<>();
        visited[0][0][0] = true;
        queue.offer(new int[]{0,0,0,0});
        while(!queue.isEmpty()){
            int[]cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];
            int used = cur[3];
            if(r == n-1 && c == m-1) return dist;
            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr>=0&&nr<n&&nc>=0&&nc<m){
                    if(!visited[nr][nc][used] && board[nr][nc]!='x'){
                        visited[nr][nc][used] = true;
                        queue.offer(new int[]{nr,nc,dist+1,used});
                    }
                }
            }
            if(used == 0){
                if(r == n-1 && c == m-1) return dist;
                for(int i=0;i<4;i++){
                    int nr = r + 2*dr[i];
                    int nc = c + 2*dc[i];
                    if(nr>=0&&nr<n&&nc>=0&&nc<m){
                        if(!visited[nr][nc][1] && board[nr][nc]!='x'){
                            visited[nr][nc][1] = true;
                            queue.offer(new int[]{nr,nc,dist+1,1});
                        }
                    }
                }
            }
        }
        return -1;
    }
}
