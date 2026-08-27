package 프로그래머스.과제진행하기;
import java.util.*;
class Assignment{
    String name;
    int start;
    int duration;

    public Assignment(String name, int start, int duration){
        this.name = name;
        this.start = start;
        this.duration = duration;
    }
}

public class 과제진행하기 {
    public String[] solution(String[][] plans) {
        List<String>answerList = new ArrayList<>();
        Arrays.sort(plans, (a,b) -> timeToMin(a[1]) - timeToMin(b[1]));
        Deque<Assignment>stack = new ArrayDeque<>();
        int nowTime = timeToMin(plans[0][1]);

        for(int i=0;i<plans.length;i++){
            String name = plans[i][0];
            int start = timeToMin(plans[i][1]);
            int duration = Integer.parseInt(plans[i][2]);

            while(!stack.isEmpty() && nowTime <= start){
                Assignment a = stack.pop();
                int endTime = nowTime + a.duration;
                if(endTime <= start){
                    answerList.add(a.name);
                    nowTime = endTime;
                }else{
                    int done = start - nowTime;
                    a.duration -= done;
                    nowTime = start;
                    stack.push(a);
                    break;
                }
            }
            stack.push(new Assignment(name, start, duration));
            nowTime = start;
        }
        while(!stack.isEmpty()){
            Assignment a = stack.pop();
            answerList.add(a.name);
        }
        return answerList.stream().toArray(String[]::new);
    }

    public int timeToMin(String time){
        String hour = time.split(":")[0];
        String min = time.split(":")[1];
        return Integer.parseInt(hour)*60 + Integer.parseInt(min);
    }
}
