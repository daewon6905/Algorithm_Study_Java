package leetcode.mineSweeper;

public class MineSweeper {
    int[]dr = new int[]{0,1,0,-1,1,1,-1,-1};
    int[]dc = new int[]{1,0,-1,0,1,-1,1,-1};
    int n,m;
    public char[][] updateBoard(char[][] board, int[] click) {
        n = board.length;
        m = board[0].length;
        int r = click[0];
        int c = click[1];

        if(board[r][c] == 'M'){
            board[r][c] = 'X';
            return board;
        }
        dfs(r,c,board);
        return board;
    }

    void dfs(int r,int c,char[][]board){
        if(board[r][c] != 'E'){
            return;
        }
        int count = 0;

        for(int i=0;i<8;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0&&nr<n&&nc>=0&&nc<m){
                if(board[nr][nc] == 'M'){
                    count++;
                }
            }
        }
        if(count>0){
            board[r][c] = (char)(count + '0');
            return;
        }
        board[r][c] = 'B';
        for(int i=0;i<8;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0&&nr<n&&nc>=0&&nc<m){
                if(board[nr][nc] == 'E'){
                    dfs(nr,nc,board);
                }
            }
        }
    }
}
