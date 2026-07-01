package leetcode.sudokuSolver;

public class SudokuSolver {
        int n;
        int m;
        public void solveSudoku(char[][] board) {
            n = board.length;
            m = board[0].length;
            backtrack(0,board);
        }

        boolean isValid(int r, int c,int num, char[][]board){
            for(int i=0;i<n;i++){
                if(board[r][i] == num) return false;
                if(board[i][c] == num) return false;

                int nr = 3* r/3 + i/3;
                int nc = 3* c/3 + i%3;
                if(board[nr][nc] == num + '0') return false;
            }
            return true;
        }

        boolean backtrack(int idx,char[][]board){
            if(idx == n*m){
                return true;
            }
            int r = (idx/n);
            int c = idx%m;
            if(board[r][c] != '.'){
                return backtrack(idx+1,board);
            }

            for(int i=1;i<=n;i++){
                if(isValid(r,c,i,board)){
                    board[r][c] = (char)(i + '0');
                    if(backtrack(idx+1,board)) return true;
                    board[r][c] = '.';
                }
            }
            return false;
        }
}

