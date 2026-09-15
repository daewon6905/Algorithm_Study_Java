package 프로그래머스.인사고과;

import java.util.Arrays;

public class 인사고과 {
    public int solution(int[][] scores) {
        int wanho = scores[0][0] + scores[0][1];
        int wanhoPeer = scores[0][1];
        Arrays.sort(scores, (a, b) -> {
            if(a[0] != b[0]){
                return b[0] - a[0];
            }
            return a[1] - b[1];
        });
        int maxPeer = scores[0][1];
        int rank = 0;
        for(int[]score : scores){
            int currentSum = score[0] + score[1];
            maxPeer = Math.max(maxPeer, score[1]);
            if(score[1] < maxPeer){
                if(score[1] == wanhoPeer && currentSum == wanho) return -1;
                continue;
            }
            if(currentSum == wanho) continue;
            if(currentSum > wanho) rank++;

        }
        return rank+1;
    }
}
