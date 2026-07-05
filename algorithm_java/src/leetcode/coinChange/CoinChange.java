package leetcode.coinChange;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Queue<int[]> queue = new ArrayDeque<>();
        Set<Integer> set = new HashSet<>();
        queue.offer(new int[]{amount,0});
        set.add(amount);

        while(!queue.isEmpty()){
            int[]cur = queue.poll();
            int remain = cur[0];
            int count = cur[1];
            if(remain == 0) return count;
            for(int coin : coins){
                int nremain = remain - coin;
                if(nremain>=0 && !set.contains(nremain)){
                    queue.offer(new int[]{nremain,count+1});
                    set.add(nremain);
                }
            }
        }
        return -1;
    }
}
