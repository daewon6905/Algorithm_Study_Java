package 프로그래머스.미로탈출명령어;

public class 미로탈출명령어 {
    int[]dr = new int[]{1,0,0,-1};
    int[]dc = new int[]{0,-1,1,0};
    char[]command = new char[]{'d','l','r','u'};
    int n,m,x,y,r,c,k;
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        this.n = n;
        this.m = m;
        this.x = x;
        this.y = y;
        this.r = r;
        this.c = c;
        this.k = k;
        StringBuilder sb = new StringBuilder();
        int dist = Math.abs((r-c)) + Math.abs((x-y));
        if((k-dist)%2 != 0) return "impossible";
        if(dfs(x,y,sb)) return sb.toString();
        return "impossible";
    }
    boolean dfs(int sr, int sc, StringBuilder sb){
        if(Math.abs(r-sr) + Math.abs(c-sc) > k-sb.length()) return false;
        if(sb.length() == k){
            if(sr == r && sc == c){
                return true;
            }
            return false;
        }
        for(int i=0;i<4;i++){
            int nr = sr + dr[i];
            int nc= sc + dc[i];
            if(nr>=1&&nr<=n&&nc>=1&&nc<=m){
                sb.append(command[i]);
                if(dfs(nr,nc,sb)) return true;
                sb.deleteCharAt(sb.length()-1);
            }
        }
        return false;
    }
}
