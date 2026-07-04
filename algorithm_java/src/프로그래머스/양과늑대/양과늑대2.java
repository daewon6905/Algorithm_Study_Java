package 프로그래머스.양과늑대;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class State{
    int wolf;
    int sheep;
    List<Integer> candidates;
    public State(int wolf,int sheep,List<Integer>candidates){
        this.wolf = wolf;
        this.sheep = sheep;
        this.candidates = candidates;
    }
}
public class 양과늑대2 {
    int maxSheep = 0;
    public int solution(int[] info, int[][] edges) {
        List<List<Integer>>tree = new ArrayList<>();
        for(int i=0;i<info.length;i++){
            tree.add(new ArrayList<>());
        }
        for(int[]e : edges){
            tree.get(e[0]).add(e[1]);
        }
        List<Integer>initialCand = new ArrayList<>();
        initialCand.addAll(tree.get(0));
        Queue<State> queue = new ArrayDeque<>();
        queue.offer(new State(0,1,initialCand));
        while(!queue.isEmpty()){
            State cur = queue.poll();
            maxSheep = Math.max(maxSheep,cur.sheep);

            for(int i=0;i<cur.candidates.size();i++){
                int next = cur.candidates.get(i);
                int nw = cur.wolf;
                int ns = cur.sheep;
                if(info[next] == 1){
                    nw++;
                }else{
                    ns++;
                }
                if(nw >= ns) continue;
                List<Integer>cand = new ArrayList<>(cur.candidates);
                cand.remove(i);
                cand.addAll(tree.get(next));
                queue.offer(new State(nw,ns,cand));
            }

        }
        return maxSheep;
    }
}
