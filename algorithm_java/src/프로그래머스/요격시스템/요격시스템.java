package 프로그래머스.요격시스템;

import java.util.Arrays;
import java.util.Comparator;

public class 요격시스템 {
    public int solution(int[][] targets) {
        int count = 0;
        int last_shot = -1;
        Arrays.sort(targets, Comparator.comparingInt(a -> a[1]));

        for(int[]target : targets){
            if(target[0] >= last_shot){
                count++;
                last_shot = target[1];
            }
        }
        return count;
    }
}
