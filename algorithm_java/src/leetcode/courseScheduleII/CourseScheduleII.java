package leetcode.courseScheduleII;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[]answer = new int[numCourses];
        int[]indegrees = new int[numCourses];
        int count = 0;
        List<List<Integer>>graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]p : prerequisites){
            indegrees[p[0]]++;
            graph.get(p[1]).add(p[0]);
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i] == 0){
                queue.offer(i);
                count++;
            }
        }
        int idx = 0;
        while(!queue.isEmpty()){
            int cur = queue.poll();
            answer[idx] = cur;
            idx++;
            for(int nxt : graph.get(cur)){
                indegrees[nxt]--;
                if(indegrees[nxt] == 0){
                    queue.offer(nxt);
                    count++;
                }
            }
        }
        return count==numCourses ? answer : new int[0];
    }
}
