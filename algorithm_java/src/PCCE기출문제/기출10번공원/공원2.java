package PCCE기출문제.기출10번공원;
import java.util.*;


//1번째 풀이에서 더 최적화된 풀이
public class 공원2 {
    int n;
    int m;
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        n = park.length;
        m = park[0].length;
        Arrays.sort(mats);
        for(int k=mats.length-1;k>=0;k--){
            for(int i=0;i<=n-mats[k];i++){
                for(int j=0;j<=m-mats[k];j++){
                    if(check(i,j,mats[k],park)){
                        return mats[k];
                    }
                }
            }
        }
        return -1;
    }
    public boolean check(int r, int c, int len, String[][]park){
        for(int i=r;i<r+len;i++){
            for(int j=c;j<c+len;j++){
                if(!park[i][j].equals("-1")) return false;
            }
        }
        return true;
    }
}
