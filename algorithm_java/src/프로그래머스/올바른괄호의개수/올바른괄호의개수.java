package 프로그래머스.올바른괄호의개수;

public class 올바른괄호의개수 {
    int answer = 0;
    int n;
    public int solution(int n) {
        this.n = n;
        dfs(0,0);
        return answer;
    }
    public void dfs(int open, int close){
        if(open == n && close == n){
            answer++;
            return;
        }
        if(open < n){
            dfs(open + 1,close);
        }
        //열린 괄호가 있을때만 닫힌 괄호가 가능하게
        if(close < open){
            dfs(open, close + 1);
        }
    }
}
