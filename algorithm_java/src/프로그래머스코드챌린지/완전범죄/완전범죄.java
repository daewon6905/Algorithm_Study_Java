package 프로그래머스코드챌린지.완전범죄;

import java.util.Arrays;

public class 완전범죄 {
    int n;
    int m;
    int L;
    int answer;
    int[][]info;
    int[][]memo;
    public int solution(int[][] info, int n, int m) {
        this.n = n;
        this.m = m;
        this.info = info;
        answer = Integer.MAX_VALUE;
        L = info.length;
        memo = new int[L+1][n];
        for(int i=0;i<=L;i++){
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        dfs(0,0,0);

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public void dfs(int index, int A, int B){
        if(A >= n || B >= m){
            return;
        }
        if(A >= answer) return;
        if(memo[index][A] <= B){
            return;
        }
        memo[index][A] = B;
        if(index == L){
            answer = Math.min(answer, A);
            return;
        }
        //a가 훔침
        dfs(index+1, A+info[index][0], B);

        //b가 훔침
        dfs(index+1, A, B+info[index][1]);
    }
}
