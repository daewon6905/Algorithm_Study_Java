package 프로그래머스.테이블해시함수;

import java.util.Arrays;

public class 테이블해시함수 {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (a, b) ->{
            if(a[col-1] != b[col-1]){
                return a[col-1] - b[col-1];
            }
            return b[0] - a[0];
        });
        int answer = 0;
        for(int i=row_begin;i<=row_end;i++){
            int hash = getHash(i, data[i-1]);
            answer = answer^hash;
        }
        return answer;
    }
    public int getHash(int i, int[]d){
        int res = 0;
        for(int j=0;j<d.length;j++){
            res += (d[j]%i);
        }
        return res;
    }
}
