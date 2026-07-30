package 프로그래머스코드챌린지.서버증설횟수;

public class 서버증설횟수 {
    public int solution(int[] players, int m, int k) {
        int len = players.length;
        int[]addedServer = new int[len];
        int count = 0;
        for(int i=0;i<len;i++){
            int currentTimePlayers = players[i];
            int extraServerNeeded = currentTimePlayers/m;
            if(extraServerNeeded<=addedServer[i])continue;
            if(extraServerNeeded>0){
                int remainder = extraServerNeeded-addedServer[i];
                count+=remainder;
                int j=0;
                while((j<k) && (i+j<len)){
                    addedServer[i+j]+=remainder;
                    j++;
                }
            }
        }
        return count;
    }
}
