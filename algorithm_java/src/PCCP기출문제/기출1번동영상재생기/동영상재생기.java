package PCCP기출문제.기출1번동영상재생기;

public class 동영상재생기 {
    int openStart;
    int openEnd;
    int finalTime;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLen = convertTimeToSeconds(video_len);
        int start = convertTimeToSeconds(pos);
        finalTime = start;
        openStart = convertTimeToSeconds(op_start);
        openEnd = convertTimeToSeconds(op_end);
        moveToOpEnd();
        for(String c : commands){
            if(c.equals("prev")){
                finalTime -= 10;
                if(finalTime<=0) finalTime = 0;
            }
            if(c.equals("next")){
                finalTime += 10;
                if(finalTime>=videoLen) finalTime = videoLen;
            }
            moveToOpEnd();
        }
        return String.format("%02d:%02d",finalTime/60,finalTime%60);
    }
    public void moveToOpEnd(){
        if(finalTime>=openStart && finalTime<=openEnd){
            finalTime = openEnd;
        }
    }
    public int convertTimeToSeconds(String time){
        String[]arr = time.split(":");
        return Integer.parseInt(arr[0])*60 + Integer.parseInt(arr[1]);
    }
    // public String convertSecondsToTime(int seconds){
    //     String min = String.valueOf(seconds/60);
    //     String sec = String.valueOf(seconds%60);
    //     StringBuilder sb = new StringBuilder();
    //     if(Integer.parseInt(min)<10) min = "0" + min;
    //     if(Integer.parseInt(sec)<10) sec = "0" + sec;
    //     return sb.append(min).append(":").append(sec).toString();
    // }
}
