package 프로그래머스.호텔대실;
import java.util.*;

class Room{
    int startTime;
    int endTime;
    public Room(int startTime, int endTime){
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
public class 호텔대실 {
    public int solution(String[][] book_time) {
        int answer = 0;
        Arrays.sort(book_time, (a,b) -> (timeToMin(a[0]) - timeToMin(b[0])));
        Queue<Room>pq = new PriorityQueue<>((a,b) -> a.endTime - b.endTime);
        for(String[]bt : book_time){
            int start = timeToMin(bt[0]);
            int end = timeToMin(bt[1]);
            if(!pq.isEmpty() && (pq.peek().endTime+10 <= start)){
                pq.poll();
                pq.offer(new Room(start, end));
            }else{
                pq.offer(new Room(start, end));
                answer++;
            }
        }

        return answer;
    }

    public int timeToMin(String time){
        String[]arr = time.split(":");
        int hour = Integer.parseInt(arr[0]);
        int min = Integer.parseInt(arr[1]);
        return 60*hour + min;
    }
}
