package leetcode.courseSchedule;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>>graph = new ArrayList<>();
        boolean[]visited = new boolean[numCourses];
        int[]indegrees = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]p : prerequisites){
            int from = p[1];
            int to = p[0];
            graph.get(from).add(to);
            indegrees[to]++;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(indegrees[i] == 0){
                visited[i] = true;
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int nxt : graph.get(cur)){
                if(!visited[nxt]){
                    indegrees[nxt]--;
                    if(indegrees[nxt] == 0){
                        visited[nxt] = true;
                        queue.offer(nxt);
                    }
                }
            }
        }
        for(boolean bool : visited){
            if(!bool) return false;
        }
        return true;
    }
}
