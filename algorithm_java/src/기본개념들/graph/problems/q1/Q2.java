package 기본개념들.graph.problems.q1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

//bfs 활용 풀이
public class Q2 {
    public boolean solution(int[][] friends) {
        int n = friends.length;
        int[]color = new int[n];
        Arrays.fill(color,-1);

        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(!bfs(i,friends,color)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean bfs(int start, int[][]friends, int[]color){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        color[start] = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int next : friends[cur]){
                if(color[next] == color[cur]){
                    return false;
                }
                if(color[next] == -1){
                    color[next] = 1 - color[cur];
                    queue.offer(next);;
                }
            }
        }
        return true;
    }
}
