package graph.problems.q1;

import java.util.Arrays;
//dfs 사용 풀이
public class Q1 {
    public boolean solution(int[][] friends) {
        int n = friends.length;
        int[]color = new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i] == -1){
                color[i] = 0;
                if(!dfs(i,friends,color)) return false;
            }
        }
        return true;
    }

    boolean dfs(int cur, int[][]friends, int[]color){

        for(int next : friends[cur]){
            if(color[next] == color[cur]){
                return false;
            }
            if(color[next] == -1){
                color[next] = 1 - color[cur];
                if(!dfs(next,friends,color)){
                    return false;
                }
            }
        }
        return true;
    }
}
