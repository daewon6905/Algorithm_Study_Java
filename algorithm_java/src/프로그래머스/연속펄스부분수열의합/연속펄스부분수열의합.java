package 프로그래머스.연속펄스부분수열의합;

import java.util.Arrays;

public class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        int n = sequence.length;
        int[][]arr = new int[2][n];
        arr[0] = Arrays.copyOf(sequence,n);
        arr[1] = Arrays.copyOf(sequence,n);

        for(int i=0;i<n;i++){
            if(i%2==0){
                arr[0][i] *= 1;
                arr[1][i] *= -1;
            }else{
                arr[0][i] *= -1;
                arr[1][i] *= 1;
            }
        }
        return Math.max(kadane(arr[0]), kadane(arr[1]));
    }
    public long kadane(int[]a){
        long global_max = a[0];
        long current_max = a[0];

        for(int i=1;i<a.length;i++){
            current_max = Math.max(a[i], current_max + a[i]);
            global_max = Math.max(global_max, current_max);
        }
        return global_max;
    }
}
