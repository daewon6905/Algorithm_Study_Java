package 프로그래머스.연속펄스부분수열의합;

public class 연속펄스부분수열의합2 {
    public long solution(int[] sequence) {
        int n = sequence.length;
        long answer = 0;
        long[][]dp = new long[2][n];
        dp[0][0] = sequence[0];
        dp[1][0] = -sequence[0];
        answer = Math.max(dp[0][0] , dp[1][0]);
        for(int i=1;i<n;i++){
            int pulse = (i%2==0 ? 1 : -1);
            long v1 = (long)(sequence[i] * pulse);
            long v2 = (long)(sequence[i] * -pulse);
            dp[0][i] = Math.max(v1, v1 + dp[0][i-1]);
            dp[1][i] = Math.max(v2, v2 + dp[1][i-1]);

            answer = Math.max(answer, Math.max(dp[0][i] , dp[1][i]));
        }
        return answer;
    }
}
