package 백준.구현.체스판다시칠하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 체스판다시칠하기 {
    static int n;
    static int m;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (checkBorder(i, j)) {
                    min = Math.min(min, count(i,j));
                }
            }
        }
        System.out.println(min);
    }

    static int count(int r, int c) {
        int count1 = 0;
        int count2 = 0;
        for (int i = r; i < r + 8; i++) {
            for (int j = c; j < c + 8; j++) {
                char expected = (i + j) % 2 == 0 ? 'W' : 'B';
                if (board[i][j] != expected) count1++;
            }
        }
//        for (int i = r; i < r + 8; i++) {
//            for (int j = c; j < c + 8; j++) {
//                char expected = (i + j) % 2 == 0 ? 'B' : 'W';
//                if (board[i][j] != expected) count2++;
//            }
//        }
        return Math.min(count1, 64-count1);
    }

    static boolean checkBorder(int r, int c) {
        return r + 7 < n && c + 7 < m;
    }
}
