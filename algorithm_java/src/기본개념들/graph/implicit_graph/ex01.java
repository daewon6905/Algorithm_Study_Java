package 기본개념들.graph.implicit_graph;

public class ex01 {
    int n;
    int m;
    int count;
    int[]dr = new int[]{1,0,-1,0};
    int[]dc = new int[]{0,1,0,-1};
    public int solution(int[][] sky) {
        n = sky.length;
        m = sky[0].length;
        count = 0;
        boolean[][]visited = new boolean[n][m];

        //dfs를 할만한 좌표를 찾아서 연결된 네트워크 개수 카운팅이 가능. dfs 뿐만 아니라 bfs 또한 모든 노드를 방문하는건 동일하니 똑같이 적용가능.
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(sky[i][j] == 1){
                    if(!visited[i][j]){
                        dfs(i,j,visited,sky);
                        count++;
                    }
                }
            }
        }
        return count;
    }

    void dfs(int r, int c, boolean[][]visited, int[][]sky){
        visited[r][c] = true;
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m){
                if(sky[nr][nc] == 1){
                    if(!visited[nr][nc]){
                        dfs(nr,nc,visited,sky);
                    }
                }
            }
        }
    }
}
