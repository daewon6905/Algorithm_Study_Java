package 프로그래머스코드챌린지.택배상자꺼내기;

public class 택배상자꺼내기 {
    public int solution(int n, int w, int num) {
        int[][] boxes;
        int d = n % w;
        int boxNum = 1;
        int count = 0;

        if (d == 0) {
            boxes = new int[n / w][w];
        } else {
            boxes = new int[n / w + 1][w];
        }

        int rL = boxes.length;
        int cL = boxes[0].length;

        outer:
        for (int r = rL - 1; r >= 0; r--) {
            if (rL % 2 == 0) {
                if (r % 2 != 0) {
                    for (int c = 0; c < cL; c++) {
                        boxes[r][c] = boxNum++;
                        if (boxNum > n) break outer;
                    }
                } else {
                    for (int c = cL - 1; c >= 0; c--) {
                        boxes[r][c] = boxNum++;
                        if (boxNum > n) break outer;
                    }
                }
            } else {
                if (r % 2 == 0) {
                    for (int c = 0; c < cL; c++) {
                        boxes[r][c] = boxNum++;
                        if (boxNum > n) break outer;
                    }
                } else {
                    for (int c = cL - 1; c >= 0; c--) {
                        boxes[r][c] = boxNum++;
                        if (boxNum > n) break outer;
                    }
                }
            }
        }

        for (int i = 0; i < rL; i++) {
            for (int j = 0; j < cL; j++) {
                if (boxes[i][j] == num) {
                    for (int r = i; r >= 0; r--) {
                        if (boxes[r][j] != 0) count++;
                    }
                }
            }
        }
        return count;
    }
}

