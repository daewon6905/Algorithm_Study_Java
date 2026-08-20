package PCCP기출문제.기출1번붕대감기;

public class 붕대감기2 {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int castTime = bandage[0];
        int healPerSec = bandage[1];
        int bonusHeal = bandage[2];
        int currentHealth = health;
        int prevTime = 0;

        for(int[]attack : attacks){
            int attackTime = attack[0];
            int damage = attack[1];
            int timeGap = attackTime - prevTime - 1; //공격전까지 붕대 감은 시간
            if(timeGap > 0){
                int healOverTime = healPerSec * timeGap + ((timeGap/castTime) * bonusHeal);
                currentHealth = Math.min(health, currentHealth + healOverTime);
            }
            currentHealth -= damage;
            if(currentHealth <= 0) return -1;
            prevTime = attackTime;
        }

        return currentHealth;
    }
}
