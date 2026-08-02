package 프로그래머스코드챌린지.홀짝트리;

import java.util.*;

public class 홀짝트리 {
    int[]answer;
    public int[] solution(int[] nodes, int[][] edges) {
        answer = new int[2];
        Map<Integer, List<Integer>>tree = new HashMap<>();

        for(int node : nodes){
            tree.put(node, new ArrayList<>());
        }
        for(int[]edge : edges){
            tree.get(edge[0]).add(edge[1]);
            tree.get(edge[1]).add(edge[0]);
        }

        for(int root : nodes){
            Set<Integer>visited = new HashSet<>();
            int index = bfs(root, tree, visited);
            if(index != -1) answer[index]++;
        }
        return answer;
    }
    public int getMark(int node, int size, boolean isRoot){
        int mark;
        int childCount = isRoot ? size : size - 1;
        if(isEven(node)){
            mark = isEven(childCount) ? 0 : 1;
        }else{
            mark = !isEven(childCount) ? 0 : 1;
        }
        return mark;
    }
    public int bfs(int start, Map<Integer, List<Integer>> tree, Set<Integer> visited){
        Queue<int[]> queue = new ArrayDeque<>();
        List<Integer>child = tree.get(start);
        int mark = getMark(start, child.size(), true);
        queue.offer(new int[]{start,mark});
        visited.add(start);
        while(!queue.isEmpty()){
            int[]cur = queue.poll();
            int curNode = cur[0];
            int m = cur[1];
            for(int next : tree.get(curNode)){
                if(!visited.contains(next)){
                    List<Integer>nextChild = tree.get(next);
                    int nextMark = getMark(next, nextChild.size(),false);
                    if(nextMark == m){
                        visited.add(next);
                        queue.offer(new int[]{next, nextMark});
                    }else{
                        return -1;
                    }
                }
            }
        }
        return mark;
    }
    public boolean isEven(int nodeNum){
        return nodeNum%2==0;
    }
}
