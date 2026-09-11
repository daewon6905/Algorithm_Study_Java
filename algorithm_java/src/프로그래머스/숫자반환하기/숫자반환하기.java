package 프로그래머스.숫자반환하기;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class 숫자반환하기 {
    int n;
    public int solution(int x, int y, int n) {
        this.n = n;
        Queue<int[]> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{x,0});

        while(!queue.isEmpty()){
            int[]cur = queue.poll();
            int num = cur[0];
            int count = cur[1];
            if(num == y) return count;
            for(int i=0;i<3;i++){
                int res = calc(i, num);
                if(res <= y && !visited.contains(res)){
                    visited.add(res);
                    queue.offer(new int[]{res, count+1});
                }
            }
        }
        return -1;
    }

    public int calc(int index, int num){
        if(index == 0) return num + n;
        if(index == 1) return 2*num;
        if(index == 2) return 3*num;
        return 0;
    }
}
