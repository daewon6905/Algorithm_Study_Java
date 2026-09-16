package 프로그래머스.마법의엘리베이터;

public class 마법의엘리베이터 {
    public int solution(int storey) {
        int answer = 0;
        while(storey > 0){
            int remainder = storey%10;
            int next = (storey/10)%10;
            if(remainder>5){
                answer += (10-remainder);
                storey += 10;
            }else if(remainder == 5){
                if(next >= 5){
                    answer += (10-remainder);
                    storey+=10;
                }else{
                    answer += remainder;
                }
            }else{
                answer += remainder;
            }
            storey/=10;
        }
        return answer;
    }
}
