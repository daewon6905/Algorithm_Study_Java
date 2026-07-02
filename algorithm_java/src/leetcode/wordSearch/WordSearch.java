package leetcode.wordSearch;

public class WordSearch {
    int[]dr = new int[]{0,1,0,-1};
    int[]dc = new int[]{1,0,-1,0};
    int n;
    int m;
    public boolean exist(char[][] board, String word) {
        n = board.length;
        m = board[0].length;
        boolean[][]visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if(backtrack(1,i,j,visited,word,board)) return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    boolean backtrack(int idx, int r, int c, boolean[][]visited, String word, char[][]board){
        if(idx == word.length()){
            return true;
        }
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && !visited[nr][nc]){
                if(board[nr][nc] == word.charAt(idx)){
                    visited[nr][nc] = true;
                    if(backtrack(idx+1,nr,nc,visited,word,board)) return true;
                    visited[nr][nc] = false;
                }
            }
        }
        return false;
    }
}
