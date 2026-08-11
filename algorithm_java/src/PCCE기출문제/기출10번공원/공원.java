package PCCE기출문제.기출10번공원;

public class 공원 {
    int n;
    int m;
    public int solution(int[] mats, String[][] park) {
        int answer = 0;
        n = park.length;
        m = park[0].length;
        for(int mat : mats){
            for(int i=0;i<=n-mat;i++){
                for(int j=0;j<=m-mat;j++){
                    if(park[i][j].equals("-1")){
                        if(check(i,j,mat,park)){
                            answer = Math.max(answer,mat);
                        }
                    }
                }
            }
        }

        return answer == 0 ? -1 : answer;
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
