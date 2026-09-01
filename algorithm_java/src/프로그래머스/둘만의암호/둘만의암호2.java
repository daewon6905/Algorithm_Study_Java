package 프로그래머스.둘만의암호;

import java.util.ArrayList;
import java.util.List;

public class 둘만의암호2 {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        List<Character> valid = new ArrayList<>();
        for(char c='a';c<='z';c++){
            if(!skip.contains(String.valueOf(c))){
                valid.add(c);
            }
        }
        for(char c : s.toCharArray()){
            int curIdx = valid.indexOf(c);
            int nextIdx = (index + curIdx) % valid.size();
            sb.append(valid.get(nextIdx));
        }
        return sb.toString();
    }
}
