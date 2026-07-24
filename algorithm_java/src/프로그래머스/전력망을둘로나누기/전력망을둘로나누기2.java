package 프로그래머스.전력망을둘로나누기;

import java.util.ArrayList;
import java.util.List;

public class 전력망을둘로나누기2 {
    public int solution(int n, int[][] wires) {
        List<List<Integer>>tree = new ArrayList<>();
        int[]subtree = new int[n+1];
        for(int i=0;i<=n;i++){
            tree.add(new ArrayList<>());
        }
        for(int[]wire : wires){
            tree.get(wire[0]).add(wire[1]);
            tree.get(wire[1]).add(wire[0]);
        }
        subtreeCount(1,1,tree,subtree);
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            answer = Math.min(answer, Math.abs(n - 2*subtree[i]));
        }
        return answer;
    }
    int subtreeCount(int cur, int parent, List<List<Integer>>tree, int[]subtree){
        subtree[cur] = 1;
        for(int nxt : tree.get(cur)){
            if(nxt != parent) subtree[cur] += subtreeCount(nxt, cur, tree, subtree);
        }
        return subtree[cur];
    }
}
