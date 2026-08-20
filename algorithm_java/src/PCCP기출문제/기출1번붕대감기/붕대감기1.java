package PCCP기출문제.기출1번붕대감기;

import java.util.HashMap;
import java.util.Map;

public class 붕대감기1 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int[]attack : attacks){
            int time = attack[0];
            int damage = attack[1];
            map.put(time,damage);
        }
        int n = map.size();
        int continuous = 0;
        int currentHealth = health;
        int attackCount = 0;
        for(int i=1;i<=1000;i++){
            if(attackCount == n) break;
            if(map.containsKey(i)){
                currentHealth -= map.get(i);
                attackCount++;
                continuous = 0;
                if(currentHealth <= 0){
                    currentHealth = -1;
                    break;
                }
                continue;
            }
            continuous++;
            currentHealth+=bandage[1];
            if(continuous == bandage[0]){
                continuous = 0;
                currentHealth += bandage[2];
            }
            if(currentHealth > health){
                currentHealth = health;
            }
            if(currentHealth <= 0){
                currentHealth = -1;
                break;
            }
        }

        return currentHealth;
    }
}
