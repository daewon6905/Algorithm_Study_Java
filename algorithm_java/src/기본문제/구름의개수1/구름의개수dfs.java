package 기본문제.구름의개수1;

public class 구름의개수dfs {
    int[]dr = new int[]{0,1,-1,0};
    int[]dc = new int[]{1,0,0,-1};
    int m;
    int n;
    public int solution(int[][] sky) {
        m = sky.length;
        n = sky[0].length;
        int answer = 0;
        boolean[][]visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(sky[i][j] == 1 && !visited[i][j]){
                    dfs(i,j,sky,visited);
                    answer++;
                }
            }
        }
        return answer;
    }

    void dfs(int r, int c, int[][]sky, boolean[][]visited){
        visited[r][c] = true;
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && sky[nr][nc] == 1){
                if(!visited[nr][nc]){
                    dfs(nr,nc,sky,visited);
                }
            }
        }
    }
}
