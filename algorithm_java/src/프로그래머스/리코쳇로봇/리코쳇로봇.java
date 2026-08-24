package 프로그래머스.리코쳇로봇;

import java.util.ArrayDeque;
import java.util.Queue;

public class 리코쳇로봇 {
    int[]dr = new int[]{0,1,0,-1};
    int[]dc = new int[]{1,0,-1,0};
    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        boolean[][]visited = new boolean[n][m];
        char[][]boardC = new char[n][m];
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            boardC[i] = board[i].toCharArray();
            for(int j=0;j<m;j++){
                if(boardC[i][j] == 'R'){
                    queue.offer(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        while(!queue.isEmpty()){
            int[]cur = queue.poll();
            int r = cur[0];
            int c = cur[1];
            int count = cur[2];
            if(boardC[r][c] == 'G') return count;
            for(int i=0;i<4;i++){
                int nr = r;
                int nc = c;
                while(nr+dr[i]>=0&&nr+dr[i]<n&&nc+dc[i]>=0&&nc+dc[i]<m&&boardC[nr+dr[i]][nc+dc[i]]!='D'){
                    nr+=dr[i];
                    nc+=dc[i];
                }
                if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    queue.offer(new int[]{nr,nc,count+1});
                }
            }
        }
        return -1;
    }
}
