package 프로그래머스.문자열나누기;

public class 문자열나누기 {
    public int solution(String s) {
        if(s.length() == 1) return 1;
        int answer = 0;
        int left = 0;
        int right = 1;
        int countx = 1;
        int countn = 0;

        while(right<=s.length()-1){
            String x = s.substring(left, left+1);
            String n = s.substring(right, right+1);
            if(n.equals(x)){
                countx++;
                right++;
            }
            if(!n.equals(x)){
                countn++;
                right++;
            }
            if(countx == countn){
                answer++;
                countx = 1;
                countn = 0;
                left = right;
                right++;
            }
        }
        //반례 조심 abaa 처럼 동일 문자로 끝나거나 하나의 문자만 남은 경우(left가 끝까지 온 경우) +1 해줘야함
        if((left == s.length()-1) || (right >= s.length() && countx > 1)) answer++;
        return answer;
    }
}
