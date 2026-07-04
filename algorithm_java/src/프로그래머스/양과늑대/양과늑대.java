package 프로그래머스.양과늑대;

public class 양과늑대 {
    int maxSheep = 0;
    int n;
    public int solution(int[] info, int[][] edges) {
        n = info.length;
        boolean[]visited = new boolean[n];
        visited[0] = true;
        dfs(0,1,visited,info,edges);
        return maxSheep;
    }
    void dfs(int wolf, int sheep, boolean[]visited, int[]info, int[][]edges){
        maxSheep = Math.max(maxSheep,sheep);
        if(wolf>=sheep) return;
        for(int i=0;i<edges.length;i++){
            int[]cur = edges[i];
            if(visited[cur[0]] && !visited[cur[1]]){
                visited[cur[1]] = true;
                if(info[cur[1]] == 0){
                    dfs(wolf,sheep+1,visited,info,edges);
                }else{
                    dfs(wolf+1,sheep,visited,info,edges);
                }
                visited[cur[1]] = false;
            }
        }
    }
}
