package 프로그래머스코드챌린지.유연근무제;

public class 유연근무제 {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        int sL = schedules.length;
        int n = timelogs.length;

        for(int i=0;i<n;i++){
            int startTime = schedules[i];
            int[]timelog = timelogs[i];
            int count = 0;
            int dayIndex = startday;
            for(int j=0;j<7;j++){
                if((j+startday)%7 == 0 || (j+startday)%7 == 6){
                    count++;
                    continue;
                }
                if(isOnTime(startTime, timelog[j])) count++;
            }
            if(count == 7) answer++;
        }
        return answer;
    }
    public boolean isOnTime(int startTime, int arrivalTime){
        int hour = startTime / 100;
        int min = startTime % 100;
        int t;
        if(min + 10 >= 60){
            hour++;
            min = (min+10) % 60;
            t = 100 * hour + min;
        }else{
            t = startTime + 10;
        }
        return arrivalTime <= t;
    }
}
