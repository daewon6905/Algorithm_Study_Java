package 프로그래머스.신규아이디추천;

public class 신규아이디추천 {
    public String solution(String new_id) {
        String s  = new_id.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if((c>='a'&&c<='z') || (c>='0'&&c<='9')
                    || c=='.' || c=='_' || c=='-'){
                sb.append(c);
            }
        }
        String answer = sb.toString();
        sb = new StringBuilder();
        boolean mark = false;
        for(char c : answer.toCharArray()) {
            if (c == '.') {
                if (!mark) {
                    sb.append(c);
                    mark = true;
                }
            } else {
                sb.append(c);
                mark = false;
            }
        }
        if(sb.length()>0 && sb.charAt(0)=='.'){
            sb.deleteCharAt(0);
        }
        if(sb.length()>0 && sb.charAt(sb.length()-1)=='.'){
            sb.deleteCharAt(sb.length()-1);
        }
        if(sb.length()==0){
            sb.append('a');
        }
        answer = sb.toString();
        if(answer.length()>=16){
            answer = answer.substring(0,15);
            if(answer.charAt(answer.length()-1) == '.'){
                answer = answer.substring(0,answer.length()-1);
            }
        }
        while(answer.length()<3){
            answer += answer.charAt(answer.length()-1);
        }
        return answer;
    }
}
