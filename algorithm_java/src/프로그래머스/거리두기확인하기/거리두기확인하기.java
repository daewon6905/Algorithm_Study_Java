package 프로그래머스.거리두기확인하기;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class 거리두기확인하기 {
    int n,m;
    int[]dr = new int[]{0,1,0,-1};
    int[]dc = new int[]{1,0,-1,0};
    public int[] solution(String[][] places) {
        n = places.length;
        m = places[0].length;
        int[]answer = new int[n];

        for(int i=0;i<n;i++){
            char[][]board = new char[n][m];
            for(int j=0;j<m;j++){
                board[j] = Arrays.copyOf(places[i][j].toCharArray(),5);
            }
            answer[i] = check(board);
        }
        return answer;
    }

    boolean bfs(int r, int c, boolean[][]visited, char[][]board){
        Queue<int[]> queue = new ArrayDeque<>();
        visited[r][c] = true;
        queue.offer(new int[]{r,c,0});

        while(!queue.isEmpty()){
            int[]cur = queue.poll();
            int cr = cur[0];
            int cc = cur[1];
            int d = cur[2];
            for(int i=0;i<4;i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                int nd = d+1;
                if(nr>=0 && nr<n && nc>=0 && nc<m){
                    if(!visited[nr][nc] && board[nr][nc] != 'X'){
                        if(nd>2) continue;
                        if(board[nr][nc] == 'P') return false;
                        queue.offer(new int[]{nr,nc,nd});
                        visited[nr][nc] = true;
                    }
                }
            }
        }
        return true;
    }

    int check(char[][]board){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 'P'){
                    boolean[][]visited = new boolean[n][m];
                    if(!bfs(i,j,visited,board)) return 0;
                }
            }
        }
        return 1;
    }
}
