package 프로그래머스.덧칠하기;

public class 덧칠하기2 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int colorUntil = 0;

        for(int i=0;i<section.length;i++){
            int cur = section[i];
            if(cur > colorUntil){
                colorUntil = cur + m - 1;
                answer++;
            }
        }
        return answer;
    }
}
