package 프로그래머스.디펜스게임;

import java.util.PriorityQueue;

public class 디펜스게임 {
    public int solution(int n, int k, int[] enemy) {
        int answer = k;
        int count = 0;
        if(k >= enemy.length) return enemy.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->a-b);

        for(int e : enemy){
            pq.offer(e);
            if(pq.size() > k){
                int nextLeast = pq.poll();
                n -= nextLeast;
                if(n>=0){
                    count++;
                }else{
                    break;
                }
            }
        }
        return answer + count;
    }
}
