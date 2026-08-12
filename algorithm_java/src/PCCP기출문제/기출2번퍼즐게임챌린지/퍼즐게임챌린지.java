package PCCP기출문제.기출2번퍼즐게임챌린지;

public class 퍼즐게임챌린지 {
    public int solution(int[] diffs, int[] times, long limit) {
        int n = diffs.length;
        int max = 0;
        for(int d : diffs){
            max = Math.max(max, d);
        }
        int left = 1;
        int right = max;
        int answer = max;
        while(left<right){
            int level = (left+right) / 2;
            long timeUsed = 0;
            for(int i=0;i<n;i++){
                if(level >= diffs[i]){
                    timeUsed += times[i];
                }else{
                    timeUsed += (long) (times[i] + times[i - 1]) * (diffs[i] - level) + times[i];
                }
            }
            if(timeUsed <= limit){
                answer = Math.min(answer, level);
                right = level;
            }else{
                left = level + 1;
            }
        }
        return answer;
    }
}
