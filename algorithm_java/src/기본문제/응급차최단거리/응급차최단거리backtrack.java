package 기본문제.응급차최단거리;

public class 응급차최단거리backtrack {
    int n;
    int m;
    int[] dr = {-1, 1,  0, 0, 1,  1, -1, -1};
    int[] dc = { 0, 0, -1, 1, 1, -1,  1, -1};
    int shortestDist = Integer.MAX_VALUE;
    public int solution(int[][] city) {
        n = city.length;
        m = city[0].length;
        boolean[][]visited = new boolean[n][m];
        if(city[0][0] == 1 || city[n-1][m-1] == 1) return -1;
        visited[0][0] = true;
        backtrack(0,0,1,city,visited);
        return shortestDist == Integer.MAX_VALUE ? -1 : shortestDist;
    }

    void backtrack(int r,int c,int d,int[][]city, boolean[][]visited){
        if(r == n-1 && c == m-1){
            shortestDist = Math.min(shortestDist,d);
            return;
        }
        for(int i=0;i<8;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && city[nr][nc] == 0){
                if(!visited[nr][nc]){
                    visited[nr][nc] = true;
                    backtrack(nr, nc, d+1, city, visited);
                    visited[nr][nc] = false;
                }
            }
        }
    }
}
