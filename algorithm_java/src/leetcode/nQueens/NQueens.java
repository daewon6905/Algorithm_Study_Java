package leetcode.nQueens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][]board = new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(board[i], '.');
        }
        List<List<String>>answer = new ArrayList<>();
        backtrack(n,0,answer,board);
        return answer;
    }

    //아래는 볼 필요가 x 미래의 상태이기 때문
    boolean isValid(int r, int c, char[][]board){
        int n = board.length;
        //아래
        for(int i=0;i<r;i++){
            if(board[i][c] == 'Q') return false;
        }
        //오른쪽 위
        for(int i=r-1,j=c+1; i>=0 && j<n; i--,j++){
            if(board[i][j] == 'Q') return false;
        }
        //왼쪽 위
        for(int i=r-1,j=c-1; i>=0 && j>=0; i--,j--){
            if(board[i][j] == 'Q') return false;
        }
        return true;
    }
    void backtrack(int n, int r, List<List<String>>answer, char[][]board){
        if(r == n){
            List<String>tmp = new ArrayList<>();
            for(char[]arr : board){
                tmp.add(new String(arr));
            }
            answer.add(tmp);
        }

        for(int i=0;i<n;i++){
            if(isValid(r,i,board)){
                board[r][i] = 'Q';
                backtrack(n,r+1,answer,board);
                board[r][i] = '.';
            }
        }
    }
}
