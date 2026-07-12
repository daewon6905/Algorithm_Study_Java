package leetcode.numberOfIslands;

public class NumberOfIslands {
    int n,m;
    int[]dr = new int[]{0,1,0,-1};
    int[]dc = new int[]{1,0,-1,0};
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;
        boolean[][]visited = new boolean[n][m];
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(grid[r][c]=='1' && !visited[r][c]){
                    visited[r][c] = true;
                    dfs(r,c,visited,grid);
                    count++;
                }
            }
        }
        return count;
    }

    void dfs(int r, int c, boolean[][]visited, char[][]grid){
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m){
                if(!visited[nr][nc] && grid[nr][nc] == '1'){
                    visited[nr][nc] = true;
                    dfs(nr,nc,visited,grid);
                }
            }
        }
    }
}
