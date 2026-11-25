package 백준.조합론;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 다리놓기 {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            List<List<Integer>> comb = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            sb.append(comb(m, n)).append("\n");
        }
        System.out.println(sb);
    }

    static int comb(int n, int r) {
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        if (r == n || r == 0) {
            return 1;
        }
        //조합의 성질 사용으로 dp 적용 가능.
        return dp[n][r] = comb(n - 1, r) + comb(n - 1, r - 1);
    }
}
