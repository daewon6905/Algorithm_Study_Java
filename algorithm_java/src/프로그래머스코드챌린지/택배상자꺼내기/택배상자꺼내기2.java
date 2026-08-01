package 프로그래머스코드챌린지.택배상자꺼내기;

public class 택배상자꺼내기2 {
    public int solution(int n, int w, int num) {
        int row = (num - 1) / w;
        int col;

        if (row % 2 == 0) {
            col = (num - 1) % w;
        } else {
            col = w - 1 - ((num - 1) % w);
        }

        int totalRows = (n + w - 1) / w;

        int count = 0;

        for (int r = row; r < totalRows; r++) {
            int value;

            if (r % 2 == 0) {
                value = r * w + col + 1;
            } else {
                value = r * w + (w - col);
            }

            if (value <= n) count++;
        }

        return count;
    }
}

