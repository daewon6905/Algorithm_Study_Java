package 프로그래머스코드챌린지.지게차와크레인;
import java.util.*;

public class 지게차와크레인 {
    int n;
    int m;
    int[]dr = new int[]{0,1,0,-1};
    int[]dc = new int[]{1,0,-1,0};
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        char[][]storageC = new char[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                storageC[i][j] = storage[i].charAt(j);
            }
        }
        for(String r : requests){
            if(r.length() == 1){
                command1(r.charAt(0),storageC);
            }else{
                command2(r.charAt(0),storageC);
            }
        }
        int count = 0;
        for(char[]arr : storageC){
            for(char c : arr){
                if(c != '.') count++;
            }
        }
        return count;
    }
    boolean isBorder(int r, int c){
        if(r==0 || c==0 || r==n-1 || c==m-1) return true;
        return false;
    }
    boolean isOpen(int r, int c, char[][]storageC){
        List<int[]>startingPoints = new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isBorder(i,j) && storageC[i][j] == '.') startingPoints.add(new int[]{i,j});
            }
        }

        for(int[]sp : startingPoints){
            boolean[][]visited = new boolean[n][m];
            if(dfs(sp[0],sp[1],r,c,storageC,visited)) return true;
        }
        return false;
    }
    boolean dfs(int r, int c, int tr, int tc, char[][]storageC, boolean[][]visited){
        visited[r][c] = true;
        for(int i=0;i<4;i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr==tr && nc==tc) return true;
            if(nr>=0 && nr<n && nc>=0 && nc<m){
                if(!visited[nr][nc] && storageC[nr][nc] == '.'){
                    if(dfs(nr,nc,tr,tc,storageC,visited)) return true;
                }
            }
        }
        return false;
    }
    public void command1(char target, char[][]storageC){
        List<int[]>possibleRemoval = new ArrayList<>();
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(storageC[r][c] == target){
                    if(isBorder(r,c) || isOpen(r,c,storageC)){
                        possibleRemoval.add(new int[]{r,c});
                    }
                }
            }
        }
        for(int[]pr : possibleRemoval){
            storageC[pr[0]][pr[1]] = '.';
        }
    }
    public void command2(char target, char[][]storageC){
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(storageC[i][j] == target) storageC[i][j] = '.';
            }
        }
    }
}
