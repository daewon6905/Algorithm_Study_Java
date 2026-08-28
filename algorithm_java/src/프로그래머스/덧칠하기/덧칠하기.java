package 프로그래머스.덧칠하기;

import java.util.HashSet;
import java.util.Set;

public class 덧칠하기 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();

        for(int i=0;i<section.length;i++){
            int cur = section[i];
            if(!set.contains(cur)){
                set.add(cur);
                int colorUntil = cur + m -1;
                for(int j=i+1;j<section.length;j++){
                    if(section[j]<=colorUntil){
                        set.add(section[j]);
                    }
                }
                answer++;
            }
        }
        return answer;
    }
}
