package 프로그래머스.무인도여행;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 무인도여행 {
    int n;
    int m;
    int[]dr = new int[]{0,1,0,-1};
    int[]dc = new int[]{1,0,-1,0};
    public int[] solution(String[] maps) {
        List<Integer> answerList = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        boolean[][]visited = new boolean[n][m];
        char[][]mapsC = new char[n][m];
        for(int i=0;i<n;i++){
            mapsC[i] = maps[i].toCharArray();
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mapsC[i][j] != 'X' && !visited[i][j]){
                    answerList.add(dfs(i,j,visited,mapsC));
                }
            }
        }
        if(answerList.isEmpty()) answerList.add(-1);
        Collections.sort(answerList);
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    public int dfs(int r, int c, boolean[][]visited, char[][]mapsC){
        int totalSum = mapsC[r][c] - '0';
        visited[r][c] = true;
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m){
                if(!visited[nr][nc] && mapsC[nr][nc] != 'X'){
                    totalSum += dfs(nr, nc, visited, mapsC);
                }
            }
        }
        return totalSum;
    }
}
