package 백준.조합론.이항계수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 이항계수1 {
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        comb(1, n, k, new ArrayList<>());

        System.out.println(answer);
    }


    static void comb(int start, int n, int k, List<Integer> tmp) {
        if (tmp.size() == k) {
            answer++;
        }

        for (int i = start; i <= n; i++) {
            tmp.add(i);
            comb(i + 1, n, k, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
}
