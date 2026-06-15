package graph.problems.q2;

public class Q2 {
    public int solution(int[] coins, int amount) {
        int result = recursive(coins,amount);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    int recursive(int[] coins, int n){
        if(n == 0){
            return 0;
        }
        if(n < 0){
            return Integer.MAX_VALUE;
        }
        int minCoins = Integer.MAX_VALUE;
        for(int coin : coins){
            int cur = recursive(coins,n-coin);
            if(cur != Integer.MAX_VALUE){
                minCoins = Math.min(minCoins, cur+1);
            }
        }
        return minCoins;
    }
}
