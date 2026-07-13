package 프로그래머스.디스크컨트롤러;
import java.util.*;

public class 디스크컨트롤러 {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        int m = jobs[0].length;
        int turnAroundTime = 0;
        int time = 0;
        int completedJobs = 0;
        int idx = 0;
        Arrays.sort(jobs,(a,b)->a[0]-b[0]);
        Queue<int[]>pq = new PriorityQueue<>((x,y)->{
            if(x[1]!=y[1]) return x[1]-y[1];
            if(x[0]!=y[0]) return x[0]-y[0];
            return x[2]-y[2];
        });
        while(completedJobs < n){
            while(idx < n &&time >= jobs[idx][0]){
                pq.offer(new int[]{jobs[idx][0],jobs[idx][1],idx});
                idx++;
            }
            if(!pq.isEmpty()){
                int[]cur = pq.poll();
                int requestTime = cur[0];
                int duration = cur[1];
                time += duration;
                turnAroundTime += time - requestTime;
                completedJobs++;
            }else{
                time = jobs[idx][0];
            }
        }
        return turnAroundTime / n;
    }
}
