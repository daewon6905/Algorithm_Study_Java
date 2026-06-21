package 기본개념들.graph.implicit_graph;

public class dfs {
    int n;
    int m;
    int[]dr = new int[]{1,0,-1,0};
    int[]dc = new int[]{0,1,0,-1};

    void solution(int[][]grid){
        n = grid.length;
        m = grid[0].length;
        boolean[][]visited = new boolean[n][m];
        dfs(0,0,visited,grid);
    }

    void dfs(int r, int c, boolean[][]visited, int[][]grid){
        visited[r][c] = true;
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m){
                if(grid[nr][nc] == 1){
                    if(!visited[nr][nc]){
                        dfs(nr,nc,visited,grid);
                    }
                }
            }
        }
    }
}
