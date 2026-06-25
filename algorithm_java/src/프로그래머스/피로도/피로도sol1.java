package 프로그래머스.피로도;

public class 피로도sol1 {
    int maxDungeons = 0;
    int n;
    public int solution(int k, int[][] dungeons) {
        n = dungeons.length;
        boolean[]visited = new boolean[n];
        count(0,k,dungeons,visited);
        return maxDungeons;
    }

    void count(int count, int k, int[][]dungeons, boolean[]visited){
        maxDungeons = Math.max(maxDungeons,count);
        for(int i=0;i<n;i++){
            if(!visited[i]){
                if(k >= dungeons[i][0]){
                    visited[i] = true;
                    count(count+1,k-dungeons[i][1],dungeons,visited);
                    visited[i] = false;
                }
            }
        }
    }
}
