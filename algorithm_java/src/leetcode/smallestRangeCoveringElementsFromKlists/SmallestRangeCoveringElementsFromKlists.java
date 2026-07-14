package leetcode.smallestRangeCoveringElementsFromKlists;

import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SmallestRangeCoveringElementsFromKlists {
    public int[] smallestRange(List<List<Integer>> nums) {
        int[]range = new int[2];
        int minRange = Integer.MAX_VALUE;
        int currentMax = Integer.MIN_VALUE;
        Queue<int[]> pq = new PriorityQueue<>((x, y)->Integer.compare(x[0],y[0]));
        for(int i=0;i<nums.size();i++){
            List<Integer> num = nums.get(i);
            if(num.get(0) > currentMax) currentMax = num.get(0);
            pq.offer(new int[]{num.get(0),i,0});
        }

        while(!pq.isEmpty()){
            int[]cur = pq.poll();
            int num = cur[0];
            int listIdx = cur[1];
            int idx = cur[2];
            if(currentMax-num<minRange || currentMax-num==minRange && num<range[0]){
                minRange = currentMax - num;
                range[0] = num;
                range[1] = currentMax;
            }
            if(idx == nums.get(listIdx).size()-1) break;
            int nextVal = nums.get(listIdx).get(++idx);
            currentMax = Math.max(currentMax, nextVal);
            pq.offer(new int[]{nextVal,listIdx,idx});
        }
        return range;
    }
}
