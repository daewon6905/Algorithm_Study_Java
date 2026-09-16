package 프로그래머스.크기가작은부분문자열;

public class 크기가작은부분문자열 {
    public int solution(String t, String p) {
        int windowSize = p.length();
        int answer = 0;
        for(int left=0;left<t.length();left++){
            int right = left + windowSize;
            if(right > t.length()) break;
            String s = t.substring(left, right);
            if(Long.parseLong(p) >= Long.parseLong(s)) answer++;
        }
        return answer;
    }
}
