package leetcode.pathWithMaximumProbability;

import java.util.*;

public class PathWithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<double[]>>graph = new ArrayList<>();
        double[]P = new double[n];
        Arrays.fill(P,0.0);
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        int idx = 0;
        for(int[]edge : edges){
            graph.get(edge[0]).add(new double[]{(double)edge[1],succProb[idx]});
            graph.get(edge[1]).add(new double[]{(double)edge[0],succProb[idx]});
            idx++;
        }
        Queue<double[]> pq = new PriorityQueue<>((x, y)->Double.compare(y[1],x[1]));
        P[start_node] = 1.0;
        pq.offer(new double[]{(double)start_node, 1.0});
        while(!pq.isEmpty()){
            double[]cur = pq.poll();
            double curNode = cur[0];
            double curP = cur[1];
            if(curP < P[(int)curNode]) continue;
            for(double[]nxt : graph.get((int)(curNode))){
                double nextNode = nxt[0];
                double nextP = nxt[1] * curP;
                if(nextP > P[(int)nextNode]){
                    P[(int)nextNode] = nextP;
                    pq.offer(new double[]{nextNode,nextP});
                }
            }
        }
        return P[end_node];
    }
}
